package MediatorDesignPattern;

public interface IMediator {
    void registerColleague(Colleague col);
    void broadCast(Colleague from, String msg);
    void sendPrivate(Colleague from, Colleague to, String msg);
}
