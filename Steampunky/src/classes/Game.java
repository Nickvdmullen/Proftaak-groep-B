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
     * creates a game with ...
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
    public Object getGrid(Object[] position)
    {
        //todo???
        return null;
    }
    
    public int getBotDifficulty()
    {
        return this.botDifficulty;
    }
    
    public int getTotalRounds()
    {
        return this.totalRounds;
    }
    
    public int getCurrentRound()
    {
        return this.round;
    }
    
    public double getTotalTime()
    {
        return this.totalTime;
    }
    
    public double getCurrentTime()
    {
        return this.timer;
    }
    
    public List<Object> getCharacters()
    {
        return this.objects;
    }
    
    public List<Level> getLevels()
    {
        return this.levels;
    }
    
    public boolean getGameEnd()
    {
        return this.gameEnd;
    }
    
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
