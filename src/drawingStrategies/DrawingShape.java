/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawingStrategies;

import tetris2.TetrisShape;

/**
 *
 * @author PR
 */
public class DrawingShape implements DrawingStrategy{
    private TetrisShape shape;
    
    public DrawingShape(TetrisShape shape){
        this.shape = shape;
    }
    
    @Override
    public boolean doesApply(int x, int y) {
        return shape.isShape(x, y);
    }

    @Override
    public void draw() {
        System.out.print("* ");
    }
}
