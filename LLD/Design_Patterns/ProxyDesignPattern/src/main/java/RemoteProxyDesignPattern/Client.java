package RemoteProxyDesignPattern;

public class Client {
    public static void main(String [] args){
        CloudData cloudData = new RemoteProxy();
        cloudData.display();;
    }
}
