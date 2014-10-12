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
    private List<Objects> objects;

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
        //todo
        return null;
    }
    
    public int getBotDifficulty()
    {
        //todo
        return 0;
    }
    
    public int getTotalRounds()
    {
        return this.totalRounds;
    }
    
    public int getCurrentRound()
    {
        //todo
        return this.round;
    }
    
    public double getTotalTime()
    {
        return this.totalTime;
    }
    
    public double getCurrentTime()
    {
        //todo
        return this.timer;
    }
    
    public List<Object> getCharacters()
    {
        //todo
        return null;
    }
    
    public List<Level> getLevels()
    {
        //todo
        return null;
    }
    
    public boolean setBotDifficulty(int difficulty)
    {
        //todo
        this.botDifficulty = difficulty;
        return false;
    }
    
    public void setCurrentRound(int round)
    {
        this.round = round;
    }
    
    public void setCurrentTime(double timer)
    {
        this.timer = timer;
    }
    
    public void setObjectInGrid(Object object)
    {
        //todo
    }
    
    public void addLevel(Level level)
    {
        levels.add(level);
    }
    
    public void ChooseLevel(int round)
    {
        //todo
    }
}
