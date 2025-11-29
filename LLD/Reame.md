Inventions of different languages:
1: Machine Language eg: 01001010 like this people were writing code.
2: Assembly Language eg: People used to interact direct with hardware eg: MOV A, 61H means move value of register A to 61H 
3: Then procedural language comes which is used to write code but OOPS were not supported. EG: C language where oops is not supported.
4: OOPS supported language: Like Java, C++, Python, etc: help in solving Real World Problem, Data security, Scalable, Reusable, etc.
5: Abstraction is used for data hiding but Encapsulation is used for data security.
6: There are two types of UML diagram: Structural(Static) or Behaviroul(Dynamic) also the diagram name is UML Diagram and Sequence Diagram respectively.
7: There are two types of association that is Class Association and Object Association.. Inheritance is a Class association. Object association is of three types Simple, Aggregation, and Composition.
 
8: Robert C Martin published paper in 2000 regarding Design Principles.
9: Immutable Class cannot be inherited and immutable method cannot be override.
10: Principle of least knowledge should also be followed by our class: which means class should always talks to their immediate class only.
11: Strategy Design Pattern: Define a family of algorithm, put them into separate class so that they can be changes at run time.
Eg: 
 
 
Here we have created separate interface for Talkable, Walkable and Flyable behaviour. From there we can create separate class and implement interface funtionality. Robot will have a "Has-A" relationship with all these interfaces.
Note: Without Strategy Desing Pattern it was going like: 
 
 
12: We should make a design like same code can be used every where so it will follow the concept of DRY : Do Not Repeat Yourself.
13: Model class are those class which does not have any logic. It just has getter or setter function. 
14: We should design the class in a way that it should follow first principle of least knowledge. Means Class should not depend on other object so much that it has to take most of the value from particular object. Means Class should be loosely coupled with object.
15: Command Design Pattern: Encapsulate the request as an object, thereby letting you parameterize clients with different request, queue or log request and support undoable operations.
16: Command Design Pattern helps client to give command and execute the command. Let's take example we usually switch on and switch off the lights or fan. Here we are giving command to switch to on and off the light or fan. So like this command design pattern also work. When we want to undo our work there also we can use command design pattern like we use ctrl+z in computer.
17: Adapter design pattern we use if client is not able to interact with some other class or process. Here we have a middle class or interface, which work as adapter. Eg: Translator we use to translate different language because hindi person cannot understand chinese and chinese person cannot understand hindi. Eg: Java compiler can only compile java code but if we get C++ code then java compiler will not be able to execute so we can use some code conversion software as adapter. Eg: Compiler itself is a adapter because it helps working between High level language and low level language. Converts our code to machine level code and converts machine level error in human readable text.
18: Façade Design Pattern we use when we don't want client to interact with complex system so here client will interact with one class and that class will interact with other complex systems. Eg: Whenever we want to use our computer we just interact with CPU or Laptop opening button now laptop and CPU will interact with other component and start the systems in such a way that we can use that.
19: Composite Design Pattern which is also known as File design system: we use this design pattern whenever we want to use a system which have a tree like structure. Like file system where we can have file under folder and folder under folder as well.
Or we can say when we want to interact with a system where system has a structure inside structure and we want to interact with them in sequential way .
20: Template Design Pattern we use when we want our system to follow as specific path every time. Like If we are working on Image Processing and Neural Network then we have some specific order of calling the methods for these two work and for that we will define one template where order of calling the methods will be define.

21: Proxy Design Pattern: Here we have one object which is a replication of reciever to which client wants to interact, so instead of interacting directly reciever here client will be interacting with Proxy object but client is unaware of this. Because client is has a reference of interface or abstract class, and Proxy class and reciever class both have "IS-A" relationship with that interface or abstract class.

There are three types of Proxy design Pattern:
a: Virtual Proxy: This Proxy object protect the expensive resources of reciever. Eg Reciever is a class which load the image from cloud and display it to client, but here loading of cloud image is very expensive task so if client just make object of this class and doesn't call display method then this is a very expensive resource for reciever and doesn't gets used by client. So object of reciever gets created only when client wants to display image.

b: Protection Proxy: This Proxy object protect the critical resources of reciever. So here proxy will first authenticate the client then only give access to reciever resources. As we did in File access method.

c: Remote Proxy: This proxy object is usefull if client wants to connect through internet then proxy object will create a connection between client and reciever which is on internet.


22: Chain Of Responsibility: This design pattern we use when we task needs to be done by one class object but if that object is not able to complete the task it will assign that task to different class object and so on. Like this if one class object not able to fullfill that responsibility it will assign the task to different class object. Here all the classes will have "IS-A" relationship with one common abstract class or Interface. 


23: Bridge Design Pattern: It is same as Strategy Design Pattern but the intent of using this is different. Here we divide the main logic in two parts HLP(High Level Part) & LLP(Low Level Part) also known as Abstraction and Implementation respectively. Here HLP will just have the overview of logic but unaware about the internal processing that is taken care by LLP which is responsible for internal processing. Here Abstraction has a object of Implementation so it will prevent our code from class explosion.


24: Builder Design Pattern: This design pattern we use when we have multiple instace varialbe so there we will required to create multiple constructor with multiple combinations of instance variables.
Also we cannot create setMethod of every variable because then user can change some critical information.
Also one problem is if we want to excute the method only after all the mandatory fields values are set but customer can call method anytime. So we can write validation logic as well but how many places we will write validation logic.
So for all the above problems we have Builder design pattern which will resolve this.


