package VisitorsDesignPattern;

public class FindSize implements Visitor{
    public void visitor(TextFile textFile){
        System.out.println("Size of "+textFile.getDocumentType()+" is 8KB");
    }
    public void visitor(ImageFile imageFile){
        System.out.println("Size of "+imageFile.getDocumentType()+" is 10KB");
    }
    public void visitor(PDFFile pdfFile){
        System.out.println("Size of "+pdfFile.getDocumentType()+" is 20KB");
    }
}
