package ProtectionProxyDesignPattern;

public class User {
    private boolean isPremium;
    User(boolean isPremium){
        this.isPremium = isPremium;
    }
    public boolean isPremium(){
        return isPremium;
    }
}
