package VisitorsDesignPattern;

public class VisitorDesignMain {
    public static void main(String [] args){
        DocumentElement textFile = new TextFile("TextFile");
        DocumentElement imageFile = new ImageFile("Image.jpg");
        DocumentElement pdfFile = new PDFFile("Visitors.pdf");
        Visitor findSize = new FindSize();
        Visitor compressedFile = new CompressDocument();
        textFile.accept(findSize);
        imageFile.accept(findSize);
        pdfFile.accept(findSize);
        textFile.accept(compressedFile);
        imageFile.accept(compressedFile);
        pdfFile.accept(compressedFile);
    }
}
