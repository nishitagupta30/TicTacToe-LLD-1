package tictactoe.strategy;

import tictactoe.models.Board;
import tictactoe.models.Player;

public class DiagonalWinningStrategy implements WinningStrategy {

    @Override 
    public boolean checkWinner(Board board, Player currentPlayer){

        String currentPlayerSymbol = currentPlayer.getPlayerSymbol().getSymbol();
        int boardSize = board.getBoardSize();

        boolean won = true;

        for(int i=0;i<boardSize;i++){
            if(!board.getBoardCell(i, i).equals(currentPlayerSymbol)){
                won = false;
            }
        }

        if(won) return true;

        for(int i=0;i<boardSize;i++){
            if(!board.getBoardCell(i, boardSize - 1 - i).equals(currentPlayerSymbol)){
                won = false;
            }
        }

        return won;
    }
    
}
