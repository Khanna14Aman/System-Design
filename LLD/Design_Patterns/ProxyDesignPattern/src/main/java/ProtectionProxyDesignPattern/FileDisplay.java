package ProtectionProxyDesignPattern;

public class FileDisplay implements Display{
    public void display(String path,String password){
        System.out.println("You file is: "+path);
    }
}
