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
    public Object()
    {
        //todo
    }

    //**********************methoden****************************************
    int getInterfaceID()
    {
        //todo
        return 0;
    }
    
    int getPositionX()
    {
        //todo
        return 0;
    }
    
    int getPositionY()
    {
        //todo
        return 0;
    }
    
    boolean getActive()
    {
        //todo
        return false;
    }
    
    void setPistionX(int positionX)
    {
        //todo
    }
    
    void setPositionY(int positionY)
    {
        //todo
    }
    
    void setActive (boolean active)
    {
        //todo
    }
    
    void move(String direction)
    {
        //todo
    }
    
    boolean checkCollision(Object object)
    {
        //todo
        return false;
    }
}
