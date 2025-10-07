package question_answer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game_Management {
    Scanner sc = new Scanner(System.in);
    private ArrayList<Question> questionsArrayList = new ArrayList<>();
    private HashMap<Player,Integer> playerIntegerHashMap = new HashMap<>();
    public void initialize(){
        boolean isRequired = true;
        while(isRequired){
            Question question = new Question();
            System.out.println("Dear Admin what is question "+question.getQuestionNo());
            String que = sc.nextLine();
            question.setQuestion(que);
            for(int i=0;i<4;i++){
                System.out.println("Dear Admin please provide option "+(i+1)+" for this question:");
                String opt = sc.nextLine();
                question.setOptions(i,opt);
            }
            System.out.println("Dear Admin please provide correct ans of this question:");
            String ans = sc.nextLine();
            question.setAns(ans);
            System.out.print("Dear Admin please click 1 to create more question else 2 to stop:");
            int decision = sc.nextInt();
            sc.nextLine();
            System.out.println();
            if(decision != 1){
                isRequired = false;
            }
            questionsArrayList.add(question);
        }
        isRequired = true;
        while(isRequired){
            Player player = new Player();
            System.out.print("Dear Admin please give name of the user:");
            String name = sc.nextLine();
            player.setName(name);
            System.out.println();
            System.out.print("\nDear Admin click 1 to create more user else 2 to stop:");
            int decision = sc.nextInt();
            sc.nextLine();
            if(decision != 1){
                isRequired = false;
            }
            playerIntegerHashMap.put(player,0);
        }
    }
    public void startPlaying(){
        for(Question question: questionsArrayList){
            System.out.println("Question "+question.getQuestionNo()+" is:");
            System.out.println(question.getQuestion()+"\n Below are the given options:");
            for(int i=0;i<4;i++){
                System.out.println((i+1)+": "+question.getOptions(i));
            }
            for(Player player: playerIntegerHashMap.keySet()){
                System.out.print("Dear "+player.getName()+" please enter the correct option:");
                int opt = sc.nextInt();
                System.out.println();
                if(opt < 1 || opt>4)continue;
                if(question.getOptions(opt-1).equals(question.getAns())){
                    playerIntegerHashMap.put(player,playerIntegerHashMap.get(player)+1);
                }
            }
        }
        System.out.println("Test completed and below are the results of quiz:");
        for(Player player: playerIntegerHashMap.keySet()){
            System.out.println(player.getName()+": "+playerIntegerHashMap.get(player));
        }
    }
}
