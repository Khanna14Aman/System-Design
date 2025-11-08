package VirtualProxyDesignPattern;

public class VirtialProxyDesign {
    public static void main(String [] args){
        Display image = new VirtualProxy();
        image.display();
    }
}
