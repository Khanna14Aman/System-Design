1: We cannot make any class static but inner class can be static class:
	Eg: Class A{
		Int value;
		Static class B{
		Int no:
		}
	     }
	A obj = new A();
	A.B obj1 = new A.B();
	If class B is not static then A.B obj1 = new obj.B();
	
2: An abstract Class is possible without any abstract method inside it but abstract method is not possible without abstract class.

3: static{
	} block is used to define value of static variable and gets called only once when class gets loaded. Class get loaded only once, when first object of that class gets created.

4: Main method can be overloaded.
5: If you are directly passing value 5 eg fun(5) in function or you are using it while printing it will be of type "int" not "Integer".

6: In java separate class file will not get created for anonymous inner class:
	Main(){
		A obj = new A(){
			Public void show(){
				Print("ag");
			}
		};
		Obj.show(); 
	}
	
7: By default all the methods in interface is public abstract. Also by default all the variables in interface is static and final.
=> Reason of Static because we create object of class not interface and class implements the       interface not extends so we can implement only methods not variables.
=> Reason of final because interface don't have it's memory in heap so, the class which implements the interface that will have memory in heap so how can we change interface variable values.

8: Class can extends only 1 class or abstract class but it can implements multiple interface together.

9: We have 3 types of interface :
	Normal Interface => We can have any number of methods declare inside it.
	Functional or (Single Abstract Method) Sam Interface => We can have only one method in it.
	Marker Interface => We don't have any method inside it.
	
10: Lambda function only works with Functional Interface.

Note: Interface cannot be private or protected. If it is public it can used anywhere any of the packages just by importing. But if it is default then it can only be used in same package where that interface belongs to.
For public interface, interface name and file name should be same

11: Java 8 introduced the ability to define methods with a body inside an interface using:
	• Default methods
		○ Declared with the default keyword.
		○ Provides a default implementation that implementing classes may override.
		○ There can be any number of default method in interface we can use.
		○ We cannot create object of interface directly so we can do like this:
			MyInterface obj = new MyInterface(){}; // define empty block.
			    obj.showy();
			    obj.show();
			}

		○ interface MyInterface {
    default void show() {
        System.out.println("Default implementation");
    }
}  

	• Static methods
		○ Belong to the interface itself, not to the implementing classes.
		○ Called using InterfaceName.methodName().

interface MyInterface {
    static void utility() {
        System.out.println("Static method in interface");
    }
}





12:  Java 9 onwards
	• Interfaces can also have private methods (to share common code between default methods).

interface MyInterface {
    default void method1() {
        helper();
    }
    default void method2() {
        helper();
    }
    private void helper() {   // private method in interface
        System.out.println("Shared logic");
    }
}
13: Throwable Class has two child:
       Exception and Error: Error we cannot handle and program will get stops if it occurs but                            Exception we can handle if it occurs.
14: There two types of Exceptions Checked and Unchecked, for Unchecked exception compiler will not ask us to handle but for checked type of exception compiler will ask us to handle

