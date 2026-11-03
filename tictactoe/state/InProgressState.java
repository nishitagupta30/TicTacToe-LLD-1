package tictactoe.state;

import tictactoe.Game;
import tictactoe.enums.GameStatus;
import tictactoe.enums.Symbol;
import tictactoe.models.Player;

public class InProgressState implements GameState {

    @Override 
    public void handleMove(Game game, Player player, int row, int col) {
        if(game.getCurrentPlayer() != player){
            throw new IllegalStateException("It's not your turn!");
        }

        game.getBoard().updateBoard(row, col, player);

        if(game.checkWinner()){
            game.setWinner(player);
            if(player.getPlayerSymbol() == Symbol.SYMBOL_X){
                game.setGameStatus(GameStatus.WINNER_X);
            }else{
                game.setGameStatus(GameStatus.WINNER_O);
            }
            game.setState(new WinnerState());
        }
        else if(game.getBoard().isFull()){
            game.setGameStatus(GameStatus.DRAW);
            game.setState(new DrawState());
        }

        game.updateCurrentPlayer();
    }
    
}
