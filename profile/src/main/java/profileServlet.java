import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "profileServlet",
        urlPatterns = {"/profileServlet"}

)
public class profileServlet extends HttpServlet {
     static final String TEMPLATE = "<html>" + "<head><title>GlebShimko</title></head>"+ "<body><h1>%s</h1></body></html>";

    final int[] statistics = new int[4];

    static final int QUESTION_1_YES = 0;
    static final int QUESTION_1_NO = 1;
    static final int QUESTION_2_Idea = 2;
    static final int QUESTION_2_Eclipse = 3;

    public void doPost(HttpServletRequest req, HttpServletResponse response)throws IOException {
        String question1 = req.getParameter("question1");
        String question2 = req.getParameter("question2");

        final int answer1 = "yes".equals(question1) ? QUESTION_1_YES : QUESTION_1_NO;
        int answer2 = "Idea".equals(question2) ? QUESTION_2_Idea : QUESTION_2_Eclipse;

        statistics[answer1]++;
        statistics[answer2]++;
        String res = "<p> First question: yes = " + statistics[QUESTION_1_YES] + ", no = " + statistics[QUESTION_1_NO] + "<p>";
        res += "<p>Second question: Idea = " + statistics[QUESTION_2_Idea] + ", Eclipse = " + statistics[QUESTION_2_Eclipse];
        response.getWriter().println(String.format(TEMPLATE, res));
    }

}
