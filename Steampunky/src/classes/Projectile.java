/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

import java.util.*;

/**
 * OK
 * @author Nick van der Mullen
 */
public class Projectile extends Object
{
    //************************datavelden*************************************
    private int projectileID;
    private int nextProjectileID = 1;
    private String type;
    private double speed;
    private Direction direction;

    /**
     * The constructor for making a Object of the Type Projectile
     * @param type          the type of the projectile f.ex slow/fast
     * @param speed         the speed of the projectile.
     * @param positionX     Attribute of Object (the X position of the projectile)
     * @param positionY     Attribute of Object (the Y position of the projectile)
     * @param active        Attribute of Object (a boolean to check if the projectile is on screen)
     * @param movable       Attribute of Object (a boolean to check if the object can move)
     * @param direction     Attribute of Object (the direction of the projectile)
     */
    public Projectile(String type,double speed,int positionX,int positionY,boolean active,boolean movable,Direction direction)
    {
        super(positionX,positionY,active,movable,direction);
        
        this.projectileID = nextProjectileID;
        this.type = type;
        this.speed = speed;
        this.direction = direction;
        this.nextProjectileID++;
    }

    //**********************methoden****************************************
    
    /**
     * Getter for Type
     * @return  Returns a string with the type of the projectile
     */
    public String getType()
    {
        return this.type;
    }
    
    /**
     * Getter for Speed
     * @return  Returns a double with the speed of the projectile
     */
    public double getSpeed()
    {
        return this.speed;
    }
    
    /**
     * Getter for Direction
     * @return  Returns a Direction with the direction the projectile is moving
     */
    public Direction getDirection()
    {
        return this.direction;
    }
    
    public int getID()
    {
        return this.projectileID;
    }
    
    /**
     * An method to check if the next Position of this projectile will collide with another object.
     * @param objects   An list of all object currently in the game.
     * @return          Returns an object if the next position of this projectile collides with the object
     *                  else it returns null.
     */
    public Object checkCollision(List<Object> objects)
    {
        int tempPositionX = this.getPositionX();
        int tempPositionY = this.getPositionY();
        Object hitObject = null;
        
        if(direction == direction.Right)
        {
            tempPositionX++;
        }
        else if(direction == direction.Left)
        {
            tempPositionX--;
        }
        else if(direction == direction.Up)
        {
            tempPositionY++;
        }
        else
        {
            tempPositionY--;
        }
        
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
