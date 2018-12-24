import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


@SuppressWarnings("all")
@WebServlet(name = "Questionnaire", value = "/questionnaire")
public class Questionnaire extends HttpServlet {

    public PeopleList peopleList = PeopleList.getInstance();
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
            //parameters of people that voted
            String name = request.getParameter("name");
            String lastName = request.getParameter("lastName");
            String age = request.getParameter("age");
            String married = request.getParameter("married");
            //voting parameters
            String language = request.getParameter("language");
            String javascript = request.getParameter("javascript");
            String quantityLanguagesS = request.getParameter("quantityLanguages");

            int quantityLanguages = Integer.parseInt(quantityLanguagesS);
            int ageInt = Integer.parseInt(age);
            boolean marriedBoolean = Boolean.parseBoolean(married);

            int votes = peopleList.getPeopleList().size()+1;
            int votesOnlyMarried = (int) peopleList.getPeopleList().stream()
                    .filter(people -> people.isMarried()).count();

            int votesOnlyNotMarried = peopleList.getPeopleList().size()+1 - votesOnlyMarried;

            int peopleAgeIsMore30 = (int) peopleList.getPeopleList().stream()
                    .filter(people -> people.getAge()>30).count();

            int averageAgeOfVoters = (int) peopleList.getPeopleList().stream()
                    .mapToInt(People::getAge)
                    .average()
                    .getAsDouble();


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



           peopleList.addPeople(new People(name,lastName,ageInt,marriedBoolean));
           request.setAttribute("votes", votes);
           request.setAttribute("votesOnlyNotMarried", votesOnlyNotMarried);
           request.setAttribute("peopleAgeIsMore30", peopleAgeIsMore30);
           //request.setAttribute("averageAgeOfVoters", averageAgeOfVoters);

           request.setAttribute("name", name);
           request.setAttribute("lastName", lastName);
           request.setAttribute("age", age);
           request.setAttribute("marriedBoolean", marriedBoolean);

           request.setAttribute("javaAnswer",javaAnswer);
           request.setAttribute("otherLanguageAnswer",otherLanguageAnswer);
           request.setAttribute("likeJavascript",likeJavascript);
           request.setAttribute("notLikeJavascript",notLikeJavascript);
           request.setAttribute("notdecide",notdecide);
           request.setAttribute("lessTwo",lessTwo);
           request.setAttribute("moreTwo",moreTwo);
           request.getRequestDispatcher("/index.jsp").forward(request,response);




    }
}
