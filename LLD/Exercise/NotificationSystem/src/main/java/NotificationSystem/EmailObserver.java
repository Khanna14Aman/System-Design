package NotificationSystem;

public class EmailObserver extends Abstract_Observer {
    private String email;

    public EmailObserver(String email, NotificationObservable observable) {
        super(observable);
        this.email = email;
    }

    @Override
    public void update() {
        System.out.println("Email sent to " + email + ": " + observable.getNotificationContent());
    }
}
