package TicTacToe;

public class Player {
    private String name;
    private PlayingShape playerShape;
    public Player(String _name, PlayingShape _playerShape){
        this.name = _name;
        this.playerShape = _playerShape;
    }
    public String getName(){
        return name;
    }
    public PlayingShape getPlayerShape(){
        return playerShape;
    }
}
