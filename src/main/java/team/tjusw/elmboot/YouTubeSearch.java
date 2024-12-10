package team.tjusw.elmboot;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class YouTubeRedditSearch {

    private static final String YOUTUBE_API_KEY = System.getenv("YOUTUBE_API_KEY");  // Replace with your YouTube API key
    private static final String YOUTUBE_API_URL = "https://www.googleapis.com/youtube/v3/search";
    private static final String REDDIT_API_URL = "https://www.reddit.com/r/all/search.json";

    public static void main(String[] args) {
        String keyword = "programming tutorial";  // Replace with your desired search keyword
        YouTubeRedditSearch searcher = new YouTubeRedditSearch();
        searcher.getTopVideos(keyword);
        searcher.fetchTopRedditPosts(keyword);
    }

    // Get the top 10 YouTube videos for the given keyword
    public void getTopVideos(String keyword) {
        try {
            // Construct the YouTube API request URL
            String url = YOUTUBE_API_URL + "?part=snippet&q=" + URLEncoder.encode(keyword, StandardCharsets.UTF_8) +
                    "&type=video&order=viewCount&maxResults=10&key=" + URLEncoder.encode(YOUTUBE_API_KEY, StandardCharsets.UTF_8);

            // Initialize OkHttp client
            OkHttpClient client = new OkHttpClient();

            // Create the request
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            // Send the request and get the response
            Response response = client.newCall(request).execute();

            if (response.isSuccessful()) {
                // Parse the JSON response
                JSONObject jsonResponse = new JSONObject(response.body().string());
                JSONArray items = jsonResponse.getJSONArray("items");

                // Output the top 10 video URLs
                System.out.println("Top 10 YouTube Videos for keyword: " + keyword);
                for (int i = 0; i < items.length(); i++) {
                    JSONObject video = items.getJSONObject(i);
                    String videoId = video.getJSONObject("id").getString("videoId");
                    String videoUrl = "https://www.youtube.com/watch?v=" + videoId;
                    System.out.println((i + 1) + ". " + videoUrl);
                }
            } else {
                System.out.println("Error: Unable to fetch YouTube data.");
            }

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    // Get the top 10 Reddit posts for the given keyword
    public void fetchTopRedditPosts(String keyword) {
        try {
            // Construct the Reddit API request URL
            String url = REDDIT_API_URL + "?q=" + URLEncoder.encode(keyword, StandardCharsets.UTF_8) + "&limit=10";

            // Initialize OkHttp client
            OkHttpClient client = new OkHttpClient();

            // Create the request
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            // Send the request and get the response
            Response response = client.newCall(request).execute();

            if (response.isSuccessful()) {
                // Parse the JSON response
                JSONObject jsonResponse = new JSONObject(response.body().string());
                JSONArray posts = jsonResponse.getJSONObject("data").getJSONArray("children");

                // Output the top 10 Reddit post URLs
                System.out.println("\nTop 10 Reddit Posts for keyword: " + keyword);
                for (int i = 0; i < posts.length(); i++) {
                    JSONObject post = posts.getJSONObject(i).getJSONObject("data");
                    String postUrl = "https://www.reddit.com" + post.getString("permalink");
                    String postTitle = post.getString("title");
                    System.out.println((i + 1) + ". " + postTitle + " - " + postUrl);
                }
            } else {
                System.out.println("Error: Unable to fetch Reddit data.");
            }

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}
