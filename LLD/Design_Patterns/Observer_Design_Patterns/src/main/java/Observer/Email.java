package Observer;

import Observable.ObservableItem;

public class Email implements Observer {
    ObservableItem Item;
    public Email(ObservableItem item){
        Item = item;
    }

    public void updateSubscribers(){
        System.out.println("We have " + Item.returnData() + " no of Iphones reply on email");
    }

}
