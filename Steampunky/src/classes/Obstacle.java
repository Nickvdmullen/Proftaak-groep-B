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
    private final String type;
    private boolean broken;
    
    //***********************constructoren***********************************
    /**
     * creates an obstacle with ...
     * @param type
     * @param broken
     */
    public Obstacle(String type, boolean broken)
    {
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
    int getInterfaceID() {
        return obstacleID;
    }

    @Override
    int getPositionX() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    int getPositionY() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    boolean getActive() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
