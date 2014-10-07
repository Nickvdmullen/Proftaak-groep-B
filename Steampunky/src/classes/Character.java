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
    private Direction direction;
    private Ballista ballista;
    

    //***********************constructoren***********************************
    /**
     * creates a character with ...
     */

    public Character(int characterID, int score, double speed, boolean dead, int maxBalista, int torch,
             int positionX,int positionY,boolean active,boolean movable,Direction direction)
    {
        super(0, positionX, positionY, active, movable);
        this.characterID = characterID;
        this.score = score;
        this.speed = speed;
        this.dead = dead;
        this.maxBallistae = maxBalista;
        this.torchLight = torch;
        this.direction = direction;
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
    
    public Direction getDirection()
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
    
    public void setDirection(Direction direction)
    {
        this.direction = direction;
    }

    public void createBllista(Direction direction, int shots, double projectileSpeed)
    {
        //todo
        int positionx = this.getPositionX();
        int positiony = this.getPositionY();
        boolean active = this.getActive();
        
        
        this.ballista = new Ballista("", shots,  projectileSpeed, positionx, positiony,active,false,direction);
    }

    @Override
    void setPositionX(int positionX) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void setPositionY(int positionY) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void setActive(boolean active) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void move(String direction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    boolean checkCollision(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
