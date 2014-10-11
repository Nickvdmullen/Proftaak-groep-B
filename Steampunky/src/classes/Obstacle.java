/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

import java.util.ArrayList;

/**
 * OK
 * @author Melanie
 */
public class Obstacle extends Object
{
    //************************datavelden*************************************
    private int interfaceID;
    private int obstacleID = 1;
    
    private boolean active;
    private boolean movable;
       
    private final String type;
    private boolean broken;
    
    ArrayList<Integer> obstacleIDs = new ArrayList<>();
    
    //***********************constructoren***********************************
    /**
     * creates an obstacle with ...
     * @param interfaceID
     * @param type
     * @param broken
     * @param active
     * @param movable
     */
    public Obstacle(String type, boolean broken, int posX, int posY, boolean active, boolean movable)
    {
        super(posX, posY, active, movable, null);
        
        interfaceID = super.getInterfaceID();
        if (interfaceID == 0) {
            throw new IllegalArgumentException("interfaceID en obstacleID mogen niet 0 zijn");
        }
        
        if (obstacleIDs.contains(obstacleID)) {
            throw new IllegalArgumentException("het obstacleID bestaat al");
        }
        
        this.type = type;
        this.broken = broken;
        
        this.obstacleID = interfaceID;
        obstacleIDs.add(obstacleID);
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

    @Override
    public int getInterfaceID() {
        return super.getInterfaceID();
    }

    @Override
    public int getPositionX() {
        return super.getPositionX();
    }

    @Override
    public int getPositionY() {
        return super.getPositionY();
    }

    @Override
    public boolean getActive() {
        return this.active;
    }
    
    @Override
    public void setPositionX(int PositionX) {
        super.setPositionX(PositionX);
    }
    
    @Override
    public void setPositionY(int PositionY) {
        super.setPositionY(PositionY);
    }
    
    @Override
    public void setActive(Boolean active) {
        this.active = active;
    }
}
