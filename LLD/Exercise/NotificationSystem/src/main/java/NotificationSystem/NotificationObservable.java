package NotificationSystem;

public class NotificationObservable extends Abstract_Observable {
    private String content;

    public void setNotification(String content) {
        this.content = content;
        notifyObservers();
    }

    public String getNotificationContent() {
        return content;
    }
}
