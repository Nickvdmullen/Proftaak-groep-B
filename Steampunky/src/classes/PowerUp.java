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
     * creates a powerup with ...
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
    public String getName()
    {
        return this.name;
    }
    
    public String getType()
    {
        return this.type;
    }
    
    public String getDescription()
    {
        return this.description;
    }
    
    public boolean getAvailable()
    {
        return this.available;
    }
    
    public void setAvailable(boolean available)
    {
        this.available = available;
    }
}
