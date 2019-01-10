package ua.kiev.prog;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "serv", urlPatterns = "/")
public class Serv extends HttpServlet {

    static final int OS_WINDOWS = 0;
    static final int OS_LINUX = 1;
    static final int OS_MacOS = 2;

    static final int PHONE_SAMSUNG = 3;
    static final int PHONE_IPHONE = 4;
    static final int PHONE_MEIZU = 5;
    static final int PHONE_LENOVO = 6;
    static final int PHONE_OTHER = 7;

    static final String TEMPLATE = "<html><head><title>STATICTIC</title></head>" +
            "<body>%s</body></html>";

    final int[] results = new int[8];


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        final String os = req.getParameter("os");
        final String phone = req.getParameter("phone");

        if ("windows".equals(os)) {
            results[OS_WINDOWS]++;
        }
        if ("linux".equals(os)) {
            results[OS_LINUX]++;
        }
        if ("macOs".equals(os)) {
            results[OS_MacOS]++;
        }


        if ("samsung".equals(phone)) {
            results[PHONE_SAMSUNG]++;
        }
        if ("iPhone".equals(phone)) {
            results[PHONE_IPHONE]++;
        }
        if ("meizu".equals(phone)) {
            results[PHONE_MEIZU]++;
        }
        if ("lenovo".equals(phone)) {
            results[PHONE_LENOVO]++;
        }
        if ("other".equals(phone)) {
            results[PHONE_OTHER]++;
        }

        String res = "<p>Windows: " + results[OS_WINDOWS] + "<br>Linux: " + results[OS_LINUX] + "<br>MacOS: "
                + results[OS_MacOS];
        res += "<p> Samsung: " + results[PHONE_SAMSUNG] + "<br>iPhone: " + results[PHONE_IPHONE] + "<br>Meizu: " + results[PHONE_MEIZU] +
                "<br>Lenovo: " + results[PHONE_LENOVO] + "<br>Other : " + results[PHONE_OTHER] + "</p>";

        resp.getWriter().println(String.format(TEMPLATE, res));
    }
}