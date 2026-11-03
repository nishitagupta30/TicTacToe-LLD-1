package tictactoe.strategy;

import tictactoe.models.*;

public interface WinningStrategy {

    public boolean checkWinner(Board board, Player currentPlayer);

}
