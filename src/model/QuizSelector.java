package model;

import java.util.ArrayList;

public class QuizSelector {
    private ArrayList<Quiz> list;

    public QuizSelector(ArrayList<Quiz> list){
        this.list = list;
    }

    public Quiz randomQuiz(){
        int size = list.size();
        int random = (int)(Math.random()*size);
        return list.get(random);
    }
}
