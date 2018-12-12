package ua.kiev.prog;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "serv", urlPatterns = "/serv")
public class Serv extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req,
                      HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String msg = "man";
        if (login != null && login.equals(password)) {
            msg = "Week credentials";
        }
        resp.getWriter().println(String.format("<h1> Hello %s from Serv </h1>", msg));
    }
}
