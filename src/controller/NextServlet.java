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
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/next")
public class NextServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        resp.getWriter().println("next doGet connected");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        System.out.println("next servlet post method");
        RequestDispatcher dispatcher;

        Quiz selected = (Quiz) getServletContext().getAttribute("current");
        int id = selected.getId();
        ArrayList<Quiz> list = (ArrayList<Quiz>) getServletContext().getAttribute("list");


        if(list.size() == 1){
            // no question left, show result
            // redirect to result page
            System.out.println("no question left");

            dispatcher = req.getRequestDispatcher("./final_result.jsp");
        }else{
            System.out.println("show other question");

            list.removeIf(quiz -> quiz.getId() == id);
            // setup new question list attribute
            getServletContext().removeAttribute("list");
            getServletContext().setAttribute("list", list);

            dispatcher = req.getRequestDispatcher("quiz");
        }
        dispatcher.forward(req, resp);

    }
}
