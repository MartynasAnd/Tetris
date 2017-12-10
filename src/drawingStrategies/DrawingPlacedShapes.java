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
public class DrawingPlacedShapes implements DrawingStrategy{
    private GameBoard board;
    
    public DrawingPlacedShapes(GameBoard board){
        this.board = board;
    }
    
    @Override
    public boolean doesApply(int x, int y) {
        return board.isPlacedFigure(x, y);
    }

    @Override
    public void draw() {
        System.out.print("* ");
    }
    
}
