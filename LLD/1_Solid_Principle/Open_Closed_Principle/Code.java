// open for extension, closed for modification
// The Open/Closed Principle (OCP) states that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.
// We shouldn't modify existing code which already tested and present in production to add new functionality. Instead, we should extend the existing code.

class Shape {
    public double area() {
        return 0;
    }
} // This class is in production and currently being used to return area of a shape.
// If we need to add new functionality to calculate parameter of a shape, we shouldn't modify the existing code.
// Instead, we should extend the existing code.
class Shape{
    public double area() {
        return 0;
    }
    public double perimeter() {
        return 0;
    }
} // This is wrong way to implement OCP.

// Instead, we should create interfaces and implement them in the classes.
interface Shape {
    double calculate();
}

class Area implements Shape {
    public double calculate() {
        // Calculate area
        return 0;
    }
}

class Perimeter implements Shape {
    public double calculate() {
        // Calculate perimeter
        return 0;
    }
} // This is the correct way to implement OCP.  
