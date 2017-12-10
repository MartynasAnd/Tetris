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
public class TetrisShape {
    
    private int[][] COORDS;
    private Shapes SHAPE;
    private boolean Rotating;
    private int[][] TempShape;
    private Moves movementDirection;
    
    public TetrisShape(){
        SHAPE = generateShape();
        Rotating = SHAPE.Rotating;
        COORDS = new int[4][2];
        TempShape = new int[4][2];
        setShapeCoords(SHAPE);
    }
    
    public void setShape(){
        SHAPE = generateShape();
        Rotating = SHAPE.Rotating;
        setShapeCoords(SHAPE);
    }
    
    private void setShapeCoords(Shapes shape) {
        for (int i = 0; i < 4; i++) {
          for (int j = 0; j < 2; ++j) {
            COORDS[i][j] = shape.coords[i][j];
          }
        }
        SHAPE = shape;
     }
    
    private Shapes generateShape(){ 
        Shapes generatedShape =  Shapes.getRandom();
        return generatedShape;
    }
    
    public boolean getRotating(){
        return this.Rotating;
    }
    
    public boolean isShape(int x, int y){
        if(x == 0 && y == 0){
            return false;
        }
        
        for(int i = 0; i < 4; i++){
            if(COORDS[i][0] == x && COORDS[i][1] == y){
                 return true;
            }
        }
        return false;
    }
    
    public int getCoordValue(int x, int y){
        return COORDS[y][x];
    }
    
    public int getTempShapeCoordValue(int x, int y){
        return TempShape[y][x];
    }
    
    public Moves getDirection() {
	return movementDirection;
    }
    
    public void setMoveDirection(Moves move) {
	this.movementDirection = move;
    }
    
    public void shapeMoveDown(){
        for(int i = 0; i < 4; i++){
            this.COORDS[i][1] = this.COORDS[i][1]+1;
        }
    }
    
    public void shapeMoveLeft(){
        for(int i = 0; i < 4; i++){
            this.COORDS[i][0] = this.COORDS[i][0]-1;
        }
    }
    
    public void shapeMoveRight(){
        for(int i = 0; i < 4; i++){
            this.COORDS[i][0] = this.COORDS[i][0]+1;
        }
    }
    
    public void createTempShape(){
        double centerX = this.COORDS[1][0];
        double centerY = this.COORDS[1][1];
        double x1, x2, y1, y2;
        
        for(int i = 0; i < 4; i++){
                x1 = this.COORDS[i][0] - centerX;
                y1 = this.COORDS[i][1] - centerY;
                x2 = x1 * Math.cos(Math.toRadians(90)) - y1 * Math.sin(Math.toRadians(90));
                y2 = x1 * Math.sin(Math.toRadians(90)) + y1 * Math.cos(Math.toRadians(90));
                this.TempShape[i][0] = (int) (x2 + centerX);
                this.TempShape[i][1] = (int) (y2 + centerY);
        }
    }
    
    public void rotateShape(){
        for(int i = 0; i < 4; i++){
            this.COORDS[i][0] = this.TempShape[i][0];
            this.COORDS[i][1] = this.TempShape[i][1];
        }
    }
}
