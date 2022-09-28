package com.bridgelabz.TicTacToe;

import java.util.Arrays;

public class TicTacToeGame {
    private static final char EMPTY = ' ';
    private static final char CROSS = 'X';
    private static final char ROUND = 'O';
    private char[] board;
    private char playerSymbol;
    private char computerSymbol;
    private int moveCount;


    TicTacToeGame() {
        board = new char[10];
        Arrays.fill(board,EMPTY);
    }

    private TicTacToeGame(char[] board, char playerSymbol, char computerSymbol,int moves) {
        this.board = board;
        this.playerSymbol = playerSymbol;
        this.computerSymbol = computerSymbol;
        this.moveCount = moves;
    }

    private TicTacToeGame getCopy() {
        return new TicTacToeGame(Arrays.copyOf(this.board, 10), this.playerSymbol, this.computerSymbol, this.moveCount);
    }

    public char getPlayerSymbol() {
        return playerSymbol;
    }

    public char getComputerSymbol() {
        return computerSymbol;
    }

    public int getMoveCount() {
        return moveCount;
    }


    /**
     * @param row is for Row position on the board
     * @param col is for Column position on the board
     * @return It will give 0-based array index
     */
    private static int getIndex(int row, int col) {
        return 3 * (row - 1) + (col - 1);
    }

    /*
    * Choosing player symbol either 'X' or 'O'
    *
    * @param playerSymbol
    * */

    public void choosePlayerSymbol(char playerSymbol) {
        if (playerSymbol == CROSS) {
            this.playerSymbol = CROSS;
            this.computerSymbol = ROUND;
        } else if (playerSymbol == ROUND) {
            this.playerSymbol = ROUND;
            this.computerSymbol = CROSS;
        } else
            System.out.println("Invalid Symbol");
    }

    /**
     * Printing the board
     */
    public void showBoard() {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (j == 3)
                    System.out.print(board[getIndex(i, j)]);
                else
                    System.out.print(board[getIndex(i, j)] + " | ");

            }
            System.out.println("");
            if (i != 3)
                System.out.println("---------");
        }
    }

    /**
     * Check if an Index is free or not
     *
     * @param row , selecting row
     * @param col , selecting column
     * @return If position is full, then it will return false
     */
    private boolean isFree(int row, int col) {
        if (row > 3 || row < 1 || col > 3 || col < 1)
            System.out.println("Invalid position!");

        if (board[getIndex(row, col)] == EMPTY)
            return true;
        return false;
    }

    private boolean isFree(int position) {
        if (position < 1 || position > 9)
            System.out.println("Invalid position!");
        if (board[position - 1] == EMPTY)
            return true;
        return false;
    }

    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        System.out.println("Player symbol is: " + game.getPlayerSymbol());
        System.out.println("initial:");
        game.showBoard();
    }
}
