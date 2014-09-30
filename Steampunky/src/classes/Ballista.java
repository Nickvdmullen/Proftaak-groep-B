/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

import java.util.*;

/**
 * OK
 * @author Melanie
 */
public class Ballista extends Object
{    
    //************************datavelden*************************************
    private int ballistaID;
    private int nextBallistaID = 1;
    private String direction;
    private int shots;
    private int projectileSpeed;
    private Projectile projectile;

    //***********************constructoren***********************************
    /**
     * creates a ballista with ...
     */
    public Ballista(String direction, int shots, int projectileSpeed)
    {
        this.ballistaID = this.nextBallistaID;
        this.nextBallistaID++;
        this.direction = direction;
        this.shots = shots;
        this.projectileSpeed = projectileSpeed;
    }

    //**********************methoden****************************************
    public int getBallistaID()
    {
        return this.ballistaID;
    }
    
    public void createProjectile()
    {
        //todo
    }
}
