/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;

/**
 *
 * @author Willem
 */  
@RunWith(Suite.class)
@Suite.SuiteClasses({
    BallistaTest.class,
    CharacterTest.class,
    GameLevelTest.class,
    ObstacleTest.class,
    PowerUpTest.class,
    ProjectileTest.class,
    UserTest.class})
public class FullTestSuite {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(FullTestSuite.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
        }
        if (result.wasSuccessful()) {
            System.out.println("all tests were succesful");
        } else {
            System.out.println("test suite was not succesful");
        }
    }
}
