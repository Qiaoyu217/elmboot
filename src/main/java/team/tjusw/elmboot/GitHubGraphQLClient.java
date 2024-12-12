package team.tjusw.elmboot;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GitHubGraphQLClient {

    private static final String GITHUB_GRAPHQL_URL = System.getenv("GITHUB_GRAPHQL_URL");
    private static final String GITHUB_TOKEN = System.getenv("GITHUB_TOKEN"); // 确保环境变量已设置

    public static void main(String[] args) {
        String keyword = "machine learning"; // 给定的搜索关键词
        try {
            List<String> repositoryUrls = getTopRepositoriesByKeyword(keyword);
            repositoryUrls.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getTopRepositoriesByKeyword(String keyword) throws IOException {
        String query = buildGraphQLQuery(escapeKeyword(keyword));
        String responseJson = executeGraphQLQuery(query);

        return parseRepositoryUrls(responseJson);
    }

    private static String buildGraphQLQuery(String keyword) {
        return "{"
                + " search(query: \"" + keyword + "\", type: REPOSITORY, first: 10) {"
                + "   edges {"
                + "     node {"
                + "       ... on Repository {"
                + "         name"
                + "         owner {"
                + "           login"
                + "         }"
                + "         url"
                + "       }"
                + "     }"
                + "   }"
                + " }"
                + "}";
    }

    private static String escapeKeyword(String keyword) {
        return keyword.replaceAll("(["'\\])", "\\\\$1");
    }

    private static List<String> parseRepositoryUrls(String json) throws IOException {
        List<String> urls = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(json);
        JsonNode dataNode = rootNode.path("data");
        if (!dataNode.isMissingNode()) {
            JsonNode searchNode = dataNode.path("search");
            if (!searchNode.isMissingNode()) {
                JsonNode edgesNode = searchNode.path("edges");
                // 继续处理
                for (JsonNode edge : edgesNode) {
                    JsonNode node = edge.path("node");
                    String name = node.path("name").asText();
                    String owner = node.path("owner").path("login").asText();
                    String url = node.path("url").asText();

                    urls.add(url);
                }
            }
        }
        return urls;
    }
}
