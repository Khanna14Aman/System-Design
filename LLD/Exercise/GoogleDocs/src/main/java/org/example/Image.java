package org.example;

public class Image implements DocumentElement{
    String img;
    Image(String _path){
        img = _path;
    }
    public String render(){
        return "Img Path: "+img;
    }
}
