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
    private int positionX; //moet deze?
    private int positionY; //moet deze?
    private boolean active;
    private boolean movable;
    
    //***********************constructoren***********************************
    /**
     * creates an abstract class object with ...
     */
    public Object()
    {
        //todo (vraag)
    }

    //**********************methoden****************************************
    abstract int getInterfaceID();
    
    abstract int getPositionX();
    
    abstract int getPositionY();
    
    abstract boolean getActive();
    
    abstract void setPositionX(int positionX);
    
    abstract void setPositionY(int positionY);
    
    abstract void setActive (boolean active);
    
    abstract void move(String direction);
    
    abstract boolean checkCollision(Object object);
}
