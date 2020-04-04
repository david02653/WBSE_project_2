package controller;

import model.Quiz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/sol")
public class SolutionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        resp.getWriter().println("SolutionServlet doGet method connected");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("solutionServlet connected");
        //super.doPost(req, resp);
        //String ans = req.getParameter("ans"); // encoding problem while accessing answer via getParameter() method
        String ans_code = new String(req.getParameter("ans").getBytes(StandardCharsets.ISO_8859_1), "utf-8");
        System.out.println("ans = " + ans_code);
        //System.out.println(ans_code);
        Quiz current = (Quiz) getServletContext().getAttribute("current");
        System.out.println(current);
        System.out.println("sol = " + current.ifCorrect(ans_code));

        //req.setAttribute("selected_one", current.getAnswer());
        HttpSession session = req.getSession();
        int score = (int) session.getAttribute("score");

        // direct to result page
        RequestDispatcher dispatcher;
        if(current.ifCorrect(ans_code)){
            // correct answer
            session.setAttribute("score", score + 1);
            dispatcher = req.getRequestDispatcher("./correct.jsp");
        }else{
            // answer is wrong
            dispatcher = req.getRequestDispatcher("./wrong.jsp");
        }
        dispatcher.forward(req, resp);
        /*
        RequestDispatcher view;
        if(result){
            view = req.getRequestDispatcher("./result-correct.jsp");
        }else{
            view = req.getRequestDispatcher("./result-wrong.jsp");
        }
        view.forward(req, resp);
        */
    }
}
