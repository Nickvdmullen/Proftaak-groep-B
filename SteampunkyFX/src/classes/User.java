/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.*;

/**
 * OK
 *
 * @author Linda
 */
public class User {

    //************************datavelden*************************************
    private int userID;
    private String username;
    private String password;
    private int rating;
    private int wins;
    private int losses;
    //relaties
    private Character character;
    private Lobby currentLobby;

    //***********************constructoren***********************************
    /**
     * creates an user with ...
     */
    public User(int userID, String username, String password) {
        this.userID = userID;
        this.username = username;
        this.password = password;
    }

    /**
     * creates an user with ...
     */
    public User(int userID, String username, String password, int rating, int wins, int losses) {
        if (wins < 0 || losses < 0 || rating < 0) {
            throw new IllegalArgumentException("geen negatieve wins, losses of rating");
        }
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.rating = rating;
        this.wins = wins;
        this.losses = losses;
        this.currentLobby = null;
    }

    //**********************methoden****************************************
    public int getRating() {
        return this.rating;
    }

    public boolean checkPassword(String password) {
        //todo
        boolean gelukt = false;
        if (password.equals(this.password)) {
            gelukt = true;
        }
        return gelukt;
    }

    public String getUsername() {
        return this.username;
    }

    public int[] getWinLoss() {
        //todo
        int[] winst = new int[]{wins, losses};
        return winst;
    }

    public int getUserID() {
        return this.userID;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean joinLobby(Lobby lobby) {
        if (lobby.assignSlot(this)) {
            this.currentLobby = lobby;
            return true;
        }
        return false;
    }

    public boolean leaveLobby(Lobby lobby) {
        if (lobby.removeUser(this) == 1) {
            this.currentLobby = null;
            return true;
        }
        return false;
    }    
}
