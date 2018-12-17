package ua.prog.kiev;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "servlet", value = "/servlet")
public class serv extends HttpServlet {
	static final int question_one_yes = 0;
	static final int question_one_no = 1;
	static final int question_two_yes = 2;
	static final int question_two_no = 3;

	static final String TEMPLATE = "<html><head><title>Prog.kiev.ua</title></head>" +
			"<body>" +
			"%s" +
			"</body>" +
			"</html>";

	final int results[] = new int[4];

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		final String q1 = request.getParameter("Question 1");
		final String q2 = request.getParameter("Question 2");

		final int index1 = "yes".equals(q1) ? question_one_no : question_one_yes;
		final int index2 = "yes".equals(q2) ? question_two_no : question_two_yes;

		results[index1]++;
		results[index2]++;

		String result = "<p> Question 1: " +
				"<br> yes = " + results[question_one_yes] +
				"<br> no = " + results[question_one_no] +
				"<br> Question 2:" +
				"<br> yes = " + results[question_two_yes] +
				"<br> no = " + results[question_two_no];

		request.setAttribute("result", result);
		//request.getRequestDispatcher("/result.jsp").forward(request, response);
		response.getWriter().println(String.format(TEMPLATE, result));
	}


}
