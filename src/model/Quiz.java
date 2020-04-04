package model;

import java.util.ArrayList;

public class Quiz {
    private int id;
    private String question = "init_question";
    private String answer = "init_option";
    private ArrayList<String> option;

    public Quiz(){
        option = new ArrayList<>();
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setQuestion(String token){
        this.question = token;
    }

    public String getQuestion() {
        return question;
    }
    public int getId() {
        return id;
    }
    public String getAnswer() {
        return answer;
    }

    public ArrayList<String> getOption() {
        return option;
    }

    public void addOption(String token){
        if(option.isEmpty()){
            this.answer = token; // accept first token as correct answer
        }
        option.add(token);
    }

    public boolean ifCorrect(String ans){
        return answer.equals(ans);
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", option=" + option +
                '}';
    }
}
