package Observable;

import Observer.Observer;

public interface ObservableItem {
    void add(Observer obj);
    void remove(Observer obj);
    void setData(int num);
    void notifySubscribers();
    int returnData();
}
