/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 OK
 <p>
 @author Nick van der Mullen
 */
public class Projectile extends Object
{
    //************************datavelden*************************************
    private int projectileID;
    private String type;
    private double speed;
    private Direction direction;

    /**
     The constructor for making a Object of the Type Projectile
     <p>
     @param type      the type of the projectile f.ex slow/fast
     @param speed     the speed of the projectile.
     @param position  An Object of the Class Position which holds the position of this Projectile.
     @param active    A boolean to check if the projectile is on screen.
     @param movable   A boolean to check if the object can move.
     @param direction An Object of the Class Direction which holds the direction in which this projectile will move.
     */
    public Projectile(String objecttype,String type , double speed , Position position , boolean active , boolean movable , Direction direction , Game game)
    {
        super(objecttype,position , active , movable , direction,game);

        this.projectileID = super.getInterfaceID();
        this.type = type;
        this.speed = speed;
        this.direction = direction;
             
        super.setImageString("arrow.png");
    }

    //**********************methoden****************************************
    /**
     Getter for Type
     <p>
     @return Returns a string with the type of the projectile
     */
    public String getType()
    {
        return this.type;
    }

    /**
     Getter for Speed
     <p>
     @return Returns a double with the speed of the projectile
     */
    public double getSpeed()
    {
        return this.speed;
    }

    /**
     Getter for Direction
     <p>
     @return Returns a Direction with the direction the projectile is moving
     */
    public Direction getDirection()
    {
        return this.direction;
    }

    public int getID()
    {
        return this.projectileID;
    }
}
