package VisitorsDesignPattern;

public class TextFile extends DocumentElement{
    public TextFile(String documentType){
        super(documentType);
    }

    public void accept(Visitor visitor){
        visitor.visitor(this);
    }
}
