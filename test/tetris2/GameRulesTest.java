/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PR
 */
public class GameRulesTest {
    
    private final GameBoard board;
    private final TetrisShape shape;
    private final Score score;
    
    public GameRulesTest() {
        board = new GameBoard();
        shape = new TetrisShape();
        score = new Score();
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

    @Test
    public void testIsGameOver() {
        System.out.println("test isGameOver");
        GameRules instance = new GameRules(board, shape, score);
        boolean expResult = true;
        
        board.setBoardValue(4, 1, 3);
        board.setBoardValue(5, 1, 3); 
        board.setBoardValue(6, 1, 3); 
        
        boolean result = instance.isGameOver();
        
        assertEquals(expResult, result);
    }
    
}
