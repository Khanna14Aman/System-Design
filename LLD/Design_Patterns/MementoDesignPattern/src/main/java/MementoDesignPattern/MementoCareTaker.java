package MementoDesignPattern;

public class MementoCareTaker {
    private DataBaseMemento dataBaseMemento;

    public MementoCareTaker(){
        dataBaseMemento = null;
    }

    private void commit(){
        System.out.println("As the transaction is completed so deleting the backup");
        dataBaseMemento = null;
    }
    private void rollback(DataOriginator dataOriginator) throws NullPointerException{
        dataOriginator.restoreBackup();
        dataBaseMemento = null;
    }
    public void insertRecord(DataOriginator dataOriginator, String s1, String s2) throws NullPointerException{
        dataBaseMemento = dataOriginator.createMemento();
        dataOriginator.insertData(s1,s2);
        commit();
    }
    public void updateRecord(DataOriginator dataOriginator, String s1, String s2)throws NullPointerException {
        dataBaseMemento = dataOriginator.createMemento();
        dataOriginator.updateData(s1,s2);
        commit();
    }
    public void removeRecord(DataOriginator dataOriginator, String s1) throws NullPointerException{
        dataBaseMemento = dataOriginator.createMemento();
        dataOriginator.removeData(s1);
        commit();
    }
    public void wrongInsert(DataOriginator dataOriginator, String s1, String s2) throws NullPointerException{
        dataBaseMemento = dataOriginator.createMemento();
        dataOriginator.insertData(s1,s2);
        dataOriginator.displayRecordsInDataBase();
        System.out.println("rolling back");
        rollback(dataOriginator);
        dataOriginator.displayRecordsInDataBase();
    }
    public void displayRecords(DataOriginator dataOriginator)throws NullPointerException{
        dataOriginator.displayRecordsInDataBase();
    }
}
