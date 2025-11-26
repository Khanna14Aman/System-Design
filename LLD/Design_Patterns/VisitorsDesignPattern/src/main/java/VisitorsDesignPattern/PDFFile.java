package VisitorsDesignPattern;

public class PDFFile extends DocumentElement{
    public PDFFile(String documentType){
        super(documentType);
    }
    public void accept(Visitor visitor){
        visitor.visitor(this);
    }
}
