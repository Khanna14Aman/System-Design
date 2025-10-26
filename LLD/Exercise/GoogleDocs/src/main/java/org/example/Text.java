package org.example;

public class Text implements DocumentElement{
    String text;
    Text(String _text){
        text = _text;
    }
    public String render(){
        return text;
    }
}
