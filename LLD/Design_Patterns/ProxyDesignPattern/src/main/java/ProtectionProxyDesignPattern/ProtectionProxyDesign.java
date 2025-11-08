package ProtectionProxyDesignPattern;

public class ProtectionProxyDesign {
    public static void main(String [] args){
        User user = new User(false);
        Display fileDisplay = new ProtectionProxy("Google Cloud","1234",user);
        fileDisplay.display("google cloud","1234");
    }
}