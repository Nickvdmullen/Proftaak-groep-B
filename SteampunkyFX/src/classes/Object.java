/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import steampunkyfx.SteampunkyFX;

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
    private String imagestring;
    private String type;
    

    //***********************constructoren***********************************
    /**
     Constructor of the SuperClass Object
     creates an abstract class object with ...
     <p>
     @param type
     @param position  An object of the Class Position which holds a coordinate.
     @param Active    A Boolean which holds the current state of this Object.
     @param Movable   A boolean which holds the current state of this Object
     @param direction A Object of the Class Direction which holds the direction in which this Object is moving.
     @param game      A Object of the Class Game in which this object is placed.
     */
    public Object(String type,Position position , boolean Active , boolean Movable , Direction direction, Game game)
    {
        this.position = position;
        this.active = Active;
        this.movable = Movable;
        this.direction = direction;
        this.myGame = game;
        this.type = type;

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
    
    public String getType()
    {
        return this.type;
    }

    public boolean getMove()
    {
        return this.movable;
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
    }
    
    public void setDirection(Direction d)
    {
        this.direction = d;
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
     * The Getter of the image of the object
     * 
     * @return image string
     */
    public String getImageString()
    {
        return this.imagestring;
    }
    
    /**
     * The Getter of the image of the object
     * 
     * @return image string
     */
    public void setImageString(String image)
    {
        this.imagestring = image;
    }
    
    //<editor-fold defaultstate="collapsed" desc="movement and collision code">
    /**
     * A Method for moving this Object
     * <p>
     * @param direction A Object of the Class Direction which holds the
     * direction in which direction this Object is moving.
     */
    public void move(Direction direction) {
        int nextX = this.getPositionX();
        int nextY = this.getPositionY();
        if (direction == Direction.Right) {
            nextX++;
        } else if (direction == Direction.Left) {
            nextX--;
        } else if (direction == Direction.Up) {
            nextY--;
        } else {
            nextY++;
        }
        if (this.checkCollision(nextX, nextY)) {
            this.myGame.getPosition(nextX, nextY).addObject(this);
            this.position.removeObject(this);
            this.setPosition(this.myGame.getPosition(nextX, nextY));
            this.setDirection(direction);
        }
    }

    /**
     * An method to check if the next Position of this object will collide with
     * another object or wall.
     * <p>
     * @param posX the X coordinate of the position to be checked.
     * @param posY the Y coordinate of the position to be checked.
     * <p>
     * @return Returns a boolean that states if the object can move to the
     * desired position.
     */
    public Boolean checkCollision(int posX, int posY) {
        Boolean Movable = true;
        if (this.myGame.getPosition(posX, posY) != null) {
            if (!this.myGame.getObjectsFromGrid(posX, posY).isEmpty()) {
                List<Object> objects = this.myGame.getObjectsFromGrid(posX, posY);
                //if this is a Character
                if (this instanceof Character) {
                    //for every object on the desired position
                    for (Object O : objects) {
                        //if the Object is a Projectile
                        if (O instanceof Projectile) {
                            //if the direction of this character is opposite to the direciton of the projectile.
                            if ((this.direction == Direction.Up && this.direction == Direction.Down) || (this.direction == Direction.Right && this.direction == Direction.Left) || (this.direction == Direction.Down && this.direction == Direction.Up) || (this.direction == Direction.Left && this.direction == Direction.Right)) {
                                O.RemoveFromGame();
                                this.RemoveFromGame();
                                Movable = false;
                            }
                        } else if (O instanceof Ballista || O instanceof Obstacle) {
                            Movable = false;
                        } else if (O instanceof PowerUp) {
                            PowerUp tempPowerUp = (PowerUp) O;
                            PickUp(tempPowerUp.getType());
                            O.RemoveFromGame();
                        }
                    }
                    // if this is Projectile
                } else if (this instanceof Projectile) {
                    //for every object on desired position
                    for (Object O : objects) {
                        if (O instanceof Obstacle) {
                            Obstacle tempObstacle = (Obstacle) O;
                            if (tempObstacle.getType().matches("cube")) {
                                this.RemoveFromGame();
                                Movable = false;
                            } else {
                                this.RemoveFromGame();
                                O.RemoveFromGame();
                                Movable = false;
                            }
                        } else {
                            O.RemoveFromGame();
                            this.RemoveFromGame();
                            Movable = false;
                        }
                    }
                }
            }
        } else {
            if(this instanceof Projectile){
                this.RemoveFromGame();
            }
            Movable = false;
        }
        return Movable;
    }

    public void RemoveFromGame() {
        if (this instanceof Character) {
            Character C = (Character) this;
            C.setDead(true);
        } else if (this instanceof Obstacle) {
            Obstacle O = (Obstacle) this;
            O.setBroken(true);
        }
        this.setActive(false);
        this.position.removeObject(this);
        this.myGame.getObjects().remove(this);
    }

    private void PickUp(String type) {
        if (this instanceof Character) {
            Character c = (Character) this;
            int t;
            if (type.equals("torch")) {
                t = c.getTorchRange();
                c.setTorch(t++);
            }
            if (type.equals("ballista")) {
                t = c.getMaxBallistas();
                c.setMaxBallistas(t++);
            }
            if (type.equals("projectiles")) {
                t = c.getShots();
                c.setShots(t + 4);
            }
        }
    }
    //</editor-fold>

}
