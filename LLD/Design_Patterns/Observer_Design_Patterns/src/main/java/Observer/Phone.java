package Observer;

import Observable.ObservableItem;

public class Phone implements Observer{
    ObservableItem Item;
    public Phone(ObservableItem item){
        Item = item;
    }

    public void updateSubscribers(){
        System.out.println("We have "+ Item.returnData() + " no of Iphones reply to phone");
    }
}
