/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris2;

import drawingStrategies.DrawingPlacedShapes;
import drawingStrategies.DrawingShape;
import drawingStrategies.DrawingStrategy;
import drawingStrategies.DrawingWall;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PR
 */
public class GameRenderer {
    private GameBoard board;
    private TetrisShape shape;
    
    private List<DrawingStrategy> drawingStrategies = new ArrayList<>();


    public GameRenderer(GameBoard board, TetrisShape shape){
	this.board = board;
	this.shape = shape;

	drawingStrategies.add(new DrawingShape(shape));
	drawingStrategies.add(new DrawingWall(board));
	drawingStrategies.add(new DrawingPlacedShapes(board));
    }
	
    public void render(){
	for (int y = 0; y < board.getHeight(); y++){
            for (int x = 0; x < board.getWidth(); x++){
		drawElement(y, x);
            }
            System.out.println();
	}
    }

    private void drawElement(int y, int x) {
	for (DrawingStrategy strategy : drawingStrategies) {
            if (strategy.doesApply(x, y)) {
                strategy.draw();
                return;
            }
        }
        System.out.print("  ");
	}
}
