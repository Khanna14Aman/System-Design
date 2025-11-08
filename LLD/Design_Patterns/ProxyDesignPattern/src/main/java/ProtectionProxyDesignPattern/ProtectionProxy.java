package ProtectionProxyDesignPattern;

public class ProtectionProxy implements Display{
    private FileDisplay fileDisplay;
    private User user;
    private String filePath;
    private String filePassword;
    ProtectionProxy(String path, String password, User user){
        fileDisplay = new FileDisplay();
        filePath = path;
        filePassword = password;
        this.user = user;
    }
    public void display(String path, String password){
        if(user.isPremium() && path.equalsIgnoreCase(filePath) && password.equalsIgnoreCase(filePassword)){
            fileDisplay.display(path,password);
        }
    }
}
