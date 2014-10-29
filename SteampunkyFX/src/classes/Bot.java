/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.*;

/**
 OK
 <p>
 @author Melanie
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
     Constructor of this class
     <p>
     @param name       The name of the Bot
     @param difficulty The difficulty of the bot
     */
    public Bot(String name , int difficulty)
    {
        this.name = name;
        this.difficulty = difficulty;
        this.botID = this.nextBotID;
        this.nextBotID++;
    }

    //**********************methoden****************************************
    /**
     The getter of BotID
     <p>
     @return an int with the botID
     */
    public int getBotID()
    {
        return this.botID;
    }

    /**
     Getter of name
     <p>
     @return a String with the name of the bot
     */
    public String getName()
    {
        return this.name;
    }

    /**
     Getter of the Difficulty of the bot
     <p>
     @return the difficulty of the bot
     */
    public int getDifficulty()
    {
        return this.difficulty;
    }

    /**
     The setter of the difficulty
     <p>
     @param difficulty an int with the new difficulty
     */
    public void setDifficulty(int difficulty)
    {
        this.difficulty = difficulty;
    }

}
