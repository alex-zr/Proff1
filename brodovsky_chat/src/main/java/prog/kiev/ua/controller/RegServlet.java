package prog.kiev.ua.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet(name = "RegServlet", urlPatterns = "/reg")
public class RegServlet extends HttpServlet {
    public static Map<String, String> users = new ConcurrentHashMap<>();

    @Override
    public void init() {
        users.put("Yarik", "1345431");
        users.put("Bill", "134431");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if ( login != null && password != null ) {
            users.put(login, password);

            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
