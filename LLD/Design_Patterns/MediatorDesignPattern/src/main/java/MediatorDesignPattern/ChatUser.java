package MediatorDesignPattern;

public class ChatUser extends Colleague{
    private int age;
    private String occupation;
    public ChatUser(String name,int age,String occupation){
        super(name);
        this.age = age;
        this.occupation = occupation;
    }
    public void muteUser(Colleague col){
        mediator.mute(this.getName(),col.getName());
    }

    public void unMuteUser(Colleague col){
        mediator.removeMuted(this.getName(),col.getName());
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
