/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

import java.util.ArrayList;

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
    private Direction direction;
    
    //***********************constructoren***********************************
    /**
     * creates an abstract class object with ...
     * @param X
     * @param Y
     * @param Active
     * @param Movable
     */

    public Object(int X, int Y, boolean Active, boolean Movable, Direction direction) 
    {
        //todo (vraag)
        this.positionX = X;
        this.positionY = Y;
        this.active = Active;
        this.movable = Movable;
        
        this.direction = direction;
        
        if (!movable) {
            this.direction = null;
        }
        
        interfaceID++;
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
    
    public void setPositionX(int PositionX) {
        this.positionX = PositionX;
    }
    
    public void setPositionY(int PositionY) {
        this.positionY = PositionY;
    }
    
    public void setActive(Boolean active) {
        this.active = active;
    }
    
    public void move(Direction direction) {
        if (movable) {
            if(direction == direction.Right)
            {
                positionX++;
            }
            else if(direction == direction.Left)
            {
                positionX--;
            }
            else if(direction == direction.Up)
            {
                positionY++;
            }
            else
            {
                positionY--;
            }
        }
        else {
            System.out.println("Kan unmovable object niet bewegen");
        }
    }
    
    public Object checkCollision(ArrayList<Object> objects) {
        int tempPositionX = this.getPositionX();
        int tempPositionY = this.getPositionY();
        Object hitObject = null;
                
        for(Object nxtObject : objects)
        {
            int oPositionX = nxtObject.getPositionX();
            int oPositionY = nxtObject.getPositionY();
            
            if((tempPositionX == oPositionX) && (tempPositionY == oPositionY))
            {
                hitObject = nxtObject;
                break;
            }
            
        }
        return hitObject;
    }
}
