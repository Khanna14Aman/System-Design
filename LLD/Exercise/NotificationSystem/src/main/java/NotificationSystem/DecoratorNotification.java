package NotificationSystem;

public abstract class DecoratorNotification implements Notification {
    protected Notification baseNotification;

    public DecoratorNotification(Notification baseNotification) {
        this.baseNotification = baseNotification;
    }

    @Override
    public abstract String getNotification();
}
