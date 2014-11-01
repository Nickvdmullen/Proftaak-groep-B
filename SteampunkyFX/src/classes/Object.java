/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.shape.Shape;

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
    private Game myGame;
    private Shape shape;

    //***********************constructoren***********************************
    /**
     Constructor of the SuperClass Object
     creates an abstract class object with ...
     <p>
     @param position  An object of the Class Position which holds a coordinate.
     @param Active    A Boolean which holds the current state of this Object.
     @param Movable   A boolean which holds the current state of this Object
     @param direction A Object of the Class Direction which holds the direction in which this Object is moving.
     @param game      A Object of the Class Game in which this object is placed.
     */
    public Object(Position position , boolean Active , boolean Movable , Direction direction, Game game)
    {
        this.position = position;
        this.active = Active;
        this.movable = Movable;
        this.direction = direction;
        this.myGame = game;

        if (!movable)
        {
            this.direction = null;
        }

        this.interfaceID++;
        //position.addObject(this);
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
     @return An int with the current X p of this Object
     */
    public int getPositionX()
    {
        return this.position.getX();
    }

    /**
     The Getter of this Objects PositionY.
     <p>
     @return An int with the current Y p of this Object
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
    
    public Direction getDirection()
    {
        return this.direction;
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
     @param position A Object of the Class Position which holds the new p of this Object.
     */
    public void setPosition(Position position)
    {
        this.position = position;
        
        //check if shape is cirlce or rectangle
        this.shape.setLayoutX(position.getX()*100);
        this.shape.setLayoutY(position.getY()*100);
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
     * The Getter of Game
     * 
     * @return An instance of the game this object is located in.
     */
    public Game getGame()
    {
        return this.myGame;
    }
    
    /**
     * The Getter of the shape of the object
     * 
     * @return 
     */
    public Shape getShape()
    {
        return this.shape;
    }
    
    /**
     * The Setter of the shape of the object
     * @param shape of the object
     */
    public void setShape(Shape shape)
    {
        this.shape = shape;
    }
    
    /**
     A Method for moving this Object
     <p>
     @param direction A Object of the Class Direction which holds the direction in which direction this Object is moving.
     */
    public void move(Direction direction)
    {
        boolean canMove = true;
        List<Position> allPosition = myGame.getGrid();
        List<Object> allObjects = new ArrayList();
        Object checkObject;
        
        for(Position p : allPosition)
        {
            allObjects.addAll(p.getObjects());
        }
        
       
        Position newPosition = null;
        if (movable)
            {
                if (direction == Direction.Right)
                {
                    newPosition = myGame.getPosition(this.position.getX() +1,this.position.getY());
                    if(newPosition.getX() != 0 && newPosition.getY() != 0)
                    {
                        if(this instanceof Character)
                           {
                               checkObject = this.checkCollision(allObjects,newPosition.getX(),newPosition.getY());
                               if(checkObject != null)
                               {
                                   if(checkObject instanceof Projectile)
                                   {
                                       Character c = (Character)this;
                                       Projectile p = (Projectile)checkObject;
                                       c.setDead(true);
                                       canMove = false;
                                       p.setActive(false);
                                       Position positionP = p.getPosition();
                                       this.position.removeObject(this);
                                       positionP.removeObject(checkObject);
                                   }
                                   if(checkObject instanceof Obstacle)
                                   {
                                       canMove = false;
                                   }
                               }
                           }
                        else if(this instanceof Projectile)
                        {
                            checkObject = this.checkCollision(allObjects,newPosition.getX(),newPosition.getY());
                            if(checkObject != null)
                            {
                                if(checkObject instanceof Character)
                                {
                                       Character c = (Character)checkObject;
                                       c.setDead(true);
                                       canMove = false;
                                       Projectile p = (Projectile)this;
                                       p.setActive(false);
                                       Position positionC = c.getPosition();
                                       positionC.removeObject(checkObject);
                                       this.position.removeObject(this);
                                }
                                if(checkObject instanceof Obstacle)
                                {
                                    Obstacle o = (Obstacle)checkObject;
                                    o.setBroken(true);
                                    Projectile p = (Projectile)this;
                                    p.setActive(false);
                                    Position positionO = o.getPosition();
                                    positionO.removeObject(checkObject);
                                    this.position.removeObject(this);
                                }
                            }

                        }
                        if(canMove)
                        {
                           for(Position p :allPosition)
                           {                    
                               if((p.getY() == newPosition.getY()) && (p.getX() == newPosition.getX()))
                               {
                                   this.position.removeObject(this);
                                   this.position = p;
                                   this.position.addObject(this);
                                   this.shape.setLayoutX(p.getX()*100);
                                   this.shape.setLayoutY(p.getY()*100);
                               }
                           }
                        }
                    }
                }
                else if (direction == Direction.Left)
                {
                    newPosition = myGame.getPosition(this.position.getX() -1,this.position.getY());
                    if(newPosition != null)
                    {
                        if(newPosition.getX() != 0 && newPosition.getY() != 0)
                        {
                            if(this instanceof Character)
                               {
                                   checkObject = this.checkCollision(allObjects,newPosition.getX(),newPosition.getY());
                                   if(checkObject != null)
                                   {
                                       if(checkObject instanceof Projectile)
                                       {
                                           Character c = (Character)this;
                                           Projectile p = (Projectile)checkObject;
                                           c.setDead(true);
                                           canMove = false;
                                           p.setActive(false);
                                           Position positionP = p.getPosition();
                                           this.position.removeObject(this);
                                           positionP.removeObject(checkObject);
                                       }
                                       if(checkObject instanceof Obstacle)
                                       {
                                           canMove = false;
                                       }
                                   }
                               }
                            else if(this instanceof Projectile)
                            {
                                checkObject = this.checkCollision(allObjects,newPosition.getX(),newPosition.getY());
                                if(checkObject != null)
                                {
                                    if(checkObject instanceof Character)
                                    {
                                           Character c = (Character)checkObject;
                                           c.setDead(true);
                                           canMove = false;
                                           Projectile p = (Projectile)this;
                                           p.setActive(false);
                                           Position positionC = c.getPosition();
                                           positionC.removeObject(checkObject);
                                           this.position.removeObject(this);
                                    }
                                    if(checkObject instanceof Obstacle)
                                    {
                                        Obstacle o = (Obstacle)checkObject;
                                        o.setBroken(true);
                                        Projectile p = (Projectile)this;
                                        p.setActive(false);
                                        Position positionO = o.getPosition();
                                        positionO.removeObject(checkObject);
                                        this.position.removeObject(this);
                                    }
                                }

                            }
                            if(canMove)
                            {
                               for(Position p :allPosition)
                               {                    
                                   if((p.getY() == newPosition.getY()) && (p.getX() == newPosition.getX()))
                                   {
                                       this.position.removeObject(this);
                                       this.position = p;
                                       this.position.addObject(this);
                                       this.shape.setLayoutX(p.getX()*100);
                                       this.shape.setLayoutY(p.getY()*100);
                                   }
                               }
                            }
                        }
                    }
                }
                else if (direction == Direction.Up)
                {
                    newPosition = myGame.getPosition(this.position.getX(),this.position.getY()-1);
                    if(newPosition != null)
                    {
                        if(newPosition.getX() != 0 && newPosition.getY() != 0)
                        {
                            if(this instanceof Character)
                               {
                                   checkObject = this.checkCollision(allObjects,newPosition.getX(),newPosition.getY());
                                   if(checkObject != null)
                                   {
                                       if(checkObject instanceof Projectile)
                                       {
                                           Character c = (Character)this;
                                           Projectile p = (Projectile)checkObject;
                                           c.setDead(true);
                                           canMove = false;
                                           p.setActive(false);
                                           Position positionP = p.getPosition();
                                           this.position.removeObject(this);
                                           positionP.removeObject(checkObject);
                                       }
                                       if(checkObject instanceof Obstacle)
                                       {
                                           canMove = false;
                                       }
                                   }
                               }
                            else if(this instanceof Projectile)
                            {
                                checkObject = this.checkCollision(allObjects,newPosition.getX(),newPosition.getY());
                                if(checkObject != null)
                                {
                                    if(checkObject instanceof Character)
                                    {
                                           Character c = (Character)checkObject;
                                           c.setDead(true);
                                           canMove = false;
                                           Projectile p = (Projectile)this;
                                           p.setActive(false);
                                           Position positionC = c.getPosition();
                                           positionC.removeObject(checkObject);
                                           this.position.removeObject(this);
                                    }
                                    if(checkObject instanceof Obstacle)
                                    {
                                        Obstacle o = (Obstacle)checkObject;
                                        o.setBroken(true);
                                        Projectile p = (Projectile)this;
                                        p.setActive(false);
                                        Position positionO = o.getPosition();
                                        positionO.removeObject(checkObject);
                                        this.position.removeObject(this);
                                    }
                                }

                            }
                            if(canMove)
                            {
                               for(Position p :allPosition)
                               {                    
                                   if((p.getY() == newPosition.getY()) && (p.getX() == newPosition.getX()))
                                   {
                                       this.position.removeObject(this);
                                       this.position = p;
                                       this.position.addObject(this);
                                       this.shape.setLayoutX(p.getX()*100);
                                       this.shape.setLayoutY(p.getY()*100);
                                   }
                               }
                            }
                        }
                    }
                }
                else if(direction == Direction.Down)
                {
                    newPosition = myGame.getPosition(this.position.getX(),this.position.getY()+1);
                    if(newPosition != null)
                    {
                        if(newPosition.getX() != 0 && newPosition.getY() != 0)
                        {
                            if(this instanceof Character)
                               {
                                   checkObject = this.checkCollision(allObjects,newPosition.getX(),newPosition.getY());
                                   if(checkObject != null)
                                   {
                                       if(checkObject instanceof Projectile)
                                       {
                                           Character c = (Character)this;
                                           Projectile p = (Projectile)checkObject;
                                           c.setDead(true);
                                           canMove = false;
                                           p.setActive(false);
                                           Position positionP = p.getPosition();
                                           this.position.removeObject(this);
                                           positionP.removeObject(checkObject);
                                       }
                                       if(checkObject instanceof Obstacle)
                                       {
                                           canMove = false;
                                       }
                                   }
                               }
                            else if(this instanceof Projectile)
                            {
                                checkObject = this.checkCollision(allObjects,newPosition.getX(),newPosition.getY());
                                if(checkObject != null)
                                {
                                    if(checkObject instanceof Character)
                                    {
                                           Character c = (Character)checkObject;
                                           c.setDead(true);
                                           canMove = false;
                                           Projectile p = (Projectile)this;
                                           p.setActive(false);
                                           Position positionC = c.getPosition();
                                           positionC.removeObject(checkObject);
                                           this.position.removeObject(this);
                                    }
                                    if(checkObject instanceof Obstacle)
                                    {
                                        Obstacle o = (Obstacle)checkObject;
                                        o.setBroken(true);
                                        Projectile p = (Projectile)this;
                                        p.setActive(false);
                                        Position positionO = o.getPosition();
                                        positionO.removeObject(checkObject);
                                        this.position.removeObject(this);
                                    }
                                }

                            }
                            if(canMove)
                            {
                               for(Position p :allPosition)
                               {                    
                                   if((p.getY() == newPosition.getY()) && (p.getX() == newPosition.getX()))
                                   {
                                       this.position.removeObject(this);
                                       this.position = p;
                                       this.position.addObject(this);
                                       this.shape.setLayoutX(p.getX()*100);
                                       this.shape.setLayoutY(p.getY()*100);
                                   }
                               }
                            }
                        }
                    }
                }
            }
            else
            {
                System.out.println("Can't move an immovable object");
            }
        }

    /**
     An method to check if the next Position of this projectile will collide with another object.
     <p>
     @param objects An list of all object currently in the game.
     <p>
     @return Returns an object if the next p of this projectile collides with the object
     else it returns null.
     */
    public Object checkCollision(List<Object> objects,int positionX,int positionY)
    {
        int tempPositionX = positionX;
        int tempPositionY = positionY;
        Object hitObject = null;

        for (Object nxtObject : objects)
        {
            int oPositionX = nxtObject.getPositionX();
            int oPositionY = nxtObject.getPositionY();

            if ((tempPositionX == oPositionX) && (tempPositionY == oPositionY))
            {
                if(nxtObject instanceof Character)
                {
                    hitObject = null;
                }
                else
                {
                    hitObject = nxtObject;
                    break;
                }
            }

        }
        return hitObject;
    }

}
