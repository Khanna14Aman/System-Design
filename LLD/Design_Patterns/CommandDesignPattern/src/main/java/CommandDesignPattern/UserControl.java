package CommandDesignPattern;

public class UserControl {
    public static void main(String [] args) {
        Light light = new Light();
        Command lightCommand = new LightCommand(light);
        Fan fan = new Fan();
        Command fanCommand = new FanCommand(fan);
        RemoteController remote = new RemoteController(4);
        remote.pressButton(5);
        remote.setCommands(0,fanCommand);
        remote.pressButton(0);
        remote.pressButton(0);
        remote.setCommands(0,lightCommand);
        remote.setCommands(1,lightCommand);
        remote.pressButton(1);
        remote.pressButton(1);
    }
}
