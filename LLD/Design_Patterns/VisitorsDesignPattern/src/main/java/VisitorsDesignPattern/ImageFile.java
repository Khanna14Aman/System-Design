package VisitorsDesignPattern;

public class ImageFile extends DocumentElement{
    public ImageFile(String documentType){
        super(documentType);
    }

    public void accept(Visitor visitor){
        visitor.visitor(this);
    }
}
