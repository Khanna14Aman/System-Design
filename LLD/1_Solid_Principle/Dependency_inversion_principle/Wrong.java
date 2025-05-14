// class should depend on abstractions or interfaces, not on concrete classes

interface keyboard {
    void type();
}
class WiredKeyboard implements keyboard {
    public void type() {
        System.out.println("Typing with wired keyboard");
    }
}

class WirelessKeyboard implements keyboard {
    public void type() {
        System.out.println("Typing with wireless keyboard");
    }
}

interface mouse {
    void click();
}

class WiredMouse implements mouse {
    public void click() {
        System.out.println("Clicking with wired mouse");
    }
}

class WirelessMouse implements mouse {
    public void click() {
        System.out.println("Clicking with wireless mouse");
    }
}

class Computer {
    private WiredKeyboard keyboard;
    private WiredMouse mouse;

    public Computer(WiredKeyboard keyboard, WiredMouse mouse) {
        this.keyboard = keyboard;
        this.mouse = mouse;
    }

    public void use() {
        keyboard.type();
        mouse.click();
    }
}
public class Wrong {
    public static void main(String[] args) {
        WiredKeyboard keyboard = new WiredKeyboard();
        WiredMouse mouse = new WiredMouse();
        Computer computer = new Computer(keyboard, mouse);
        computer.use();
    }
}
// In this example, the Computer class depends on concrete classes WiredKeyboard and WiredMouse.
// In this example, the Computer class is tightly coupled to the WiredKeyboard and WiredMouse classes.
// This means that if we want to use a different type of keyboard or mouse, we have to modify the Computer class.
// This violates the Dependency Inversion Principle, which states that high-level modules should not depend on low-level modules.
// Instead, both should depend on abstractions. To fix this, we can use interfaces to decouple the classes.
// By using interfaces, we can create a more flexible and maintainable design.
