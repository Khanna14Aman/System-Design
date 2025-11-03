package CommandDesignPattern;

public class RemoteController {
    private int remoteSize;
    private Command[] buttons;
    private boolean[] buttonPressed;
    public RemoteController(int remoteSize){
        this.remoteSize = remoteSize;
        buttons = new Command[remoteSize];
        buttonPressed = new boolean[remoteSize];
    }

    public void setCommands(int ind, Command command){
        if(ind>=0 && ind<remoteSize){
            if(buttons[ind]==null){
                buttons[ind] = command;
            }else{
                System.out.println("This button is already getting used for other task");
            }
        }else{
            System.out.println("You have entered wrong button");
        }
    }

    public void pressButton(int ind){
        if(ind>=0 && ind<remoteSize){
            if(buttons[ind]!=null){
                if(!buttonPressed[ind]) {
                    buttons[ind].execute();
                    buttonPressed[ind] = true;
                }else{
                    buttons[ind].undo();
                    buttonPressed[ind] = false;
                }
            }else{
                System.out.println("The button you pressed have no task");
            }
        }else{
            System.out.println("You have entered wrong button");
        }
    }
}
