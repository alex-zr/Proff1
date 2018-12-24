package ua.kiev.prog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet(name = "AuthServlet", urlPatterns = "/auth")
public class AuthServlet extends HttpServlet {
    public static Map<String, String> users = new ConcurrentHashMap<>();

    @Override
    public void init() {
        users.put("bill", "gates");
        users.put("Mark", "Cukerberg");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (password != null && users.get(login) != null && password.equals(users.get(login))) {
            request.setAttribute("list", Arrays.asList("Lexus", "BMW", "Infinity"));
            request.getRequestDispatcher("/result.jsp").forward(request, response);
        } else {
            request.setAttribute("errors", "Login/password is incorrect");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
