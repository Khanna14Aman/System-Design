package org.example;

public class Main {
    public static void main(String[] args) {
        Shapes circle = Factory.createShape("Circle");
        circle.draw();
        Shapes rectangle = Factory.createShape("Rectangle");
        rectangle.draw();
    }
}