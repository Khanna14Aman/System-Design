package SingletonDesignPattern;

class ThreadSafeSingleLockSingleTon{
    private static ThreadSafeSingleLockSingleTon instance;

    private ThreadSafeSingleLockSingleTon(){

    }

    public static ThreadSafeSingleLockSingleTon createInstance(){
        synchronized (ThreadSafeSingleLockSingleTon.class) {// From here only one thread will get the lock and can go inside but why to create lock every time it will take a lot of resources.
            if (instance == null) {
                instance = new ThreadSafeSingleLockSingleTon();
            }
            return instance;
        }
    }
}

public class ThreadSafeSingleLockSingleTonDesign {
    public static void main(String [] args){
        ThreadSafeSingleLockSingleTon s1 = ThreadSafeSingleLockSingleTon.createInstance();
        ThreadSafeSingleLockSingleTon s2 = ThreadSafeSingleLockSingleTon.createInstance();
        System.out.println(s1==s2);
    }
}
