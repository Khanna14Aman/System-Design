package TicTacToe;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TicTacToe {
    ArrayDeque<Player> playerQueue = new ArrayDeque<>();
    Board playingBoard;
    boolean isWinner = false;
    Scanner sc = new Scanner(System.in);
    public void initialize(){
        Player player1 = new Player("John", new PlayingShapeO());
        Player player2 = new Player("Cena", new PlayingShapeX());
        playingBoard = new Board(3);
        playerQueue.offer(player1);
        playerQueue.offer(player2);
    }

    public void startPlaying(){
        while(!isWinner){
            Player currPlayer = playerQueue.poll();
            playingBoard.displayBoard();
            assert currPlayer != null;
            System.out.println(currPlayer.getName()+" Please play your chance");
            System.out.println("Enter row:");
            int i = sc.nextInt();
            System.out.println("Enter column:");
            int j = sc.nextInt();
            boolean isValid = playingBoard.isValid(i,j);
            if(!isValid){
                System.out.println(currPlayer.getName()+" you have entered wrong value");
                playerQueue.offerFirst(currPlayer);
                continue;
            }
            boolean isAvailable = playingBoard.isAvailable(i,j);
            if(!isAvailable){
                System.out.println(currPlayer.getName()+" the place "+i+" "+j+" is already occupied, please enter new value");
                playerQueue.offerFirst(currPlayer);
                continue;
            }
            playingBoard.addValue(i,j,currPlayer.getPlayerShape());
            boolean playerWon = playingBoard.findWinner(i,j,currPlayer.getPlayerShape());
            if(playerWon){
                isWinner = true;
                System.out.println("Congratulations "+currPlayer.getName()+" you won the match");
                break;
            }
            boolean isTied = playingBoard.isTied();
            if(isTied){
                isWinner = true;
                System.out.println("Match Tied");
                break;
            }
            playerQueue.offer(currPlayer);
        }
    }
}
