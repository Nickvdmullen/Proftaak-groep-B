/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import classes.User;
import classes.Direction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Linda
 */
public class UserTest {
    User test;
    public UserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        test = new User(1, "lotje", "lotje", 10, 0, 9);
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
        assertEquals("userid niet coorect", test.getUserID(), 1);
        assertEquals("username niet coorect", test.getUsername(), "lotje");
        assertEquals("rating niet coorect", test.getRating(), 10);
        String testen = "gefaald";
        int[] nieuw = new int []{0,9};
        int[] oud = test.getWinLoss();
        if(nieuw[0] == oud[0])
        {
            if(nieuw[1] == oud[1])
            {
                testen = "geslaagd";
            }
        }
        assertEquals("winlosses niet correct", testen, "geslaagd");
    }
    @Test
    public void TestPassword()
    {
        assertTrue("wachtwoord is juist", test.checkPassword("lotje"));
    }
}
