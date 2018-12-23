package ua.kiev.prog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "statisticServlet", urlPatterns = "/statisticServlet")
public class StatisticServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        MyBDinClass.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("statisticPage.jsp").forward(req,resp);
    }
}
