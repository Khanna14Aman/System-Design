package PrototypeDesignPattern;

public class PrototypeDesignMain {
    public static void main(String [] args){
        GamePlayers user1 = new GamePlayers("Aman",100, 100, 200);
        GamePlayers user2 = (GamePlayers) user1.clone();
        user2.setName("Rohit");
        user1.describe();
        user2.describe();
    }
}
