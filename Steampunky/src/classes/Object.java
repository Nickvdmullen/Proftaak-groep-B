/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

/**
 *
 * @author Melanie
 */
public abstract class Object
{
    //************************datavelden*************************************
    private int interfaceID;
    private int positionX; 
    private int positionY; 
    private boolean active;
    private boolean movable;
    
    //***********************constructoren***********************************
    /**
     * creates an abstract class object with ...
     */
    public Object(int interfaceId, int positionX, int positionY, boolean active, boolean movable)
    {
        //todo (vraag)
        this.interfaceID = interfaceId;
        this.positionX = positionX;
        this.positionY = positionY;
        this.active = active;
        this.movable = movable;
    }

    //**********************methoden****************************************
    public int getInterfaceID()
    {
        return this.interfaceID;
    }
    
    public int getPositionX()
    {
        return this.positionX;
    }
    
    public int getPositionY()
    {
        return this.positionY;
    }
    
    public boolean getActive()
    {
        return active;
    }
    
    abstract void setPositionX(int positionX);
    
    abstract void setPositionY(int positionY);
    
    abstract void setActive (boolean active);
    
    abstract void move(String direction);
    
    abstract boolean checkCollision(Object object);
}
