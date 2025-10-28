package SingletonDesignPattern;

class EagerlyCreateSingleton{
    private static EagerlyCreateSingleton instance;
    static{
        instance = new EagerlyCreateSingleton();
    }
    private EagerlyCreateSingleton(){

    }
    public static EagerlyCreateSingleton createInstance(){
        return instance;
    }
}

public class EagerlyCreateSingleTonDesign {
    public static void main(String [] args){
        EagerlyCreateSingleton s1 = EagerlyCreateSingleton.createInstance();
        EagerlyCreateSingleton s2 = EagerlyCreateSingleton.createInstance();
        System.out.println(s1==s2);
    }
}
