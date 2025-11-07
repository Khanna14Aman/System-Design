package NotificationSystem;

public class NormalNotification implements Notification {
    private String content;

    public NormalNotification(String content) {
        this.content = content;
    }

    @Override
    public String getNotification() {
        return "Normal Notification: " + content;
    }
}
