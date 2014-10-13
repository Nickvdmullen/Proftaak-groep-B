/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

import java.util.*;

/**
 *
 * @author Melanie
 */
public class PowerUp extends Object
{
    //************************datavelden*************************************
    private int powerUpID;
    private String name;
    private String type;
    private String description;
    private String imgURL;
    private boolean available;

    //***********************constructoren***********************************
    /**
     * Constructor of PowerUp
     * @param name          Name of this powerup
     * @param type          Type of this powerup
     * @param description   Description of this powerup
     * @param available     If this Powerup is available for the player
     * @param positionX     An attribute of the superclass
     * @param positionY     An attribute of the superclass
     * @param active        An attribute of the superclass
     * @param movable       An attribute of the superclass
     * @param direction     An attribute of the superclass
     */
    public PowerUp(String name,String type,String description,boolean available,int positionX,int positionY,boolean active,boolean movable,Direction direction)
    {
        super(positionX,positionY,active,movable,direction);
        
        if((name != null) || (type != null) || (description != null))
        {
            if(!name.isEmpty() && !type.isEmpty() && !description.isEmpty())
            {
            this.name = name;
            this.type = type;
            this.description = description;

            switch (type)
                {
                    case "runspeed"     : this.imgURL = "powerup01";
                                          break;
                    case "torch"        : this.imgURL = "powerup02";
                                          break;
                    case "shield"       : this.imgURL = "powerup03";
                                          break;
                    case "projectile"   : this.imgURL = "powerup03";
                                          break;
                }
            }
        }
    }

    //**********************methoden****************************************
    
    /**
     * Getter of Name
     * @return a name as String
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * Getter of Type
     * @return a type as String 
     */
    public String getType()
    {
        return this.type;
    }
    
    /**
     * Getter of Description
     * @return a description as String
     */
    public String getDescription()
    {
        return this.description;
    }
    
    /**
     * Getter of Availablity
     * @return a boolean whether its available or not
     */
    public boolean getAvailable()
    {
        return this.available;
    }
    
    /**
     * Setter of Available
     * @param available 
     */
    public void setAvailable(boolean available)
    {
        this.available = available;
    }
}
