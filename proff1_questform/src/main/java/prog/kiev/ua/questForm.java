package prog.kiev.ua;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet(urlPatterns = "/questionnaire")
public class questForm extends HttpServlet {
    static private Map<String, Integer> first = new HashMap<>();
    static private Map <Integer, Integer> second = new HashMap<>();
    static private Map<Integer, Integer> third = new HashMap<>();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("Name");
        String surname = req.getParameter("Surname");
        String age = req.getParameter("Age");
        String answerOne = req.getParameter("AnswerOne");
        String answerTwo = req.getParameter("AnswerTwo");
        String answerThree = req.getParameter("AnswerThree");

        int mark = Integer.parseInt(answerThree);
        int like = Integer.parseInt(answerTwo);

        String responseMessage = "<h1> Statistics for answers: </h1></br>" +
                "<h3>" + name + " " + surname + " " + age + "</h3>" +
                "<h3>Question #1:</h3></br>" +
                "<p>%s</p></br>" +
                "<h3>Question #2:</h3></br>" +
                "<p>%s</p></br>" +
                "<h3>Question #3:</h3></br>" +
                "<p>%s</p></br>";

        first.put(answerOne, changeValue(first, answerOne));
        second.put(like, changeValue(second, like));
        third.put(mark, changeValue(third, mark));

        resp.getWriter().println(String.format(responseMessage, responseStringStatistics(first),
                responseIntStatistics(second), responseIntStatistics(third)));
    }

    private Integer changeValue(Map<Integer, Integer> sourceMap, Integer key) {
        Integer result = sourceMap.get(key);

        if (result == null) {
            result = 1;
        } else {
            result++;
        }

        return result;
    }

    private Integer changeValue(Map<String, Integer> sourceMap, String key) {
        Integer result = sourceMap.get(key);

        if (result == null) {
            result = 1;
        } else {
            result++;
        }
        return result;
    }

    private String valuesFromIntKeys(Map<Integer, Integer> sourceMap) {
        Set<Integer> keys = sourceMap.keySet();
        String result = "";

        for (Integer value: keys) {
            result += sourceMap.get(value) + " => " + value + "</br>";
        }

        return result;
    }

    private String valuesFromStringKeys(Map<String, Integer> sourceMap) {
        Set<String> keys = sourceMap.keySet();
        String result = "";

        for (String value: keys) {
            result += sourceMap.get(value) + " => " + value + "</br>";
        }

        return result;
    }

    private String responseIntStatistics(Map<Integer, Integer> sourceMap) {
        String result = valuesFromIntKeys(sourceMap);

        return result;
    }

    private String responseStringStatistics(Map<String, Integer> sourceMap) {
        String result = valuesFromStringKeys(sourceMap);

        return result;
    }

}
