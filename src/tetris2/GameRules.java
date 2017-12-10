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
public class GameRules {
    private GameBoard board;
    private TetrisShape shape;
    private Score score;
    
    public GameRules(GameBoard board, TetrisShape shape, Score score){
		this.board = board;
		this.shape = shape;
                this.score = score;
    }
    
    private void moveShape(Moves shapeMove) {
	switch(shapeMove){
            case LEFT: shape.shapeMoveLeft(); break; 
            case RIGHT: shape.shapeMoveRight(); break; 
            case DOWN: shape.shapeMoveDown(); break;
            case ROTATE: shape.rotateShape(); break;
	}
    }
    
//    public void decideMove(int n) {
//	switch(n){
//            case 'a': shape.setMoveDirection(Moves.LEFT); break;
//            case 'd': shape.setMoveDirection(Moves.RIGHT); break;
//            case 's': shape.setMoveDirection(Moves.DOWN); break;
//            case 'w': shape.setMoveDirection(Moves.ROTATE); break;
//            case 'x': System.exit(0); break;
//	}
//    }
    
    private boolean checkCollideDown(){
        int x, y;
        for(int i = 0; i < 4; i++){
            x = shape.getCoordValue(0, i);
            y = shape.getCoordValue(1, i);
            if(board.isBottom(x, y+1) || board.isPlacedFigure(x, y+1)){
                return true;
            }
        }
        return false;
    }
    
    private boolean checkCollideRotate(){
        shape.createTempShape();
        int x, y;
        for(int i = 0; i < 4; i++){
            x = shape.getTempShapeCoordValue(0, i);
            y = shape.getTempShapeCoordValue(1, i);
            if(board.getBoardValue(x, y) != 0){
                return true;
            }
        }
        return false;
    }
    
    private boolean checkCollideSide(){
        int x, y;
        for(int i = 0; i < 4; i++){
            x = shape.getCoordValue(0, i);
            y = shape.getCoordValue(1, i);
            if(shape.getDirection().equals(Moves.LEFT) && (board.isWall(x-1, y) || board.isPlacedFigure(x-1, y))){
                return true;
            }
            if(shape.getDirection().equals(Moves.RIGHT) && (board.isWall(x+1, y) || board.isPlacedFigure(x+1, y))){
                return true;
            }
        }
        
        return false;
    }
    
    private void placeFigure(){
        int x, y;
        for(int i = 0; i < 4; i++){
            x = shape.getCoordValue(0, i);
            y = shape.getCoordValue(1, i);
            board.setBoardValue(x, y, 3);
        }
        removeFullLines();
        shape.setShape();
    }
    
    private void removeFullLines() {
        int y;
        while (findFullLine() > 0) {
            y = findFullLine();
            for (int x = 1; x < board.getWidth()-1; x++) {
                board.setBoardValue(x, y, 0);
            }
            pushLinesAfterRemove(y);
            score.increseScore();
        }
    }
    
    private int findFullLine(){
        boolean isLineFull = true;
        for(int y = 1; y < board.getHeight()-1; y++){
            for(int x = 1; x < board.getWidth()-1; x++){
               if(board.getBoardValue(x, y) == 0){
                   isLineFull = false;
               }
            }
            if(isLineFull){
                return y;
            } else {
                isLineFull = true;
            }
        }
        return 0;
    }
    
    private void pushLinesAfterRemove(int iy){
        int value;
        for(int y = iy; y > 1; y--){
            for(int x = 1; x < board.getWidth()-1; x++){
                value = board.getBoardValue(x, y-1);
                board.setBoardValue(x, y, value);
            }
        }
    }
    
    public boolean isGameOver() {
        int x,y;
        for(int i = 0; i < 4; i++){
           x = shape.getCoordValue(0, i);
           y = shape.getCoordValue(1, i);
            if(board.getBoardValue(x, y) != 0){
                return true;
            }
        }
        return false;
    }
    
    public void afterSelect() {
        Moves move = shape.getDirection();
        if(!isGameOver()){
            if((move == Moves.LEFT || move == Moves.RIGHT) && !checkCollideSide()){
                moveShape(move);
            }else if(move == Moves.ROTATE && !checkCollideRotate() && shape.getRotating()){
                moveShape(move);
            }else if(move == Moves.DOWN && !checkCollideDown()){
                moveShape(move);
            }else if(move == Moves.DOWN && checkCollideDown()){
                placeFigure();
            }
        }else{
            System.out.println("Game Over!");
            System.out.println("Your Score Is: " + score.getScore());
            System.exit(0);
        }
    }
}
