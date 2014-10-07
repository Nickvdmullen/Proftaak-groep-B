/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

import java.util.*;

 /**
 * OK
 * @author Linda
 */
public class Character extends Object
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

    public Character(int characterID, int score, double speed, boolean dead, int maxBalista, int torch,
            String directions, int positionX,int positionY,boolean active,boolean movable,Direction direction)
    {
        super(positionX,positionY,movable,direction,active);
        this.characterID = characterID;
        this.score = score;
        this.speed = speed;
        this.dead = dead;
        this.maxBallistae = maxBalista;
        this.torchLight = torch;
        this.direction = directions;
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
        //this.ballista = new Ballista(0, direction, shots, projectileSpeed);
    }
}
