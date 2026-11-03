package tictactoe;

import tictactoe.state.GameState;
import tictactoe.state.InProgressState;
import tictactoe.strategy.RowWinningStrategy;
import tictactoe.enums.GameStatus;
import tictactoe.models.*;
import tictactoe.observer.GameSubject;
import tictactoe.strategy.*;
import java.util.*;


public class Game extends GameSubject{

    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private Player winner;
    private GameStatus status;
    private GameState state;
    private final List<WinningStrategy> winningStrategies;

    public Game(Player player1, Player player2) {
        this.board = new Board(3);
        this.player1 = player1;
        this.player2 = player2;
        this.winningStrategies = new ArrayList<>(Arrays.asList(
            new RowWinningStrategy(),
            new ColumnWinningStrategy(),
            new DiagonalWinningStrategy()
        ));
        this.currentPlayer = player1;
        this.status = GameStatus.IN_PROGRESS;
        this.state = new InProgressState();
    }

    public boolean checkWinner() {
        for( WinningStrategy strategy: winningStrategies) {
            if(strategy.checkWinner(this.board, this.currentPlayer)){
                return true;
            }
        }
        return false;
    }

    public void setGameStatus(GameStatus status){ 
        this.status = status; 

        if(this.status != GameStatus.IN_PROGRESS){
            notifyObservers();
        }
    
    }

    public void makeMove(Player player, int row, int col) {
        state.handleMove(this, player, row, col);
    }

    public void updateCurrentPlayer(){
        this.currentPlayer = (this.currentPlayer == player1) ? player2 : player1;
    }

    public void setWinner(Player player){ this.winner = player; }
    public void setState(GameState state){ this.state = state; }

    public Board getBoard(){ return this.board; }
    public Player getPlayer1(){return this.player1;}
    public Player getPlayer2(){return this.player2;}
    public Player getCurrentPlayer(){return this.currentPlayer;}
    public GameStatus getStatus(){return this.status;}
    public GameState getState(){return this.state;}
    public Player getWinner(){return this.winner;}

}
