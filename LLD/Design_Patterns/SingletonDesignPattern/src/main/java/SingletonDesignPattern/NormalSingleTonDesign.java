package SingletonDesignPattern;

class NormalSingleTon{
    private static NormalSingleTon instance;
    private NormalSingleTon(){

    }
    public static NormalSingleTon createInstance(){
        if(instance==null){ // If multiple thread execute this line at same time then they will create multiple instance
            instance = new NormalSingleTon();
        }
        return instance;
    }
}

public class NormalSingleTonDesign {
    public static void main(String [] args){
        NormalSingleTon s1 = NormalSingleTon.createInstance();
        NormalSingleTon s2 = NormalSingleTon.createInstance();
        System.out.println(s1==s2);
    }
}
