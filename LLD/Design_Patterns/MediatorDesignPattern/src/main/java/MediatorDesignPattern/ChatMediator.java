package MediatorDesignPattern;

import java.util.ArrayList;
import java.util.List;

class Pair<T,S>{
    private final T who;
    private final S whom;
    public Pair(T who, S whom){
        this.who = who;
        this.whom = whom;
    }
    public T getWho(){
        return who;
    }
    public S getWhom(){
        return whom;
    }
}

public class ChatMediator implements IMediator{
    private static final ChatMediator obj;
    private final List<Colleague> colleagueList;
    private final List<Pair<String,String>> mutedList;
    private ChatMediator(){
        mutedList = new ArrayList<>();
        colleagueList = new ArrayList<>();
    }
    static{
        obj = new ChatMediator();
    }
    public static ChatMediator getObject(){
        return obj;
    }

    public void registerColleague(Colleague col){
        colleagueList.add(col);
    }
    public void removeColleague(Colleague col){
        colleagueList.remove(col);
    }

    public void broadCast(Colleague from, String msg){
        for(Colleague colleague: colleagueList){
            if(colleague == from){
                continue;
            }
            boolean send = true;
            for(Pair<String,String> obj: mutedList){
                if(obj.getWho().equalsIgnoreCase(colleague.getName()) && obj.getWhom().equalsIgnoreCase(from.getName())){
                    send = false;
                    break;
                }
            }
            if(send){
                colleague.receive(from.getName(),msg);
            }
        }
    }

    public void sendPrivate(Colleague from, Colleague to, String msg){
        if(from == to)return;
        for(Pair<String,String> obj: mutedList){
            if(obj.getWho().equalsIgnoreCase(to.getName()) && obj.getWhom().equalsIgnoreCase(from.getName())){
                return;
            }
        }
        to.receive(from.getName(),msg);
    }
    public void mute(String who, String whom){
        mutedList.add(new Pair<>(who,whom));
    }

    public void removeMuted(String who, String whom){
        int ind = -1;
        for(int i=0;i<mutedList.size();i++){
            if(mutedList.get(i).getWho().equalsIgnoreCase(who) && mutedList.get(i).getWhom().equalsIgnoreCase(whom)){
                ind = i;
                break;
            }
        }
        if(ind != -1){
            mutedList.remove(ind);
        }
    }
}
