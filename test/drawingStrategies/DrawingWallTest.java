/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawingStrategies;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris2.GameBoard;

/**
 *
 * @author PR
 */
public class DrawingWallTest {
    
    private final GameBoard board;
    
    public DrawingWallTest() {
        board = new GameBoard();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of doesApply method, of class DrawingWall.
     */
    @Test
    public void testDoesApply() {
        System.out.println("doesApply test");
        int x = 0;
        int y = 0;
        DrawingWall instance = new DrawingWall(board);
        boolean expResult = true;
        boolean result = instance.doesApply(x, y);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of draw method, of class DrawingWall.
     */
    @Test
    public void testDraw() {
        System.out.println("draw test");
        
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        DrawingWall instance = new DrawingWall(board);
        instance.draw();
        
        String expectedOutput  = "# ";
        
        assertEquals(expectedOutput, outContent.toString());
    }
    
}
