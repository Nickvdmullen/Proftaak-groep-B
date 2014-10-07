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
public class Ballista extends Object
{    
    //************************datavelden*************************************
    private int ballistaID;
    private int nextBallistaID = 1;
    private Direction direction;
    private String ballistaType;
    private int shots;
    private int shotsShot;
    private int projectileSpeed;
    /////

    /**
     * The constructor of the Object Ballista, 
     * when this object is made a number of Projectiles is made to match shots.
     * Depending on the direction give it depends which direction is made first.
     * 
     * @param type              The type thats give so the ballista knows what type of Projectiles is must make.
     * @param shots             The number of shots a ballista can fire.
     * @param projectileSpeed   The speed of the Projectiles the ballista makes.
     * @param positionX         An attribute of Object that sets the  X position that the Ballista will be placed on.
     * @param positionY         An attribute of Object that sets the  Y position that the Ballista will be placed on.
     * @param active            An attribute of Object that sets if an Object is active or not.
     * @param movable           An attribute of Object that sets if an Object is movable or not.
     * @param direction         An attribute of Object that is used to decide which way to shoot first.
    **/
    public Ballista(String type, int shots, int projectileSpeed,int positionX,int positionY,boolean active,boolean movable,Direction direction)
    {
        super(positionX,positionY,movable,direction,active);
        this.ballistaID = this.nextBallistaID;
        this.nextBallistaID++;
        this.ballistaType = type;
        this.direction = direction;
        this.shots = shots;
        this.shotsShot = 0;
        this.projectileSpeed = projectileSpeed;
        
        while(shotsShot < shots)
        {
            if(direction == Direction.Up || this.direction == Direction.Down)
            {
                createProjectile(Direction.Up);
                createProjectile(Direction.Down);
                createProjectile(Direction.Left);
                createProjectile(Direction.Right);
            }
            else
            {
                createProjectile(Direction.Left);
                createProjectile(Direction.Right); 
                createProjectile(Direction.Up);
                createProjectile(Direction.Down);
            }

        }
        
    }

    //**********************methoden****************************************
    
    /**
     * The getter of the Ballista ID.
     * @return  Returns an integer that represents the Ballista ID.
     */
    public int getBallistaID()
    {
        return this.ballistaID;
    }
    
    /**
     * The getter of shots.
     * @return  Returns an integer with the amount of shots the Ballista can fire.
     */
    public int getShots()
    {
        return this.shots;
    }
    
    /**
     * An Method that creates a projectile with the given direction.
     * @param direction     The direction the projectile will go.
     */
    public void createProjectile(Direction direction)
    {            
            Projectile newProjectile = new Projectile(this.ballistaType,this.projectileSpeed,this.getPositionX(),this.getPositionY(),false,false,direction);            
    }
    
   
}
