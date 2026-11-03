package tictactoe.strategy;

import tictactoe.models.*;

public class ColumnWinningStrategy implements WinningStrategy {

    @Override 
    public boolean checkWinner(Board board, Player currentPlayer){

        String currentPlayerSymbol = currentPlayer.getPlayerSymbol().getSymbol();
        int boardSize = board.getBoardSize();


        for(int i=0;i<boardSize;i++){
            int count = 0;
            for(int j=0;j<boardSize;j++){
                if(board.getBoardCell(j, i).equals(currentPlayerSymbol)){
                    count++;
                }
            }
            if(count == boardSize){
                return true;
            }
        }
        return false;
    }
    
}
