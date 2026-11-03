package tictactoe.state;

import tictactoe.Game;
import tictactoe.models.Player;

public class DrawState implements GameState {

    @Override
    public void handleMove(Game game, Player player, int row, int col){
        throw new IllegalStateException("Game went for a draw! Please start over with a new game.");
    }
    
}
