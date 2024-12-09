package team.tjusw.elmboot;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class World {
    public void deserializeData(byte[] data) {
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

    public void getUserData(String username) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "user", "password");
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM users WHERE username = '" + username + "'";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("User ID: " + rs.getInt("id"));
                System.out.println("Username: " + rs.getString("username"));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userInput = request.getParameter("input");
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>User Input: " + userInput + "</h1>");
        response.getWriter().println("</body></html>");

    }
}
