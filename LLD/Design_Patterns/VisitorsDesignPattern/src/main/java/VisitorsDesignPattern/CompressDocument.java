package VisitorsDesignPattern;

public class CompressDocument implements Visitor{
    public void visitor(TextFile textFile){
        System.out.println("Compressing "+textFile.getDocumentType());
    }
    public void visitor(ImageFile imageFile){
        System.out.println("Compressing "+imageFile.getDocumentType());
    }
    public void visitor(PDFFile pdfFile){
        System.out.println("Compressing "+pdfFile.getDocumentType());
    }
}
