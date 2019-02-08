package ua.kiev.prog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet(name = "Autentification",urlPatterns = "/authen")
public class Authentication extends HttpServlet {

   public static Map <String,String> users = new ConcurrentHashMap<>();


    @Override
    public void init() throws ServletException {
        users.put("admin","admin");
        users.put("boss","boss");

    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if(login != null && password != null &&users.get(login)!= null&&password.equals(users.get(login))){
            HttpSession session = req.getSession(true);
            session.setAttribute("user_login",login);

        }else{
            req.setAttribute("errors","Login or password is incorrect");
        }

        resp.sendRedirect("index.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String a = req.getParameter("a");
        HttpSession session = req.getSession(false);

        if("exit".equals(a) && session != null){
        session.removeAttribute("user_login");

        }


    }

}
