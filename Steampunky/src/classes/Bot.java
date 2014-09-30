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
public class Bot
{    
    //************************datavelden*************************************
    private int botID;
    private int nextBotID = 1;
    private String name;
    private int difficulty;

    //***********************constructoren***********************************
    /**
     * creates a bot with ...
     */
    public Bot(String name, int difficulty)
    {
        this.name = name;
        this.difficulty = difficulty;        
        this.botID = this.nextBotID;
        this.nextBotID++;
    }

    //**********************methoden****************************************
    public int getBotID()
    {
        return this.botID;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public int getDifficulty()
    {
        return this.difficulty;
    }
    
    public void setDifficulty(int difficulty)
    {
        this.difficulty = difficulty;
    }
}