25: Iterator Design Pattern: This design pattern we use to define iterator for different type of data structures like tree, linked list, or any custom data structures or list of objects as well.

26: FlyWeight Design Pattern: This design pattern is usefull when we want to save a storage.
Let say we have to represent lakhs of asteroids in game so we have to create lakhs of asteroids object that will take allot of storage.
So using this design pattern we can save huge amount of storage.
Lets we say all the asteroid will have some common properties like size, color, hight, width, weight. Also some properties will be unique for each asteroids like position on x axis and position on y axis. 
We we can create two different class on is for "Intrinsic" properties which are same, and "Extrinsic" properties which will be unique for each. And "Extrinsic" object will have a "Has-A" relationship with "Intrinsic" properties.
So let say we have 10 lakh unique postion for asteroid so we will have 10 lakh extrinsic object and we have 10 different combinations for "Intrinsic" objects so we will create only 10 "Intrinsic" object as compare to without flyweight design patten. This will save huge amout of storage.


27: Mediator Design Pattern: We used this pattern when we need a communication between multiple objects. Then it is very usefull becasue if you maintain list of objects in every object then if new object gets created then every existing object has to update there object list. This is risky and breaking open/close principle as well.
So here we have a mediator class (we can make singleton class as well) which will have the list of objects available. Now every object will communicate to mediator class and through that object can communicate with other objects. Here mediator class will take care of adding or removing the objects.

28: Prototype Design Pattern: This design pattern we use when we have to create multiple objects with negligible changes in objects and the object creation process using constructor is very expensive. So here we create one object and now we can create multiple object using copy constructor by copying the values of first object which we had created using very expensive tasks.
Let say we have to connect to cloud data base for creating object which is very expensive so we will create only one object with this process and for rest of the object we will use copy constructor to copy values as objects are very similar and negligible difference between them.

29: Visitors Design Pattern: This design pattern we use when we know that in future we have a same number of objects or rarely we will create new object but for those object we will have to add new - new behaviour or methods so for every object every time we have to add new behaviour/ method and it can go multiple times. So this is breaking open-close principle and also it is breaking Single resposibility principle. Because then every time we have to update class with new methods and those method can different responsibilities.
So here number of item class is fixed but number of behaviours of those class will getting increases. So we will create an interface which has a method visit for every item class which is fixed and we will create behaviour class every time when we have to introduce new behaviour.

30: Memento Design Pattern: This design pattern we use to keep snapshot or history of any object who is getting changed every time. This will help in storing history and we can rollback whenever we want.
Eg: you are doing transaction you have 1000 rupee in bankaccount you with 500 so remaining amount is 500 in your backaccount. But if somehow ATM is not able to cash out so it is madatory to have history of your account so atm will get rollback and againg 1000 rupee will available in your system. If history were not available then it was not possible to get to know your original back balance.
Here are three keywords :
    a: Originator this points to actual object whose history you want to store.
    b: Memento this takes snapshot/history of your original value as backup so it can be used in future.
    c: CareTaker this has a list of memento so it is possible to go to any of the history.



31: Design Anti Patterns: These are the mistakes we did in our system by mistake:
    a: God Object: When you have any class or object which have many responsibility then it is a god object. If it is just delegating the task to other object not performing any task it self then it is not a god object. But if it is performing task itself also then it is a god object

    b: Spaghetti Code: When class design is very complex let say class A is dependent on B and B on C and C on D and D on A. Then there is not entry or exit point we can found, and these classes are tightly coupled as well. 
    So these class are pron to error and tightly coupled.

    c: Hard Codding thing: When we do hard codding of some variable. Eg: String st = "hello" this is hard codding but what if we want to change the value in future so prefer using const.

    d: Gold Plating or Over Engineering: When we try to achieve perfect design in our system so some times we end up doing the things which never wanted. So we are just complicating our code nothing else. Eg. For every logic we shouldn't use strategy design pattern, we should only use if method is need to be change.

    e: DRY(Do not repeat yourself): Some times we write same logic for multiple methods. What if in future we want to change the logic behing this then we have to change in every method so it is good to write same logic in single particular class and use from there. 
    So in case we want to change the logic then only one place we have to change.

    f: Constructor Overloading: Some times we create allot of constructor, so we should use Builder design pattern instead of overloading constructor many times.

    g: Over use of getter/setter: Some times people create getter/setter for all the instance variable. But if some variable is private then this means that our intension was not to change that variable every time but if you create public getter/setter then what is the use of declaring private variable. So try and figure it out for which instance variable getter or setter is required.

    h: Pre-mature Optimisation: Some times we try to optimise the system without figuring it out that our system is working as expected or not. So we should make our system as expected then optimise.

    i: Overuse of Inheritance: We should not overuse of inheritance, instead of this try to use "has-a" relationship or composition relationship;


32: Null Object Design Pattern: This design pattern is usefull when we are using any object to fetch instance variable or calling it's method. So for doing this we often write if condition to make sure that object is not null else it will give Null Object Exception.
So instead of checking writing null condition it is better to use polymorphims and create a concrete class for null object so if object is null then this class will get called and in that, method definition will be empty.

example: abstract class Fly{
            fly();
        }   
        class FlyWithWings extends Fly{
            fly(){
                System.out.println("Flying with wings");
            }
        }
        class NoFly extends Fly{
            fly(){

            }
        }

        Now here if we our object is not flying then it will come to NoFly class and call fly() method of this class and we will not get NullObjectException.