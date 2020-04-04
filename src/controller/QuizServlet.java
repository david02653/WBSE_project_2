package controller;

import model.Quiz;
import model.QuizSelector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/quiz")
public class QuizServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("quizServlet doGet method activated");

        // get data from servlet context
        QuizSelector selector = new QuizSelector((ArrayList<Quiz>) getServletContext().getAttribute("list"));
        int total = (int) getServletContext().getAttribute("total");
        HttpSession session = req.getSession();
        if(((ArrayList<Quiz>) getServletContext().getAttribute("list")).size() == total){
            session.setAttribute("score", 0);
        }
        System.out.println("Show current: " + session.getAttribute("score"));
        System.out.println("current size = " + ((ArrayList<Quiz>) getServletContext().getAttribute("list")).size());
        //System.out.println(getServletContext().getInitParameter("quizPath"));

        //System.out.println(getServletContext().getAttribute("list"));

        // store selected quiz object
        Quiz target = selector.randomQuiz();
        getServletContext().setAttribute("current", target);
        System.out.println(target);

        // redirect to quiz-form jsp page
        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("./Quiz-form.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        doGet(req, resp);
    }
}
 /*
        String answer = req.getParameter("ans");
        req.setAttribute("answer", answer);
 */
