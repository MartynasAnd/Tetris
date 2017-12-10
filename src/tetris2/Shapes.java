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
public enum Shapes{

    /**
     *
     */
    ShapeI(new int[][] {{5,1}, {5,2}, {5,3}, {5,4}}, true ),
    ShapeJ(new int[][] {{6,1}, {6,2}, {5,3}, {6,3}}, true ),
    ShapeL(new int[][] {{5,1}, {5,2}, {5,3}, {6,3}}, true ),
    ShapeO(new int[][] {{5,1}, {6,1}, {5,2}, {6,2}}, false ),
    ShapeS(new int[][] {{5,1}, {6,1}, {4,2}, {5,2}}, true ),
    ShapeT(new int[][] {{5,1}, {5,2}, {6,2}, {5,3}}, true ),
    ShapeZ(new int[][] {{4,1}, {5,1}, {5,2}, {6,2}}, true );
    
    public int[][] coords;
    public boolean Rotating;
 
    private Shapes(int[][] coords, boolean Rotating) {
      this.coords = coords;
      this.Rotating = Rotating;
    }
    
    public static Shapes getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
