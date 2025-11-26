package VisitorsDesignPattern;

public abstract class DocumentElement {
    private final String documentType;
    DocumentElement(String documentType){
        this.documentType = documentType;
    }
    public String getDocumentType(){
        return this.documentType;
    }
    protected abstract void accept(Visitor visitor);
}
