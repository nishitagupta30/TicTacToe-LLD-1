package tictactoe.state;

import tictactoe.Game;
import tictactoe.models.Player;

public interface GameState {

    public void handleMove(Game game, Player player, int row, int col);

}
