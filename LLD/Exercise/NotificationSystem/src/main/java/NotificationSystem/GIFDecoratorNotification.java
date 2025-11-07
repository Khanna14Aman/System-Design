package NotificationSystem;

public class GIFDecoratorNotification extends DecoratorNotification {

    public GIFDecoratorNotification(Notification baseNotification) {
        super(baseNotification);
    }

    @Override
    public String getNotification() {
        return baseNotification.getNotification() + " + GIF added";
    }
}
