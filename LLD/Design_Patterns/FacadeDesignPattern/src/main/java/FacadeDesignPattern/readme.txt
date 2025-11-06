The use of Facade Design Pattern is to hide complexity of subsystem with which our client have to interact.
It will provide a class which will work as a mediator and client will interact with that class and that class will interact with the complex sub system.

Eg: Client will just press the CPU button and rest of the backend process will get handle by computer itself. Like: power supply, cooling system, booting process, initializing CPU, initializing Memories, etc.
So here client will not interact with each of the above subsystem like CPU and Hardware. Client will just press the CPU button then internally CPU will manage all the things.



Principle of least knowledge = > Take any object, now from any method in that object, principle tell you to invoke only methods that belong to:
	
	1)The object itself.
	2)The object passed in as a parameter to the method.
	3)Any object that method creates.
	4)Any object with HAS-A relationship;


FacadePattern provides a simplified, unified interface to a set of complex subsystem. It hides the complexity of subsystem and exposes what is necessary.