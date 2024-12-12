package team.tjusw.elmboot;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.commons.text.StringEscapeUtils;

public class Hello {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param = request.getParameter("param");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        String apiKey = System.getenv("API_KEY");
        if (apiKey == null) {
            throw new IllegalStateException("API_KEY environment variable is not set");
        }
        out.println("You entered: " + StringEscapeUtils.escapeHtml4(param));
        out.println("</body></html>");
    }
}
