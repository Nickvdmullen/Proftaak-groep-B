/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import java.util.List;

/**
 <p>
 @author Melanie
 */
public abstract class Object
{
    //************************datavelden*************************************

    private int interfaceID = 0;
    private Position position;
    private boolean active;
    private boolean movable;
    private Direction direction;

    //***********************constructoren***********************************
    /**
     Constructor of the SuperClass Object
     creates an abstract class object with ...
     <p>
     @param position  An object of the Class Position which holds a coordinate.
     @param Active    A Boolean which holds the current state of this Object.
     @param Movable   A boolean which holds the current state of this Object
     @param direction A Object of the Class Direction which holds the direction in which this Object is moving.
     */
    public Object(Position position , boolean Active , boolean Movable , Direction direction)
    {
        this.position = position;
        this.active = Active;
        this.movable = Movable;

        this.direction = direction;

        if (!movable)
        {
            this.direction = null;
        }

        this.interfaceID++;
    }

    //**********************methoden****************************************
    /**
     The Getter of this Objects InterfaceID.
     <p>
     @return An int which is this objects InterfaceID.
     */
    public int getInterfaceID()
    {
        return this.interfaceID;
    }

    /**
     The Getter of this Objects PositionX.
     <p>
     @return An int with the current X position of this Object
     */
    public int getPositionX()
    {
        return this.position.getX();
    }

    /**
     The Getter of this Objects PositionY.
     <p>
     @return An int with the current Y position of this Object
     */
    public int getPositionY()
    {
        return this.position.getY();
    }

    /**
     The Getter of this Objects Position.
     <p>
     @return An Object of the Class Position which holds this Objects Position.
     */
    public Position getPosition()
    {
        return this.position;
    }

    /**
     The Getter of this objects Active.
     <p>
     @return A boolean which holds the current state of this Object.
     */
    public boolean getActive()
    {
        return active;
    }

    /**
     The Setter of this Objects Position.
     <p>
     @param position A Object of the Class Position which holds the new position of this Object.
     */
    public void setPosition(Position position)
    {
        this.position = position;
    }

    /**
     The Setter of this Objects Active
     <p>
     @param active A boolean which holds the new state of this Object.
     */
    public void setActive(Boolean active)
    {
        this.active = active;
    }

    /**
     A Method for moving this Object
     <p>
     @param direction A Object of the Class Direction which holds the direction in which direction this Object is moving.
     */
    public void move(Direction direction)
    {
        if (movable)
        {

            Position newPosition;
            if (direction == direction.Right)
            {
                newPosition = new Position((this.position.getX() + 1) , this.position.getY());
                this.position = newPosition;
            } else if (direction == direction.Left)
            {
                newPosition = new Position((this.position.getX() - 1) , this.position.getY());
                this.position = newPosition;
            } else if (direction == direction.Up)
            {
                newPosition = new Position(this.position.getX() , (this.position.getY() + 1));
                this.position = newPosition;
            } else
            {
                newPosition = new Position(this.position.getX() , (this.position.getY() - 1));
                this.position = newPosition;
            }
        } else
        {
            System.out.println("Kan unmovable object niet bewegen");
        }
    }

    /**
     An method to check if the next Position of this projectile will collide with another object.
     <p>
     @param objects An list of all object currently in the game.
     <p>
     @return Returns an object if the next position of this projectile collides with the object
     else it returns null.
     */
    public Object checkCollision(List<Object> objects)
    {
        int tempPositionX = this.getPositionX();
        int tempPositionY = this.getPositionY();
        Object hitObject = null;

        if (direction == direction.Right)
        {
            tempPositionX++;
        } else if (direction == direction.Left)
        {
            tempPositionX--;
        } else if (direction == direction.Up)
        {
            tempPositionY++;
        } else
        {
            tempPositionY--;
        }

        for (Object nxtObject : objects)
        {
            int oPositionX = nxtObject.getPositionX();
            int oPositionY = nxtObject.getPositionY();

            if ((tempPositionX == oPositionX) && (tempPositionY == oPositionY))
            {
                hitObject = nxtObject;
                break;
            }

        }
        return hitObject;
    }

}
