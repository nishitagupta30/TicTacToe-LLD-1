package tictactoe.models;

import tictactoe.enums.Symbol;

public class Player {

    private final long playerId;
    private final String playerName;
    private final Symbol symbol;

    public Player(long playerId, String playerName, Symbol symbol) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.symbol = symbol;
    }

    public long getPlayerId(){
        return playerId;
    }

    public String getPlayerName(){
        return playerName;
    }

    public Symbol getPlayerSymbol(){
        return symbol;
    }

}
