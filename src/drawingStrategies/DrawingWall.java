/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawingStrategies;

import tetris2.GameBoard;

/**
 *
 * @author PR
 */
public class DrawingWall implements DrawingStrategy{
    private GameBoard board;
    
    public DrawingWall(GameBoard board){
        this.board = board;
    }
    
    @Override
    public boolean doesApply(int x, int y) {
        return board.isWall(x, y) || board.isBottom(x, y);
    }

    @Override
    public void draw() {
        System.out.print("# ");
    }
    
}
