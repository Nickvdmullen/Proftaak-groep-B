/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import classes.Direction;
import classes.Game;
import classes.Position;
import classes.PowerUp;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Varrayt
 */
public class PowerUpTest {
    
    private PowerUp Powerup;
    private PowerUp Powerup2;
    
    @Before
    public void setUp() {
        Position position = new Position(1,1);
        Game game = new Game(9,9,4.00, 1, 3);
        this.Powerup = new PowerUp("Fast","runspeed","run faster",true,position,true,false,Direction.Left, game);
        this.Powerup2 = new PowerUp(null,null,null,true,position,true,false,Direction.Left, game);
    }
    
    @Test
    public void testPowerUp()
    {
        assertEquals("Name cant be null","Fast",Powerup.getName());
        assertNull("Name cant be null",Powerup2.getName());
    }
    
    @Test
    public void testGetters()
    {
        assertEquals("Name cant be null","Fast",Powerup.getName());
        assertEquals("Type cant be null","runspeed",Powerup.getType());
        assertEquals("Description cant be null","run faster",Powerup.getDescription());
        assertNull("Name cant be null",Powerup2.getName());
        assertNull("Type cant be null",Powerup2.getType());
        assertNull("Description cant be null",Powerup2.getDescription());
    }
}
