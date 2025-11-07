package NotificationSystem;

public class SMSObserver extends Abstract_Observer {
    private String sms;

    public SMSObserver(String sms, NotificationObservable observable) {
        super(observable);
        this.sms = sms;
    }

    @Override
    public void update() {
        System.out.println("SMS sent to " + sms + ": " + observable.getNotificationContent());
    }
}
