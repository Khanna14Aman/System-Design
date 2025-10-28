package SingletonDesignPattern;

class NoSingleTon {
    NoSingleTon(){
        System.out.println("NormalSingleTon Created");
    }
}
// here multiple objects can be created
public class NoSingleTonDesign {
    public static void main(String [] args){
        NoSingleTon s1 = new NoSingleTon();
        NoSingleTon s2 = new NoSingleTon();
        System.out.println(s1==s2);
    }
}
