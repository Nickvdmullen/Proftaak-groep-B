/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import classes.Direction;
import classes.Game;
import classes.Position;
import classes.Projectile;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Varrayt
 */
public class ProjectileTest {
   private List<Object> myObjects;
   private Projectile firstProjectile;
   private Projectile secondProjectile;
   private Projectile thirdProjectile;
   
    @Before
    public void setUp() 
    {
        //Setup for testing, making objects,making lists, adding objects to the list
        //String type , double speed , Position position , boolean active , boolean movable , Direction direction , Game game)
        Position position = new Position(1,1);
        Game game = new Game(9,9,4.00, 1, 3);
        firstProjectile = new Projectile("normal",1,position,true,true,Direction.Left, game);
        secondProjectile = new Projectile("normal",1,position,true,true,Direction.Left, game);
        thirdProjectile = new Projectile(null,1,position,true,true,Direction.Left, game);
        myObjects = new ArrayList();
        myObjects.add(firstProjectile);
        myObjects.add(secondProjectile);
    }
    
    
    @Test
    //First test: check if constructor works.
    //Second test: setup for autoincrement test
    //Third test: check if autoincrement works
    //Fourth test: check if you can input null where it shouln't be possible
    public void testProjectile()
    {
        assertEquals("invalid Values",1, (int)firstProjectile.getSpeed());
        assertEquals("autocount not working",1,firstProjectile.getID());
        assertEquals("autocount not working",2,secondProjectile.getID());
        assertNull("cant have null as type",thirdProjectile.getType());
    }
    
    @Test
    //Test all 3 getters
    public void testGetters()
    {
        assertEquals("invalid Values",1, (int)firstProjectile.getSpeed());
        assertEquals("autocount not working",1,firstProjectile.getID());
        assertEquals("invalid values","normal",firstProjectile.getType());
    }
    
    @Test
    //Test if putting 2 objects at the same positionX and positionY throws an error
    public void TestCollision()
    {
    
    }
    
}
