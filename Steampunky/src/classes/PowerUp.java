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
    private boolean available;

    //***********************constructoren***********************************
    /**
     * creates a powerup with ...
     */
    public PowerUp()
    {
        //todo
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
