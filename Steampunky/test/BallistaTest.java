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
 * @author Varrayt
 */
public class BallistaTest {
    
    private Ballista firstBallista;
    private Ballista secondBallista;
    
    @Before
    public void setUp() {
        
    firstBallista = new Ballista("normal",4,1,10,10,true,false,Direction.Left);
    secondBallista = new Ballista(null,7,2,10,10,true,false,Direction.Right);
    }
    
    @Test
    public void testBallista()
    {
        assertEquals("invalid input",firstBallista.getShots(),4);
        assertNull("cant have an null as type",secondBallista.getType());
    }
    
    @Test
    public void testGetters()
    {
        assertEquals("invalid value",firstBallista.getBallistaID(),1);
        assertEquals("ïnvalid value",firstBallista.getShots(),4);
        assertEquals("invalid value",firstBallista.getType(),"normal");
    }

    
}
