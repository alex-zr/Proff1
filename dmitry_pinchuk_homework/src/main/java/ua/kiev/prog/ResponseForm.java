package ua.kiev.prog;

import com.mycompany.model.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

import static ua.kiev.prog.Authentication.users;

@WebServlet(name = "Response",urlPatterns = "/form")
public class ResponseForm extends HttpServlet {

    private static final AtomicInteger questionSexMale = new AtomicInteger(0);
    private static final AtomicInteger questionSexFemale = new AtomicInteger(1);
    private static final AtomicInteger questionLanguageJavaScript = new AtomicInteger(3);
    private static final AtomicInteger questionLanguageJava = new AtomicInteger(4);
    private static final AtomicInteger questionLanguagePython = new AtomicInteger(5);


//    private static Map<String, AtomicInteger> question1 = new ConcurrentHashMap<>();
//    private static Map<String, AtomicInteger> question2 = new ConcurrentHashMap<>();
      List<User> user_name = new ArrayList<>();

//    final AtomicIntegerArray array = new AtomicIntegerArray(5);
//
//    static final String TEMPLATE = "<html>" +
//            "<head><title>Prog.kiev.ua</head></title>"+
//            "<body><h1>%s</body></h2></html>";
//

//    Questions male = new Questions("male",questionSexMale);
//    Questions female = new Questions("female",questionSexFemale);
//    Questions javascript = new Questions("javascript",questionLanguageJavaScript);
//    Questions java = new Questions("java",questionLanguageJava);
//    Questions python = new Questions("python",questionLanguagePython);
//

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String age = req.getParameter("age");
        String sex = req.getParameter("sex");
        String language = req.getParameter("language");


        if (name != null && surname != null && age != null && sex != null && language != null) {

            int ageS  = Integer.parseInt(age);
//            Questions male = new Questions("male",questionSexMale);
            Questions female = new Questions("female",questionSexFemale);
            Questions javascript = new Questions("javascript",questionLanguageJavaScript);
            Questions java = new Questions("java",questionLanguageJava);
            Questions python = new Questions("python",questionLanguagePython);

            AtomicInteger res1;
            if ("male".equals(sex)) {
                Questions male = new Questions("male",questionSexMale);
//                user_name.add(new User(name,surname,ageS,"male",questionSexMale));
//                User user = new User(name,surname,ageS,male);
            } else {
                res1 = questionSexFemale;
            }

            AtomicInteger res2;
            if ("javascript".equals(language)) {
                res2 = questionLanguageJavaScript;
            } else if ("java".equals(language)) {
                res2 = questionLanguageJava;
            } else {
                res2 = questionLanguagePython;
            }

//            array.incrementAndGet(res1);
//            array.incrementAndGet(res2);

//            req.setAttribute("list", Arrays.asList(array));
//            req.getRequestDispatcher("/result.jsp").forward(req, resp);
//        } else {
//            req.setAttribute("errors", "Incorrect inputs");
//            req.getRequestDispatcher("/index.jsp").forward(req, resp);
//        }

//            String ress = "<p>Question 1: male =" + array.get(questionSexMale) + ", female = " + array.get(questionSexFemale) + "</p>";
//            ress += "<p>Question 2: JavaScript =" + array.get(questionLanguageJavaScript) + ", Java = " + array.get(questionLanguageJava) + ", Python = " + array.get(questionLanguagePython) + "</p>";
//            resp.getWriter().println(String.format(TEMPLATE, ress));


        }
    }
}

