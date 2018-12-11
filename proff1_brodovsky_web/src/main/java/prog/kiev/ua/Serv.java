package prog.kiev.ua;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/serv")
public class Serv extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("Login");
        String password = req.getParameter("Password");
        String msg = "man";

        if ( login != null && login.equals(password) ) {
            msg = "week credentials";
        }

        resp.getWriter().println(String.format("<h1> Hello %s from servv </h1>", msg));

    }
}
