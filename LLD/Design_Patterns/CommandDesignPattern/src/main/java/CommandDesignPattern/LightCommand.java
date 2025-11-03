package CommandDesignPattern;

public class LightCommand implements Command{
    private Light light;
    LightCommand(Light light){
        this.light = light;
    }
    public void execute(){
        light.on();
    }
    public void undo(){
        light.off();
    }
}
