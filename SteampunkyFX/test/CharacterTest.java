/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import classes.Character;
import classes.Direction;
import classes.Game;
import classes.Position;
import javafx.scene.paint.Color;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Linda
 */
public class CharacterTest {
    Character test;
    public CharacterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Position position = new Position(1,1);
        Game game = new Game(9,9,4.00, 1, 3);
        test = new Character("Character",5.0,  false, 1, 1, position, true, true, Direction.Down, Color.RED, game);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void TestGetters() 
    {
    assertEquals("score niet gelijk", test.getScore(), 0);
    assertEquals("speed niet gelijk", (int)test.getSpeed(), (int)5.0);
    assertEquals("boolean dead niet gelijk", test.getDead(), false);
    assertEquals("torch niet gelijk", test.getTorchRange(), 1);
    assertEquals("direction niet gelijk", test.getDirection(), Direction.Down);
    }
    
    @Test
    public void  TestSetters()
    {
        test.setActive(false);
        assertEquals("setter active werkt niet goed", test.getActive(), false);
        
        test.setDead(true);
        assertEquals("setter dead werkt niet goed", test.getDead(), true);
        
        test.setDirection(Direction.Right);
        assertEquals("setter direction werkt niet goed", test.getDirection(), Direction.Right);
        
        test.setScore(10);
        assertEquals("setter score werkt niet goed", test.getScore(), 10);
        
        test.setSpeed(9.0);
        assertEquals("setter speed werkt niet goed", (int)test.getSpeed(), (int)9.0);
        
        test.setTorch(10);
        assertEquals("setter torch werkt niet goed", test.getTorchRange(), 10);
    }
    
    @Test  (expected = IllegalArgumentException.class)
    public void TestFoutiveInvoer()
    {
        Position position = new Position(1,1);
        Game game = new Game(9,9,4.00, 1, 3);
        Character nieuw = new Character("Character",5.0,  true, 1, 1, position, true, true, Direction.Down, Color.RED, game);
    }
}
