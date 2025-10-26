package org.example;

import java.util.ArrayList;
import java.util.List;

public class Editor {
    private Persistance saveType;
    private List<Pages> pages = new ArrayList<>();
    Editor(Persistance p){
        saveType = p;
    }
    public int getTotalPages(){
        return pages.size();
    }
    public void addNewPage(Pages _page){
        pages.add(_page);
    }
    public void addElementInPage(int n,DocumentElement _element) throws IndexOutOfBoundsException{
        try{
        pages.get(n).addElement(_element);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Error Occured :"+e.getMessage());
        }
    }
    public void renderPageElement(int n){
        System.out.println(pages.get(n).pageRender());
    }
    public void savePageData(int n){
        saveType.save(pages.get(n).pageRender());
    }
}
