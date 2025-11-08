package RemoteProxyDesignPattern;

public class RemoteProxy implements CloudData{
    private FileData fileData;
    RemoteProxy(){
        fileData = new FileData();
    }
    public void display(){
        fileData.display();
    }

}
