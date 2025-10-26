package org.example;

import java.util.ArrayList;
import java.util.List;

public class Pages {
    private List<DocumentElement> element = new ArrayList<>();

    public void addElement(DocumentElement _element){
        element.add(_element);
    }

    public String pageRender(){
        String view = "";
        for(DocumentElement doc: element){
            view += doc.render();
        }
        return view;
    }
}
