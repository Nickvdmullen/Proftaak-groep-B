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
    public abstract int getInterfaceID();
    
    public abstract int getPositionX();
    
    public abstract int getPositionY();
    
    public abstract boolean getActive();
    
    public abstract void setPositionX(int positionX);
    
    public abstract void setPositionY(int positionY);
    
    public abstract void setActive (boolean active);
    
    public abstract void move(String direction);
    
    public abstract boolean checkCollision(Object object);
}
