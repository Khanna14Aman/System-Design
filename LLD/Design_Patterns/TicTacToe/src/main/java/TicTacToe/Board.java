package TicTacToe;

public class Board {
    private int size;
    private PlayingShape[][] playingBoard;
    public Board(int _size){
        size = _size;
        playingBoard = new PlayingShape[size][size];
    }

    public boolean isAvailable(int i,int j){
        return playingBoard[i][j] == null;
    }
    public boolean isValid(int i,int j){
        return i < size && j< size && i >= 0 && j >= 0;
    }
    public void addValue(int i,int j, PlayingShape _playingShape){
        playingBoard[i][j] = _playingShape;
    }

    public void displayBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(j==0){
                    System.out.print("|  ");
                }
                if(playingBoard[i][j]!=null) System.out.print(playingBoard[i][j].shape.name() + "  |  ");
                else System.out.print("  |  ");
            }
            System.out.println();
        }
    }
    public boolean findWinner(int row, int col, PlayingShape _shape){
        boolean rowWinner = true;
        boolean colWinner = true;
        boolean lToRDiagonal = true;
        boolean rToLDiagonal = true;
        for(int j = 0; j<size; j++){
            if (playingBoard[row][j] != _shape) {
                rowWinner = false;
                break;
            }
        }
        for(int i=0;i<size;i++){
            if (playingBoard[i][col] != _shape) {
                colWinner = false;
                break;
            }
        }
        for(int i=0, j=0; i<size && j<size; i++, j++){
            if(playingBoard[i][j] != _shape){
                lToRDiagonal = false;
                break;
            }
        }
        for(int i=0, j = size-1;i<size && j>=0; i++,j--){
            if(playingBoard[i][j] != _shape){
                rToLDiagonal = false;
                break;
            }
        }
        return colWinner | rowWinner | lToRDiagonal | rToLDiagonal;
    }

    public boolean isTied(){
        for(int i=0;i<size;i++){
            for(int j = 0;j<size;j++){
                if(playingBoard[i][j] == null)return false;
            }
        }
        return true;
    }

}
