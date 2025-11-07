package NotificationSystem;

public abstract class Abstract_Observer {
    protected NotificationObservable observable;

    public Abstract_Observer(NotificationObservable observable) {
        this.observable = observable;
    }

    public abstract void update();
}
