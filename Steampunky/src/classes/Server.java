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
public class Server
{
    //************************datavelden*************************************
    private List<User> users;
    private List<User> lobbies;

    //***********************constructoren***********************************
    /**
     * creates a server with ...
     * 
     */
    private Server()
    {
        this.users = new ArrayList<>();
        this.lobbies = new ArrayList<>();
    }

    //**********************methoden****************************************
    public boolean createUser(String username, String password)
    {
        //todo
        return false;
    }
    
    public boolean loginUser(String username, String password)
    {
        //todo
        return false;
    }
    
    public boolean createLobby(String lobbyName, String password, User admin)
    {
        //todo
        return false;
    }
    
    public boolean joinLobby(Lobby lobby, User user, String password)
    {
        //todo
        return false;
    }
    
    public boolean leaveLobby(Lobby lobby, User user)
    {
        //todo
        return false;
    }
    
    public boolean deleteLobby(Lobby lobby)
    {
        //todo
        return false;
    }
    
    public Server getServer()
    {
        //todo
        return null;
    }
}
