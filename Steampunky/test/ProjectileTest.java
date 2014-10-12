/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import classes.Direction;
import classes.Projectile;
import java.util.ArrayList;
import java.util.List;
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
public class ProjectileTest {
   private List<Object> myObjects;
   private Projectile firstProjectile;
   private Projectile secondProjectile;
   private Projectile thirdProjectile;
   
    @Before
    public void setUp() {
        firstProjectile = new Projectile("normal",1,19,19,true,true,Direction.Left);
        secondProjectile = new Projectile("normal",1,19,19,true,true,Direction.Left);
        thirdProjectile = new Projectile(null,1,19,19,true,true,Direction.Left);
        myObjects = new ArrayList();
        myObjects.add(firstProjectile);
        myObjects.add(secondProjectile);
    }
    
    
    @Test
    public void testProjectile()
    {
        assertEquals("invalid Values",1, (int)firstProjectile.getSpeed());
        assertEquals("autocount not working",1,firstProjectile.getID());
        assertEquals("autocount not working",2,secondProjectile.getID());
        assertNull("cant have null as type",thirdProjectile.getType());
    }
    
    @Test
    public void testGetters()
    {
        assertEquals("invalid Values",1, (int)firstProjectile.getSpeed());
        assertEquals("autocount not working",1,firstProjectile.getID());
        assertEquals("invalid values","normal",firstProjectile.getType());
    }
    
    @Test
    public void TestCollision()
    {
    
    }
    
}
