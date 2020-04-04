package controller;

import model.Quiz;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class QuizListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("listener activated");

        ServletContext sc = sce.getServletContext();
        //System.out.println(sc.getInitParameter("quizPath"));
        //System.out.println(sc.getRealPath(sc.getInitParameter("quizPath")));

        Scanner scanner;
        ArrayList<Quiz> list = new ArrayList<>();
        Quiz quiz;
        int count = 0;
        try{
            scanner = new Scanner(new File(sc.getRealPath((String)sc.getInitParameter("quizPath"))), "utf-8");
            System.out.println("path = " + sc.getInitParameter("quizPath"));

            while(scanner.hasNextLine()){
                StringTokenizer tokens = new StringTokenizer(scanner.nextLine());
                // generate new question object
                quiz = new Quiz();
                ++count;

                // set question id
                quiz.setId(count);
                if(tokens.hasMoreTokens()){
                    String token = tokens.nextToken();
                    System.out.println("question " + count + ": " + token);
                    // set question
                    quiz.setQuestion(token);
                }
                while(tokens.hasMoreTokens()){
                    String token = tokens.nextToken();
                    token = token.replace("-", " ");
                    System.out.println("option: " + token);
                    // set answer options
                    quiz.addOption(token);
                }

                // add question in list
                list.add(quiz);
            }

            scanner.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("error open file");
        }catch (IllegalStateException e){
            e.printStackTrace();
            System.out.println("error reading file");
        }

        for(Quiz i: list){
            System.out.println(i);
        }
        //save data in servlet context
        sc.setAttribute("list", list);
        sc.setAttribute("list_old", list);
        sc.setAttribute("total", count);


    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
