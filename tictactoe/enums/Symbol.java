package tictactoe.enums;

public enum Symbol {
    SYMBOL_X ("X"),
    SYMBOL_O ("O"),
    EMPTY ("-");

    private String symbol;

    private Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

}
