package MediatorDesignPattern;

public class MediatorDesignPatternMain {
    public static void main(String [] args) {
        ChatUser user1 = new ChatUser("Aman", 18, "Engineer");
        ChatUser user2 = new ChatUser("Rohit", 18,"Engineer");
        ChatUser user3 = new ChatUser("Ayush",19,"Engineer");
        user1.broadCastMessage("Hello Guys");
        user2.broadCastMessage("Hi Guys");
        user3.sendMessage(user1,"Hi");
        user1.sendMessage(user3," You are introvert");
        user3.muteUser(user1);
        user1.broadCastMessage(user3.getName()+" has muted me");
        user3.unMuteUser(user1);
        user1.broadCastMessage(user3.getName()+" has now unmuted me");
    }
}