14: Ducking Exceptions using throws: this we use when any method don't want to handle the exception it wants to throw the exception to the method from which it gets called and let that handle this exception.  EG: public void show(int a,int b) throws Exception{
					}
					Main(){
					Try{
					Show(1,0);
					Catch(Exception e){
					}
					
15: Class which have extended an interface "AutoClosable" that will get closed automatically if using with try(). Eg BufferedReader.
		Try(BufferedReader bf = new BufferedReader(InputStream.in)){
		}
		
16: finally block always gets executed regardless of exception occur or not. It gets used mainly for closing the resources which we used.
17: It is scheduler job to assign thread to OS to get executed. Let say we have  8 core CPU then 8 threads can be executed at once in OS.
18: We can use Thread Class or Runnable Interface to create a thread.
19: Runnable is a functional Interface, it has only run() method so we can create lambda expression for that.
20: Never use a Thread with mutation means never assign two or more threads to change the value of same variable. It might possible both try to change the value at same time.
      To correct this problem use the keyword synchronized in the method which you are calling from   
      all the threads.
EG: 
// Online Java Compiler
class Counter{
    int count = 0;
    public synchronized void increment(){
        count++;
    }
}
public class Main {
    public static void main( String args[] ) throws InterruptedException {
        Counter c = new Counter();
        Runnable obj1 = ()->{
            for(int i=0;i<1000;i++)c.increment();
        };
        Runnable obj2 = ()->{
            for(int i=0;i<1000;i++)c.increment();
        };
        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(c.count);
    }
}

21: Collection is an interface also List, Queue, Set is also interface extending Collection interface. Then many classes are available which implements methods of these interface, eg: ArrayList.
22: Collection interface extends Iterable interface.
23: Comparator and Comparable both are interface. Comparator we use when we want to write a logic how any element should get sort and we use Comparable when we want to give power to class itself then we use comparable by implementing CompareTo Method of Comparable.
24: Stream is an interface which we can use if we want to make any changes in array or arraylist without changing original value we can use Stream. Once we use the Stream object we cannot use that again we have to create new Stream object.

EG: Lets we want to get the sum of all even numbers by doubling the even numbers.

Integer ans = nums.stream().
			Filter(n  ->  n%2==0).
			Map(n  -> n*2).
			Reduce(0, (c,e) -> c+e); // here 0 is carry you can give if you want
			
25: Parallel Stream will create a separate Thread. We can use parallel stream when operations are independent of values not dependent. Like, sorting cannot work here because sorting operation is dependent on other values as well for comparing and sorting the values. Example is attached.

26: Optional class in Stream: 
List<String> arr = Arrays.asList("aan", "khanna", "ekta");
Optional<String>name = arr.stream().
                filter(str -> str.contains("m")).
                findFirst();
System.out.println(name.orElse("NotFound"));

               OR
List<String> arr = Arrays.asList("aan", "khanna", "ekta");
String name = arr.stream().
                filter(str -> str.contains("m")).
                findFirst().
                orElse("Not found");
System.out.println(name);

//
27: If we use final keyword then for that variable we cannot change its value. But if we use it with arraylist then its effect will be on reference of variable not on the content of variable.
EG: List<Integer> list  = new ArrayList<>();
Now we can change any value of list add and delete and modify particular value as well. But list cannot assign to any other list.
means 
final List<Integer> list = new ArrayList<>();
List<Integer> list2 = new ArrayList<>();
list  = list2 this will give error 





class A{
    public void show(){
        System.out.println("A show");
    }
}
class B extends A{
    public void show(){
        System.out.println("B show");
    }
    public void fun(){
        System.out.println("funn..");
    }
}
public class Main {
    public static void main(String [] args){
        B obj = new B();
        obj.show();
        obj.fun();
        A obj1 = new A();
        obj1.show();
        A obj2 = new B();
        obj2.show();
        obj2.fun();
        B obj3 = new A();
        
        
    }
}



Parallel Stream Eg: 
public class Main {
    public static void main(String[] args) {

        Random rand = new Random();
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<10000;i++){
            arr.add(rand.nextInt(100));
        }
        long startSeq = System.currentTimeMillis();
        int seq = arr.stream().
                mapToInt(i->{
                    try{
                        Thread.sleep(1);
                    }
                    catch (Exception e){

                    }
                 return i;
                }).
                sum();
        long endSeq = System.currentTimeMillis();
        long startPara = System.currentTimeMillis();
        int para = arr.parallelStream().
                mapToInt(i-> {
                    try{
                        Thread.sleep(1);
                    }
                    catch (Exception e){

                    }
                    return i;
                }).
                sum();
        long endPara = System.currentTimeMillis();
        System.out.println(seq + "  " + para);
        System.out.println((endSeq-startSeq) + "  " + (endPara-startPara));
    }
}

