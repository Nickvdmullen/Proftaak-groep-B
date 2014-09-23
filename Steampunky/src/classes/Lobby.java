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
public class Lobby
{
    //************************datavelden*************************************
    private int lobbyID;
    private String lobbyName;
    private String password;
    private String map;
    private List<String> chatMessages;
    private User admin;
    private List<User> spectators;
    private List<User> players;

    //***********************constructoren***********************************
    /**
     * creates an lobby with ...
     */
    public Lobby(User addedByUser)
    {
        this.chatMessages = new ArrayList<>();
        this.admin = addedByUser;
        this.spectators = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    //**********************methoden****************************************
    
}
