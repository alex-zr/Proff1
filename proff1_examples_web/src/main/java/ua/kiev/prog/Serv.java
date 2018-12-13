package ua.kiev.prog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "serv", urlPatterns = "/serv")
public class Serv extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req,
                      HttpServletResponse resp) throws IOException, ServletException {

        req.setAttribute("list", Arrays.asList("Lexus", "BMW", "Infinity"));
        req.getRequestDispatcher("/result.jsp").forward(req, resp);
//        resp.getWriter().println("<h1> Hello from Serv </h1>");
    }
}
