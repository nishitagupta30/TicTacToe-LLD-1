package tictactoe.observer;

import java.util.*;
import tictactoe.Game;;

public class ScoreBoard implements GameObserver{

    private final Map<Long, Long> scoreBoard;

    public ScoreBoard() {
        this.scoreBoard = new HashMap<>();
    }

    @Override 
    public void update(Game game) {
        if (game.getWinner() == null) {
            return;
        }
        scoreBoard.put(game.getWinner().getPlayerId(),scoreBoard.getOrDefault(game.getWinner().getPlayerId(), 0L) + 1);
    }

    public void printScoreBoard() {
        System.out.println("Score Board:");
        for(Map.Entry<Long, Long> entry : scoreBoard.entrySet()){
            System.out.println("Player " + entry.getKey() + ": " + entry.getValue());
        }
    }
    
}
