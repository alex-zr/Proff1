package com.mycompany.controller;

import com.mycompany.model.Question;
import com.mycompany.model.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "QuestionServlet", urlPatterns = {"/question"})
public class QuestionServlet extends HttpServlet {

    static final String LOGIN = "admin";
    static final String PASS = "admin";


    private static List<User> users;

    static {
        Question q1_yes = new Question("Do you like Java?", true);
        Question q1_no = new Question("Do you like Java?", false);
        Question q2_yes = new Question("Do you like .NET?", true);
        Question q2_no = new Question("Do you like .NET?", false);

        users = new ArrayList<>();
        users.add(new User("Stas", "Rybokon", 21, Arrays.asList(q1_yes, q2_no)));
        users.add(new User("Bruce", "Eckel", 61, Arrays.asList(q1_yes, q2_yes)));
        users.add(new User("Bill", "Gates", 62, Arrays.asList(q1_no, q2_yes)));
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        HttpSession session = request.getSession(false);

        if ("exit".equals(action) && (session != null))
            session.removeAttribute("logged");

        response.sendRedirect("login.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String forward = "";
        HttpSession session = request.getSession(true);

        switch (action) {
            case "add":
                String login = request.getParameter("login");
                String password = request.getParameter("password");

                if (LOGIN.equals(login) && PASS.equals(password)) {
                    session.setAttribute("logged", "true");
                    forward = "index.jsp";
                } else {
                    forward = "login.jsp";
                }

                break;

            case "stat":
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                Integer age = Integer.parseInt(request.getParameter("age"));
                String question1body = request.getParameter("question1body");
                String question2body = request.getParameter("question2body");
                boolean question1answer = request.getParameter("question1").equals("Yes") ? true : false;
                boolean question2answer = request.getParameter("question2").equals("Yes") ? true : false;

                Question question1 = new Question(question1body, question1answer);
                Question question2 = new Question(question2body, question2answer);

                User user = new User(firstName, lastName, age, Arrays.asList(question1, question2));

                users.add(user);
                session.setAttribute("users", users);

                forward = "stat.jsp";
                break;

            case "exit":
                session.removeAttribute("logged");
                forward = "login.jsp";
                break;
        }

        response.sendRedirect(forward);

    }


}
