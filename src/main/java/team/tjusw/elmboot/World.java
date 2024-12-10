package team.tjusw.elmboot;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class World {

    public static void main(String[] args) {
        System.out.println("Hello, World");
        // String name = "tiansuo Li";
        System.out.println("Hello, tiansuo Li");
        byte[] data = new byte[1024];
        getUserData("tiansuo Li");
        deserializeData(data);
        System.out.println("Hello, tiansuo Li");
    }

    public static void deserializeData(byte[] data) {
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(data);
            ObjectInputStream ois = new ObjectInputStream(bais);
            Object obj = ois.readObject();
            System.out.println("Deserialized object: " + obj.toString());
            ois.close();
            bais.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getUserData(String username) {
        String dbUrl = "jdbc:mysql://localhost:3306/mydatabase";
        String dbUser = "user";
        String dbPassword = "password";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("User ID: " + rs.getInt("id"));
                System.out.println("Username: " + rs.getString("username"));
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
    try {
        String userInput = request.getParameter("input");
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>User Input: " + escapeHtml(userInput) + "</h1>");
        response.getWriter().println("</body></html>");
    } catch (IOException | ServletException e) {
        e.printStackTrace();
    }
}
        String userInput = request.getParameter("input");
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>User Input: " + escapeHtml(userInput) + "</h1>");
        response.getWriter().println("</body></html>");
    }

    private String escapeHtml(String html) {
        if (html == null) {
            return null;
        }
        return html.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;");
    }
}
