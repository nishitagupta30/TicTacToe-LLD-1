package tictactoe.models;

import tictactoe.enums.Symbol;

public class Board {

    private final int boardSize;
    private final String[][] board;

    public Board(int boardSize){
        if(boardSize <=0 || boardSize > 10){
            throw new IllegalArgumentException("Board Size must be between 1 and 10");
        }

        this.boardSize = boardSize;
        this.board = new String[boardSize][boardSize];

        for(int i=0;i<boardSize;i++){
            for(int j=0;j<boardSize;j++){
                board[i][j] = Symbol.EMPTY.getSymbol();
            }
        }
    }

    public int getBoardSize(){
        return this.boardSize;
    }

    public void printBoard(){
        System.out.println("--------------------------");
        for(int i=0;i<boardSize;i++){
            System.out.print("|");
            for(int j=0;j<boardSize;j++){
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    public void updateBoard(int row, int col, Player player){

        if(row < 0 || row >= boardSize || col < 0 || col >= boardSize){
            throw new IllegalArgumentException("Invalid board position");
        }else if(board[row][col] != Symbol.EMPTY.getSymbol()){
            throw new IllegalArgumentException("Position already occupied");
        }

        board[row][col] = player.getPlayerSymbol().getSymbol();
    }

    public boolean isFull(){
        boolean flag = true;

        for(int i=0;i<boardSize;i++){
            for(int j=0;j<boardSize;j++){
                if(board[i][j].equals(Symbol.EMPTY.getSymbol())){
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public String getBoardCell(int row, int col){
        if(row < 0 || row >= boardSize || col < 0 || col >= boardSize){
            throw new IllegalArgumentException("Invalid board position");
        }

        return board[row][col];
    }
    
}
