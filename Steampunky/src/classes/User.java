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
public class User
{
    //************************datavelden*************************************
    private int userID;
    private String username;
    private String password;
    private int rating;
    private int wins;
    private int losses;

    //***********************constructoren***********************************
    /**
     * creates an user with ...
     */
    public User(int userID, String username, String password)
    {
        this.userID = userID;
        this.username = username;
        this.password = password;
    }
    
    /**
     * creates an user with ...
     */
    public User(int userID, String username, String password, int rating, int wins, int losses)
    {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.rating = rating;
        this.wins = wins;
        this.losses = losses;
    }

    //**********************methoden****************************************
    public int getRating()
    {
        return this.rating;
    }
    
    public boolean checkPassword(String password)
    {
        //todo
        return false;
    }
    
    public String getUsername()
    {
        return this.username;
    }
    
    public int[] getWinLoss()
    {
        //todo
        return null;
    }
    
    public int getUserID()
    {
        return this.userID;
    }
    
    public int setRating(int rating)
    {
        this.rating = rating;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
}
