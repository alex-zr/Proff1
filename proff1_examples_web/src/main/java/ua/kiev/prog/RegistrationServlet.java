package ua.kiev.prog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (AuthServlet.users.get(login) != null) {
            req.getRequestDispatcher("/registration.jsp").forward(req, resp);
        } else {
            AuthServlet.users.put(login, password);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }

    }
}
