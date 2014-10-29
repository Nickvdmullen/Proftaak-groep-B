///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package classes;
//
//import java.util.*;
//
// /**
// * OK
// * @author Linda
// */
//public class Character extends Object
//{
//    //************************datavelden*************************************
//    private int characterID;
//    private int score;
//    private double speed;
//    private boolean dead;
//    private int maxBallistae;
//    private int torchLight;
//    private Direction direction;
//    //relaties
//    private List<Ballista> ballistaes;
//    private List<PowerUp> powerups;
//    private User user;
//    
//    /**
//     * The Constructor of Character
//     * @param score         The Score of the character
//     * @param speed         The speed with which the character can move.
//     * @param dead          A boolean for showing if the player is alive or dead
//     * @param maxBallista   An int of the maximum amount of ballista you can drop
//     * @param torch         An int of the value of visible area
//     * @param positionX     
//     * @param positionY
//     * @param active        A boolean if the character is active or not
//     * @param movable       A boolean if the character can move or not 
//     * @param direction     A Direction to which the character is moving
//     */
//    public Character(int score, double speed, boolean dead, int maxBallista, int torch,
//             Position position,boolean active,boolean movable,Direction direction)
//    {        
//        //todo
//        super(position, active, movable,direction);
//        if(dead == true)
//        {
//            throw new IllegalArgumentException("bij maken een nieuw character mag dead niet true zijn");
//        }
//        this.characterID = super.getInterfaceID();
//        this.score = score;
//        this.speed = speed;
//        this.dead = dead;
//        this.maxBallistae = maxBallista;
//        this.torchLight = torch;
//        this.direction = direction; 
//        if (!movable) {
//            this.direction = null;
//        }
//        ballistaes = new ArrayList<>();
//        powerups = new ArrayList<>();
//    }
//
//    //**********************methoden****************************************
//    public int getCharacterID()
//    {
//        return this.characterID;
//    }
//    
//    public double getSpeed()
//    {
//        return this.speed;
//    }
//    
//    public boolean getDead()
//    {
//        return this.dead;
//    }
//    
//    public int getScore()
//    {
//        return this.score;
//    }
//    
//    public int getTorchRange()
//    {
//        return this.torchLight;
//    }
//    
//    public Direction getDirection()
//    {
//        return this.direction;
//    }
//    
//    public void setScore(int score)
//    {
//        this.score = score;
//    }
//    
//    public void setSpeed(double speed)
//    {
//        this.speed = speed;
//    }
//    
//    public void setDead(boolean dead)
//    {
//        this.dead = dead;
//    }
//    
//    public void setTorch(int range)
//    {
//        this.torchLight = range;
//    }
//    
//    public void setDirection(Direction direction)
//    {
//        this.direction = direction;
//    }
//
//    public void createBllista(Direction direction, int shots, double projectileSpeed)
//    {
//        //todo
//        int positionx = this.getPositionX();
//        int positiony = this.getPositionY();
//        boolean active = this.getActive();
//            
//        ballistaes.add(new Ballista("", shots,  projectileSpeed, positionx, positiony,active,false,direction));
//    }
//}
