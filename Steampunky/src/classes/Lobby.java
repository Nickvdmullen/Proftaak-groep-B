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
public class Lobby
{
    //************************datavelden*************************************
    private int lobbyID;
    private int nextLobbyID = 1;
    private String lobbyName;
    private String password;
    private String map;
    private List<String> chatMessages;
    private User admin;
    private List<User> spectators;
    private List<User> players;
    private int ratingDifference;
    private Game game;

    //***********************constructoren***********************************
    /**
     * creates a lobby with ...
     */
    public Lobby(String lobbyname, User addedByUser)
    {        
        this.lobbyName = lobbyname;
        this.admin = addedByUser;
        this.lobbyID = this.nextLobbyID;
        this.nextLobbyID++;
        
        this.chatMessages = new ArrayList<>();
        this.admin = addedByUser;
        this.spectators = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    //**********************methoden****************************************
    public boolean checkPassword(String password)
    {
        //todo
        return false;
    }
    
    public boolean createGame(double timelimit, int botDifficulty, String level, int rounds)
    {
        //todo
        return false;
    }
}
