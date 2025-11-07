package NotificationSystem;

import java.util.*;

public abstract class Abstract_Observable {
    protected List<Abstract_Observer> observerList = new ArrayList<>();

    public void addObserver(Abstract_Observer observer) {
        observerList.add(observer);
    }

    public void removeObserver(Abstract_Observer observer) {
        observerList.remove(observer);
    }

    protected void notifyObservers() {
        for (Abstract_Observer observer : observerList) {
            observer.update();
        }
    }
}
