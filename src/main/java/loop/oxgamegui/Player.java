/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loop.oxgamegui;

/**
 *
 * @author Windows
 */
public class Player {
    private char name;
    private int win;
    private int lose;
    private int draw;
    
    public Player(char name, int win, int lose, int draw) {
        this.name = name;
        this.win = win;
        this.lose = lose;
        this.draw = draw;
    }
    
    public Player(char name) {
        this.name = name;
    }
    
    public char getName() {
        return name;
    }
    public void setName(char name) {
        this.name = name;
    }

    public int getWin() {
        return win;
    }

    public void win() {
        win++;
    }

    public int getLose() {
        return lose;
    }

    public void lose() {
        lose++;
    }

    public int getDraw() {
        return draw;
    }

    public void draw() {
        draw++;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", win=" + win + ", lose=" + lose + ", draw=" + draw + '}';
    }
}
