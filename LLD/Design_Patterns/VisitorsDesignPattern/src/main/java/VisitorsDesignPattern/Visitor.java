package VisitorsDesignPattern;

public interface Visitor {
    void visitor(TextFile textFile);
    void visitor(ImageFile imageFile);
    void visitor(PDFFile pdfFile);
}
