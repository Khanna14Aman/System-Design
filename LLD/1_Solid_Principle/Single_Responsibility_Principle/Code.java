class Marker{
    String name;
    String color;
    int year;
    int price;

    public Marker(String name, String color, int year, int price){
        this.name = name;
        this.color = color;
        this.year = year;
        this.price = price;
    }
}


class Invoice{
    private Marker marker;  // Here invoice has a marker.
    private int quantity;

    public Invoice(Marker marker, int  quantity){
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateTotal(){
        int price = ((marker.price) * this.quantity);
        return price;
    }

    public void printInvoice(){
        // Print the invoice details
    }

    public void saveToDB(){
        // Save the invoice to the database
    }
}

// Above mentioned class Invoice is not following the Single Responsibility Principle.
// It has multiple responsibilities like calculating total, printing invoice and saving to DB. If any of these responsibilities change, we need to change the Invoice class.
// To follow the Single Responsibility Principle, we can create separate classes for each responsibility.

class CorrectInvoice{
    // This class is responsible for calculating the total price of the invoice
    // It has only one responsibility.
    // If the calculation logic changes, we only need to change this class.
    private Marker marker;  // Here invoice has a marker.
    private int quantity;

    public CorrectInvoice(Marker marker, int  quantity){
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateTotal(){
        int price = ((marker.price) * this.quantity);
        return price;
    }
}

class InvoicePrinter{
    // This class is responsible for printing the invoice
    // It has only one responsibility.
    // If the printing format changes, we only need to change this class.
    CorrectInvoice invoice;
    public InvoicePrinter(CorrectInvoice invoice){
        this.invoice = invoice;
    }
    public void printInvoice(){
        // Print the invoice details
    }
}

class InvoiceSaver{
    // This class is responsible for saving the invoice to the database
    // It has only one responsibility.
    // If the database changes, we only need to change this class.
    CorrectInvoice invoice;
    public InvoiceSaver(CorrectInvoice invoice){
        this.invoice = invoice;
    }
    public void saveToDB(){
        // Save the invoice to the database
    }
}

// Now we have separate classes for each responsibility.

public class Code {

    public static void main(String[] args) {
        Marker marker = new Marker("Marker1", "Red", 2023, 10);
        CorrectInvoice invoice = new CorrectInvoice(marker, 5);
        InvoicePrinter printer = new InvoicePrinter(invoice);
        InvoiceSaver saver = new InvoiceSaver(invoice);

        int total = invoice.calculateTotal();
        System.out.println("Total: " + total);

        printer.printInvoice();
        saver.saveToDB();
    }
}