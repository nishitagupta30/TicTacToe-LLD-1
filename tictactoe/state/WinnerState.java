package tictactoe.state;

import tictactoe.Game;
import tictactoe.models.Player;

public class WinnerState implements GameState {

    @Override
    public void handleMove(Game game, Player player, int row, int col){
        throw new IllegalStateException("Game is already over! Please start over with a new game.");
    }
    
}
