package MediatorDesignPattern;

public abstract class Colleague {
    protected String name;
    protected final static ChatMediator mediator;
    static{
        mediator = ChatMediator.getObject();
    }
    public Colleague(String name){
        this.name = name;
        mediator.registerColleague(this);
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void receive(String name,String msg){
        System.out.println("Hey "+this.getName()+"\n"+"Message from "+name+": "+msg);
    }
    public void sendMessage(Colleague to, String msg){
        mediator.sendPrivate(this,to,msg);
    }
    public void broadCastMessage(String msg){
        mediator.broadCast(this,msg);
    }
    public void removeColleague(){
        mediator.removeColleague(this);
    }
}
