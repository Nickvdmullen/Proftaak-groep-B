/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

/**
 * OK
 * @author Melanie
 */
public class Obstacle extends Object
{
    //************************datavelden*************************************
    private int obstacleID = 1;
    
    private boolean active;
    private boolean movable;
    
    private final String type;
    private boolean broken;
    
    //***********************constructoren***********************************
    /**
     * creates an obstacle with ...
     * @param type
     * @param broken
     */
    public Obstacle(String type, boolean broken, int posX, int posY, boolean active, boolean movable)
    {
        super(posX, posY, active, movable);
        
        this.type = type;
        this.broken = broken;
        
        this.obstacleID++;
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
        return obstacleID;
    }

    @Override
    public int getPositionX() {
        return this.getPositionX();
    }

    @Override
    public int getPositionY() {
        return this.getPositionY();
    }

    @Override
    public boolean getActive() {
        return this.getActive();
    }

    @Override
    public void setPositionX(int positionX) {
        setPositionX(positionX);
    }

    @Override
    public void setPositionY(int positionY) {
        setPositionY(positionY);
    }

    @Override
    public void setActive(boolean active) {
        setActive(active);
    }

    @Override
    public void move(String direction) {
        //doesn't need to be implemented
    }

    @Override
    public boolean checkCollision(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
