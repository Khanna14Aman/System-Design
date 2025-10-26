package org.example;

import javax.print.Doc;

public class NextLine implements DocumentElement {
    public String render(){
        return "\n";
    }
}
