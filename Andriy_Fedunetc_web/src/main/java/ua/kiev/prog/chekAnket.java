package ua.kiev.prog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet(name = "chekAnket", urlPatterns = "/chekAnket")
public class chekAnket extends HttpServlet {


    @Override
    public void init() throws ServletException {
        MyBDinClass.init();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String age = req.getParameter("age");
        String color = req.getParameter("color");
        String animal = req.getParameter("animal");



        if(firstName == null  || lastName== null  || age == null || firstName.isEmpty() || lastName.isEmpty() || age.isEmpty()) {
            req.setAttribute("errors","Not all of your data has been submitted");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        } else
            if(animal != null && !animal.isEmpty() &&
                color != null && !color.isEmpty()){

            putIntoMap(MyBDinClass.colorMap,color);
            putIntoMap(MyBDinClass.animalMap,animal);

            req.getRequestDispatcher("/statisticPage.jsp").forward(req,resp);
        }else{
            req.setAttribute("errors","You have not answered all questions");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }



    }


    private synchronized boolean putIntoMap(ConcurrentHashMap<String,Integer> map, String key){
        if(key != null || key.equals("")) {
            if (map.containsKey(key)) {
                int count = map.get(key);
                map.put(key, ++count);
            } else {
                map.put(key, 1);
            }
            return true;
        }
        return false;
    }
}
