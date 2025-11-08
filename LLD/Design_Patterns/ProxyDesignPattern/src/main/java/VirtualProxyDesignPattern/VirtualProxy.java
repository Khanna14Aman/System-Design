package VirtualProxyDesignPattern;

public class VirtualProxy implements Display{
    private ImageDisplay imgDisplay;
    VirtualProxy(){
        imgDisplay = null;
    }
    public void display(){
        if(imgDisplay==null)
            imgDisplay = new ImageDisplay("Google Cloud");
        imgDisplay.display();
    }

}
