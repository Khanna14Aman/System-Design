package question_answer;

import java.util.Scanner;

public class Question {
    private static int count;
    private int questionNo;
    private String question;
    private String options[] = new String[4];
    private String ans;
    static{
        count = 1;
    }
    Question(){
        this.questionNo = count;
        count++;
    }
    public int getQuestionNo(){
        return this.questionNo;
    }
    public void setQuestion(String question){
        this.question = question;
    }
    public String getQuestion(){
        return this.question;
    }
    public void setOptions(int i,String opt){
        this.options[i] = opt;
    }
    public String getOptions(int i){
        return this.options[i];
    }
    public void setAns(String ans){
        this.ans = ans;
    }
    public String getAns(){
        return this.ans;
    }
}
