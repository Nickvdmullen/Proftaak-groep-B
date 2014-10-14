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
public class Game
{
    //************************datavelden*************************************
    private List<Position> grid;
    private int botDifficulty;
    private double timer;
    private double totalTime; //in seconds
    private int totalRounds;
    private int round;
    private List<Level> levels;
    private List<Object> objects;
    private boolean gameEnd;

    //***********************constructoren***********************************
    /**
     * Constructor of Game
     * @param timelimit          The max amount of time a game can last.
     * @param botDifficulty      The difficulty of the bots.
     * @param rounds             The number of rounds that can be played.
     */
    public Game(double timelimit, int botDifficulty, int rounds)
    {
        this.botDifficulty = botDifficulty;
        this.totalTime = timelimit;
        this.timer = 0;
        this.totalRounds = rounds;
        this.round = 1;        
        
        this.levels = new ArrayList<>();
        this.objects = new ArrayList<>(); 
    }

    //**********************methoden****************************************
    
    /**
     * gets a list of objects on the position with coordinates (x,y).
     * @param x the x coordinate of the position.
     * @param y the y coordinate of the position.
     * @return the list of objects on the position(x,y), if there are no objects returns null.
     */
    public List<Object> getObjectsFromGrid(int x, int y)
    {
        //todo???
        for (Position p : grid)
        {
            if(p.getX() == x && p.getY() == y)
            {
                return p.getObjects();
            }
        }
        return null;
    }
    
    /**
     * Getter of botDifficulty
     * @return  an int representing the difficulty level of the bots
     */
    public int getBotDifficulty()
    {
        return this.botDifficulty;
    }
    
    /**
     * Getter of TotalRounds
     * @return  an int with the amount of rounds
     */
    public int getTotalRounds()
    {
        return this.totalRounds;
    }
    
    /**
     * Getter of CurrentRound
     * @return  an int with the value of current round
     */
    public int getCurrentRound()
    {
        return this.round;
    }
    
    /**
     * Getter of TotalTime
     * @return   a double with the value of the maximum time per round
     */
    public double getTotalTime()
    {
        return this.totalTime;
    }
    
    /**
     * Getter of CurrentTime
     * @return   a double with the value of the remaining time left
     */
    public double getCurrentTime()
    {
        return this.timer;
    }
    
    /**
     * Getter of Characters
     * @return a list of objects with the type Character
     */
    public List<Object> getCharacters()
    {
        return this.objects;
    }
    
    /**
     * Getter of Levels
     * @return a list of Levels
     */
    public List<Level> getLevels()
    {
        return this.levels;
    }
    
    public boolean getGameEnd()
    {
        return this.gameEnd;
    }
    
    /**
     * Setter of botDifficulty
     * @param difficulty    The difficuly of the bots
     * @return   a boolean whether raising or lowering difficulty was succesfull
     */
    public boolean setBotDifficulty(int difficulty)
    {
        this.botDifficulty = difficulty;
        
        //Check if this botDifficulty isn't to low or to high???
        return false;
    }
    

    public void addLevel(Level level)
    {
        this.levels.add(level);
    }
    
    public void addObject(Object object)
    {
        this.objects.add(object);
    }
    
    /**
     * Method to set and object into the grid
     * @param object    object to be put into the grid
     */
    public void setObjectInGrid(Object object)
    {
        //todo
    }
    
    public void setGameEnd(boolean isEnded)
    {
        if (isEnded)
        {
            this.gameEnd = true;
            
            //Ga naar de volgende ronde mits die er is
            if (this.round < this.totalRounds)
            {
                this.round++;
            }
        }
    }    
}
