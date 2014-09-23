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
public class Server
{
    //************************datavelden*************************************
    private List<User> users;
    private List<Lobby> lobbies;

    //***********************constructoren***********************************
    /**
     * creates an bot with ...
     */
    public Server()
    {
        this.users = new ArrayList<>();
        this.lobbies = new ArrayList<>();
    }

    //**********************methoden****************************************
    public void addUser(String username, String password)
    {
        //todo
    }
    
    public void loginUser(String username, String password)
    {
        //todo
    }
    
    public boolean addLobby(String lobbyName, String password, User admin)
    {
        //todo
        return false;
    }
    
    public boolean joinLobby(Lobby lobby, User user)
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
}
