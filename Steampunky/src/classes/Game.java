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
    private int[] grid;
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
     * Getter of an object
     * @param position      Position of the object
     * @return              the object;
     */
    public Object getGrid(Object[] position)
    {
        //todo???
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
    
<<<<<<< HEAD
    public void addLevel(Level level)
=======
    /**
     * Setter of CurrentRound
     * @param round  the current round
     */
    public void setCurrentRound(int round)
>>>>>>> origin/master
    {
        this.levels.add(level);
    }
    
<<<<<<< HEAD
    public void addObject(Object object)
=======
    /**
     * Setter of CurrentTime
     * @param timer  the current time
     */
    public void setCurrentTime(double timer)
>>>>>>> origin/master
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
    
<<<<<<< HEAD
    public void setGameEnd(boolean isEnded)
=======
    /**
     * Method to add a new level
     * @param level     Level to be added
     */
    public void addLevel(Level level)
    {
        levels.add(level);
    }
    
    /**
     * Method to manualy choose which level is next
     * @param round     the int value of the level you have selected
     */
    public void ChooseLevel(int round)
>>>>>>> origin/master
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
