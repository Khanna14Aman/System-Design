package MementoDesignPattern;

public class MementoDesignMain {
    public static void main(String args []){
        try {
            MementoCareTaker careTaker = new MementoCareTaker();
            DataOriginator dataOriginator = new DataOriginator();
            careTaker.insertRecord(dataOriginator, "Aman", "Ekta");
            careTaker.displayRecords(dataOriginator);
            careTaker.insertRecord(dataOriginator, "rohit", "ayush");
            careTaker.displayRecords(dataOriginator);
            careTaker.updateRecord(dataOriginator, "rohit", "lester");
            careTaker.displayRecords(dataOriginator);
            careTaker.removeRecord(dataOriginator, "rohit");
            careTaker.displayRecords(dataOriginator);
            careTaker.wrongInsert(dataOriginator, "ayu", "rh");
            DataBaseMemento dataBaseMemento = DataBaseMemento.getMemento();
            dataBaseMemento.displayBackup();


            // In this design pattern for copying map value we are using deep copy example this.data = new HashMap<>(mememtoBackup); So this will create a new duplicate entry references will be different to both the places.
            // If we have used shallow copy means this.data = mementoBackup then this will create duplicate value but both the object will be pointing to same reference so if any of the objects gets change then it will reflect in both the objects.
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
}
