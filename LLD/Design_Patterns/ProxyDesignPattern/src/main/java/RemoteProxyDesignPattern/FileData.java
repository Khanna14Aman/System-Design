package RemoteProxyDesignPattern;

public class FileData implements CloudData{
    FileData(){
        System.out.println("Server is getting connected with Cloud Storage");
    }
    public void display(){
        System.out.println("Your data is visible on cloud platform");
    }
}
