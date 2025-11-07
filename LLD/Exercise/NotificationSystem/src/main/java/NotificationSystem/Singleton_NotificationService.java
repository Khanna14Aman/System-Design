package NotificationSystem;

import java.util.*;

public class Singleton_NotificationService {
    private static Singleton_NotificationService instance;
    private List<Notification> notificationList = new ArrayList<>();
    private NotificationObservable observable;
    private Notification currentNotification;

    private Singleton_NotificationService() {}

    public static synchronized Singleton_NotificationService getInstance() {
        if (instance == null) {
            instance = new Singleton_NotificationService();
        }
        return instance;
    }

    public void setNotification(Notification notification) {
        this.currentNotification = notification;
        notificationList.add(notification);
        sendNotification(notification);
    }

    private void sendNotification(Notification notification) {
        if (observable != null) {
            observable.setNotification(notification.getNotification());
        }
    }

    public Notification getCurrentNotification() {
        return currentNotification;
    }

    public void setObservable(NotificationObservable observable) {
        this.observable = observable;
    }
}
