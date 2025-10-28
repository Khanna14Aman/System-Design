package SingletonDesignPattern;

class ThreadSafeDoubleLockSingleTon{
    private static ThreadSafeDoubleLockSingleTon instance;
    private ThreadSafeDoubleLockSingleTon(){

    }
    public static ThreadSafeDoubleLockSingleTon createInstance(){
        if(instance==null){ // if instance is already created then no need to apply lock
            synchronized (ThreadSafeDoubleLockSingleTon.class){
                if(instance==null){// what if first time multiple threads will pass the previous if condition then multiple thread will get lock and they will create multiple instance one by one.
                    instance = new ThreadSafeDoubleLockSingleTon();
                }
            }
        }
        return instance;
    }
}

public class ThreadSafeDoubleLockSingleTonDesign {
    public static void main(String [] args){
        ThreadSafeDoubleLockSingleTon s1 = ThreadSafeDoubleLockSingleTon.createInstance();
        ThreadSafeDoubleLockSingleTon s2 = ThreadSafeDoubleLockSingleTon.createInstance();
        System.out.println(s1==s2);
    }
}
