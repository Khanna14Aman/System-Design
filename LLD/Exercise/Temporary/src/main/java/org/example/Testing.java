package org.example;

interface MyInterface {
      default void show(){
          System.out.println("This is deault method of interface");
      }
      default void showy(){
          System.out.println("This is showy method of interface");
          showPrivate();
      }
      static void showStatic(){
          System.out.println("This is a static method of interface");
      }
      private void showPrivate(){
          System.out.println("This is private method of interface");
      }
}