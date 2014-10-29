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
    Level level1;
    Level level2;
    Game game1;
    Game game2;
    
    @Before
    public void setUp()
    {
        level1 = new Level(1100, 1100, "C://level1.jpg", "Level 1");
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
    public void testAddLevel()
    {
        //Test if constructor works properly
        level2 = new Level(700, 1300, "C://level2.png", "Industy");
        assertEquals("hoogte niet gelijk aan 700", level2.getHeight(), 700);
        assertEquals("breedte niet gelijk aan 1300", level2.getWidth(), 1300);
        assertEquals("texture niet gelijk aan 'C://level2.png'", level2.getTexture(), "C://level2.png");
        assertEquals("naam niet gelijk aan 'Industry'", level2.getName(), "Industry");
        assertEquals("levelid niet gelijk aan 2", level2.getLevelID(), 2);
        
        //Test if level is added to Game
        game2.addLevel(level2);
        assertTrue("level niet toegevoegd aan game", game2.getLevels().contains(level2));
    }
    
    @Test
    public void testSetDifficulty()
    {
        //Test if setter works
        game1.setBotDifficulty(2);
        assertEquals("botdifficulty niet gelijk aan 2", game1.getBotDifficulty(), 2);
    }
}
