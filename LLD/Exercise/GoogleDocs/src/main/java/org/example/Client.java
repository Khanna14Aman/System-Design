package org.example;

public class Client {
    public static void main(String [] args){
        Editor editor = new Editor(new FileSave());
        System.out.println(editor.getTotalPages());
        editor.addNewPage(new Pages());
        System.out.println(editor.getTotalPages());
        editor.addElementInPage(0,new Text("Hello World"));
        editor.addElementInPage(0,new NextLine());
        editor.addElementInPage(0,new Image("Desktop"));
        editor.addElementInPage(0,new NextLine());
        editor.addElementInPage(0,new StartTab());
        editor.addElementInPage(0,new Text("Thank you"));
        editor.renderPageElement(0);
        editor.savePageData(0);

    }
}
