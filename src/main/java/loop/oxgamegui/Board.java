/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loop.oxgamegui;

/**
 *
 * @author Windows
 */
public class Board {

    private char[][] table = {{'-', '-', '-'},
    {'-', '-', '-'},
    {'-', '-', '-'}};
    private Player currentPlayer;
    private Player o, x;

    public Board(Player o, Player x) {
        this.o = o;
        this.x = x;
        this.currentPlayer = o;
    }

    public char[][] getTable() {
        return table;
    }

    public void setRowCol(int row, int col) {
        if (table[row - 1][col - 1] == '-'){
            this.table[row - 1][col - 1] = currentPlayer.getName();
        } else {
            throw new IllegalStateException("Spot taken");
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        if (this.currentPlayer == o) {
            this.currentPlayer = x;
        } else {
            this.currentPlayer = o;
        }
    }

    public boolean checkWin() {
        for (int fix = 0; fix < table.length; fix++) {
            int horizontal = 0;
            int vertical = 0;
            int diagonal = 0;
            int reverseDiagonal = 0;
            for (int move = 0; move < table.length; move++) {
                if (table[fix][move] == currentPlayer.getName()) {
                    horizontal++;
                }
                if (table[move][fix] == currentPlayer.getName()) {
                    vertical++;
                }
                if (table[move][move] == currentPlayer.getName()) {
                    diagonal++;
                }
                if (table[move][2 - move] == currentPlayer.getName()) {
                    reverseDiagonal++;
                }
            }
            if ((horizontal == 3) || (vertical == 3) || (diagonal == 3) || (reverseDiagonal == 3)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkDraw() {
        int n = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3;j++) {
                if (table[i][j] != '-'){
                    n++;
                }
            }
        }
        if (n == 9 && !checkWin()) {
            return true;
        } else {
            return false;
        }
    }

    public void updateScore() {
        if (checkWin()) {
            if (currentPlayer == o) {
                o.win();
                x.lose();
            } else {
                x.win();
                o.lose();
            }
        } else if (checkDraw()) {
            o.draw();
            x.draw();
        }

    }
}
