package MementoDesignPattern;

import java.util.HashMap;
import java.util.Map;

public class DataOriginator {
    private Map<String,String> data;
    public DataOriginator(){
        data = new HashMap<>();
    }

    public void insertData(String s1, String s2){
        if(data.containsKey(s1)){
            System.out.println("Value at "+s1+" is already existing");
            return;
        }
        data.put(s1,s2);
        System.out.println(s2+" value is inserted at "+s1);
    }

    public void updateData(String s1, String s2){
        data.put(s1,s2);
        System.out.println(s1+" value is updated");
    }

    public void removeData(String s1){
        if(data.containsKey(s1)){
            data.remove(s1);
            System.out.println("Value at "+s1+" is removed");
        }else{
            System.out.println("There is no value at "+s1+" to be removed");
        }
    }

    public DataBaseMemento createMemento(){
        DataBaseMemento memento = DataBaseMemento.getMemento();
        memento.createBackup(this.data);
        return memento;
    }

    public void restoreBackup(){
        DataBaseMemento memento = DataBaseMemento.getMemento();
        this.data = new HashMap<>(memento.getMementoBackup());
    }

    public void displayRecordsInDataBase(){
        if(this.data.isEmpty()){
            System.out.println("Sorry there is not data available to show");
        }else{
            for(Map.Entry<String,String> record: this.data.entrySet()){
                System.out.println("At field "+record.getKey()+"  "+record.getValue()+" value is inserted");
            }
        }
    }

}
