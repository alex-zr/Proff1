package prog.kiev.ua.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AuthServlet", urlPatterns = "/auth")
public class AuthServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (login != null && password != null && RegServlet.users.get(login).equals(password)) {
            //to the authentification
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        } else {
            // to the registration
            req.getRequestDispatcher("/reg").forward(req, resp);
        }
    }
}
