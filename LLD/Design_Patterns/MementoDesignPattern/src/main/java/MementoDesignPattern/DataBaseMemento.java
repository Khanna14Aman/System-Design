package MementoDesignPattern;

import java.util.HashMap;
import java.util.Map;

public class DataBaseMemento {
    private Map<String,String> mementoBackup;
    private final static DataBaseMemento memento;
    static {
        memento = new DataBaseMemento();
    }
    private DataBaseMemento(){
        this.mementoBackup = new HashMap<>();
    }

    public static DataBaseMemento getMemento(){
        return memento;
    }

    public void createBackup(Map<String,String> mementoBackup){
        this.mementoBackup = new HashMap<>(mementoBackup);
    }

    public Map<String,String> getMementoBackup(){
        return this.mementoBackup;
    }

    public void displayBackup(){
        for(Map.Entry<String, String> record: mementoBackup.entrySet()){
            System.out.println("key: "+record.getKey()+"       value"+record.getValue());
        }
    }
}
