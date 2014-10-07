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

    private int interfaceID = 1;
    private int positionX;
    private int positionY;
    private boolean active;
    private boolean movable;
    
    //***********************constructoren***********************************
    /**
     * creates an abstract class object with ...
     */

    public Object(int X, int Y, boolean Active, boolean Movable) 
    {
        //todo (vraag)
        this.positionX = X;
        this.positionY = Y;
        this.active = Active;
        this.movable = Movable;
        interfaceID++;
    }

    //**********************methoden****************************************
    
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
}
