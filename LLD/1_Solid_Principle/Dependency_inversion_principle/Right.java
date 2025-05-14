interface Keyboard {
    void type();
}

class WiredKeyboard implements Keyboard {
    public void type() {
        System.out.println("Typing with wired keyboard");
    }
}

class WirelessKeyboard implements Keyboard {
    public void type() {
        System.out.println("Typing with wireless keyboard");
    }
}

interface Mouse {
    void click();
}

class WiredMouse implements Mouse {
    public void click() {
        System.out.println("Clicking with wired mouse");
    }
}

class WirelessMouse implements Mouse {
    public void click() {
        System.out.println("Clicking with wireless mouse");
    }
}

class Computer {
    private Keyboard keyboard;
    private Mouse mouse;

    public Computer(Keyboard keyboard, Mouse mouse) {
        this.keyboard = keyboard;
        this.mouse = mouse;
    }

    public void use() {
        keyboard.type();
        mouse.click();
    }
}

public class Right {
    public static void main(String[] args) {
        Keyboard keyboard = new WiredKeyboard();
        Mouse mouse = new WiredMouse();
        Computer computer = new Computer(keyboard, mouse);
        computer.use();
    }
}

// In this example, the Computer class depends on abstractions (Keyboard and Mouse interfaces) rather than concrete implementations.
// This allows for flexibility and easier testing, as we can easily swap out different keyboard and mouse implementations without modifying the Computer class.
// This adheres to the Dependency Inversion Principle, which states that high-level modules should not depend on low-level modules, but both should depend on abstractions.