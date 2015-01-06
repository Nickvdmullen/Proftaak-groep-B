/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import classes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Melanie
 */
public class GameLevelTest
{    
    Game game1;
    Game game2;
    
    @Before
    public void setUp()
    {
        game1 = new Game(9, 9, 300, 1, 2);
    } 
    
    @Test
    public void testAddGame()
    {
        //Test if constructor works properly
        game2 = new Game(19, 19, 120, 1, 1);
        assertEquals("aantal rondes niet gelijk aan 120", game2.getTotalRounds(), 120);
        assertEquals("botdifficulty niet gelijk aan 1", game2.getBotDifficulty(), 1);
        assertEquals("totaal aantal rondes niet gelijk aan 2", game2.getTotalRounds(), 2);
    }
    
    @Test
    public void testSetDifficulty()
    {
        //Test if setter works
        game1.setBotDifficulty(2);
        assertEquals("botdifficulty niet gelijk aan 2", game1.getBotDifficulty(), 2);
    }
}
