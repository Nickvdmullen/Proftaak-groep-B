/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import classes.Direction;
import classes.Obstacle;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Willem
 */
public class ObstacleTest {
    
    Obstacle ob;
    
    public ObstacleTest() {
        //empty
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testConstructor() {
        //interfaceID nr, type, broken, posX, posY, active, movable
        ob = new Obstacle("Obstacle", false, 10, 11, true, false);
    }
    
    @Test
    public void testGetType() {
        assertEquals("Type komt niet overeen", "Obstacle", ob.getType());
    }
    
    @Test
    public void testGetBroken() {
        assertEquals("Deze moet niet broken zijn", false, ob.getBroken());
    }
    
    @Test
    public void testGetInterfaceID() {
        assertEquals("Zou 1 moeten zijn", 1, ob.getInterfaceID());
    }
    
    @Test
    public void testGetPositionX() {
        assertEquals("zou 10 moeten zijn", 10, ob.getPositionX());
    }
    
    @Test
    public void testGetPositionY() {
        assertEquals("zou 11 moeten zijn", 11, ob.getPositionY());
    }
    
    @Test
    public void testGetActive() {
        assertEquals("zou true moeten zijn", true, ob.getActive());
    }
    
    @Test
    public void testSetPostition() {
        ob.move(Direction.Right);
        
        assertEquals("zou 11 moeten zijn", 11, ob.getPositionX());
        assertEquals("zou 11 moeten zijn", 11, ob.getPositionY());
    }
    
    @Test
    public void testSetActive() {
        ob.setActive(false);
        
        assertEquals("zou false moeten zijn", false, ob.getActive());
    }
}
