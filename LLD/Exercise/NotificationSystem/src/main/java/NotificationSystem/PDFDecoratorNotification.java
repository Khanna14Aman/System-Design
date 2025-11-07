package NotificationSystem;

public class PDFDecoratorNotification extends DecoratorNotification {

    public PDFDecoratorNotification(Notification baseNotification) {
        super(baseNotification);
    }

    @Override
    public String getNotification() {
        return baseNotification.getNotification() + " + PDF attached";
    }
}
