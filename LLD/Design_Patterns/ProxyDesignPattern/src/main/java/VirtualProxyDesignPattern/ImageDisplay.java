package VirtualProxyDesignPattern;

public class ImageDisplay implements Display{
    private String imgPath;
    ImageDisplay(String path){
        System.out.println("Fetching image from path: "+path);
        System.out.println("Scanning the fetched image and converting it to be visible");
        imgPath = path;
    }
    public void display(){
        System.out.println("You image is fetched from"+this.getImgPath());
    }
    public String getImgPath() {
        return imgPath;
    }

}
