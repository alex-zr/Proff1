import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@SuppressWarnings("all")
@WebServlet(name = "Questionnaire", value = "/questionnaire")
public class Questionnaire extends HttpServlet {
    static final String TAMPLATE = "<html>" +
            "<head><titlt></title></head>" +
            "<body><h1>%s<h1></body></html>";
    int javaAnswer=0;
    int otherLanguageAnswer=0;
    int likeJavascript=0;
    int notLikeJavascript=0;
    int notdecide=0;
    int lessTwo=0;
    int moreTwo=0;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


            String language = request.getParameter("language");
            String javascript = request.getParameter("javascript");
            String quantityLanguagesS = request.getParameter("quantityLanguages");

            int quantityLanguages = Integer.parseInt(quantityLanguagesS);

            if ("java".equalsIgnoreCase(language)){
                javaAnswer++;
            } else {
                otherLanguageAnswer++;
            }

            if ("yes".equalsIgnoreCase(javascript)){
                likeJavascript++;
            } else if ("no".equals(javascript)){
                notLikeJavascript++;
            } else {
                notdecide++;
            }

            if (quantityLanguages<=2){
                lessTwo++;
            } else  {
                moreTwo++;
            }

          String msg = "Like java: - " + javaAnswer + System.lineSeparator()+
                         "Like other languages - " + otherLanguageAnswer +System.lineSeparator()+
                         "Like javascript - " + likeJavascript +System.lineSeparator()+
                         "Dont like javascript - " + notLikeJavascript +System.lineSeparator()+
                         "not decide about javascript -  " + notdecide +System.lineSeparator()+
                         "Know languages less 2 - " + lessTwo +System.lineSeparator()+
                         "Know languages more 2 - " + moreTwo;

            response.setContentType("text/html");
            PrintWriter printWriter = response.getWriter();
            printWriter.println(String.format(TAMPLATE,msg));



    }
}
