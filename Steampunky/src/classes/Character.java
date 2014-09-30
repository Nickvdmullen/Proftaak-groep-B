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
public class Character
{
    //************************datavelden*************************************
    private int characterID;
    private int score;
    private double speed;
    private boolean dead;
    private int maxBallistae;
    private int torchLight;
    private String direction;
    private Ballista ballista;

    //***********************constructoren***********************************
    /**
     * creates a character with ...
     */
    public Character()
    {
        //todo
    }

    //**********************methoden****************************************
    public int getCharacterID()
    {
        return this.getCharacterID();
    }
    
    public double getSpeed()
    {
        return this.speed;
    }
    
    public boolean getDead()
    {
        return this.dead;
    }
    
    public int getScore()
    {
        return this.score;
    }
    
    public int getTorchRange()
    {
        return this.torchLight;
    }
    
    public String getDirection()
    {
        return this.direction;
    }
    
    public void setScore(int score)
    {
        this.score = score;
    }
    
    public void setSpeed(double speed)
    {
        this.speed = speed;
    }
    
    public void setDead(boolean dead)
    {
        this.dead = dead;
    }
    
    public void setTorch(int range)
    {
        this.torchLight = range;
    }
    
    public void setDirection(String direction)
    {
        this.direction = direction;
    }
    
    public void createBllista(String direction, int shots, double projectileSpeed)
    {
        //todo
    }
}
