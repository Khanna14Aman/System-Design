package org.example;

public class Factory {
    public static Shapes createShape(String value){
        switch (value){
            case "Square":
                return new Square();
            case "Rectangle":
                return new Rectancle();
            case "Circle":
                return new Circle();
        }
        return null;
    }
}
