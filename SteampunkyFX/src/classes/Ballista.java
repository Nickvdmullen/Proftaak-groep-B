/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;


import java.util.Timer;
import java.util.TimerTask;

/**
 OK
 <p>
 @author Nick van der Mullen
 */
public class Ballista extends Object
{
    //************************datavelden*************************************
    private int ballistaID;
    private Direction direction;
    private String ballistaType;
    private int shots;
    private int shotsShot;
    private double projectileSpeed;

    /**
     The constructor of the Object Ballista,
     when this object is made a number of Projectiles is made to match shots.
     Depending on the direction give it depends which direction is made first.
     <p>
     * @param objecttype
     @param type            The type thats give so the ballista knows what type of Projectiles is must make.
     @param shots           The number of shots a ballista can fire, must be a multitude of 4.
     @param projectileSpeed The speed of the Projectiles the ballista makes.
     @param position        An attribute of Object that holds the Position of this Ballista.
     @param active          An attribute of Object that sets if an Object is active or not.
     @param direction       An attribute of Object that is used to decide which way to shoot first.
     *
     */
    public Ballista(String objecttype,String type , int shots , double projectileSpeed , Position position , boolean active, Direction direction,Game game)
    {
        super(objecttype,position , active, false , direction, game);

        if (shots % 4 != 0)
        {
            throw new IllegalArgumentException("A ballista must have a multitude of 4 as # of shots.");
        }        
 
        super.setImageString("ballista.png");
        
        //Check if values entered are correct.
        if (type != null)
        {
            //Check if type isn't empty
            if (!type.isEmpty())
            {

                this.ballistaID = super.getInterfaceID();
                this.ballistaType = type;
                this.direction = direction;
                this.shots = shots;
                this.shotsShot = 0;
                this.projectileSpeed = projectileSpeed;
                
                Timer ProjectileTimer = new Timer();
                ProjectileTimer.schedule(new TimerTask(){
                    @Override
                    public void run() {
                        shootProjectile();
                    }
                }, 2000
                );
                        
                
                //While # of shots fired is less then maxNumber of shots, continues through loop
                //Then uses the Direction given to determine what sides should fire first.
                
            }
        }
    }
    private void shootProjectile(){
        while (shotsShot < shots)
                {
                    if (direction == Direction.Up || this.direction == Direction.Down)
                    {
                        createProjectile(Direction.Up);
                        createProjectile(Direction.Down);
                        createProjectile(Direction.Left);
                        createProjectile(Direction.Right);
                        shotsShot += 4;
                    } else
                    {
                        createProjectile(Direction.Left);
                        createProjectile(Direction.Right);
                        createProjectile(Direction.Up);
                        createProjectile(Direction.Down);
                        shotsShot += 4;
                    }
                }
    }
    //**********************methoden****************************************
    /**
     The getter of the Ballista ID.
     <p>
     @return Returns an integer that represents the Ballista ID.
     */
    public int getBallistaID()
    {
        return this.ballistaID;
    }

    public String getType()
    {
        return this.ballistaType;
    }

    /**
     The getter of shots.
     <p>
     @return Returns an integer with the amount of shots the Ballista can fire.
     */
    public int getShots()
    {
        return this.shots;
    }

    /**
     An Method that creates a projectile with the given direction.
     <p>
     @param direction The direction the projectile will go.
     */
    private void createProjectile(Direction direction)
    {
        Projectile newProjectile = new Projectile("Projectile",this.ballistaType , this.projectileSpeed , super.getPosition() , false , true , direction,super.getGame());
        super.getPosition().addObject(newProjectile);
    }
}
