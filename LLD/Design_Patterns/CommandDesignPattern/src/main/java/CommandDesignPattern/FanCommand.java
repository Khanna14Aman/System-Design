package CommandDesignPattern;

public class FanCommand implements Command{
    Fan fan;
    public FanCommand(Fan fan){
        this.fan = fan;
    }
    public void execute(){
        fan.on();
    }
    public void undo(){
        fan.off();
    }
}
