/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

import java.util.*;

/**
 * OK
 * @author Melanie
 */
public class Obstacle extends Object
{
    //************************datavelden*************************************
    private int obstacleID;
    private String type;
    private boolean broken;

    //***********************constructoren***********************************
    /**
     * creates an obstacle with ...
     */
    public Obstacle(String type)
    {
        this.type = type;
    }

    //**********************methoden****************************************
    public String getType()
    {
        return this.type;
    }
    
    public boolean getBroken()
    {
        return this.broken;
    }
    
    public void setBroken(boolean broken)
    {
        this.broken = broken;
    }
}
