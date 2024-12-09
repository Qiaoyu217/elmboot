package team.tjusw.elmboot;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Hello {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param = request.getParameter("param");
        PrintWriter out = response.getWriter();
        String apiKey = "1145141919810";
        out.println("<html><body>");
        out.println("You entered: " + param);
        out.println("</body></html>");
    }
}
