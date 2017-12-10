/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris2;

/**
 *
 * @author PR
 */
public class Score {
    
    private int SCORE;
    
    public Score(){
        SCORE = 0;
    }

    public int getScore() {
        return SCORE;
    }

    public void increseScore() {
        this.SCORE++;
    }
}
