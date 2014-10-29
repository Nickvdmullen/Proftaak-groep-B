/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

import java.util.*;

/**
 * OK
 * @author Bart
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
    private List<Game> games;
    private int ratingDifference;
    private Game game;

    //***********************constructoren***********************************
    /**
     * creates a lobby with ...
     */
    public Lobby(String lobbyname, User addedByUser,String password)
    {        
        this.lobbyName = lobbyname;
        this.admin = addedByUser;
        this.lobbyID = this.nextLobbyID;
        this.nextLobbyID++;
        this.password = password;
        this.chatMessages = new ArrayList<>();
        this.admin = addedByUser;
        this.spectators = new ArrayList<>();
        this.players = new ArrayList<>();
        this.games = new ArrayList<>();
    }

    public String GetLobbyname(){
       return this.lobbyName;
  }
    
    //**********************methoden****************************************
    public boolean checkPassword(String password)
    {
        if(this.password.equals(password))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean createGame(double timelimit, int botDifficulty, String level, int rounds)
    {
                //todo
        if(timelimit != 0 && botDifficulty != 0 && level != null && rounds != 0)
        {
        games.add(game = new Game(9,9,timelimit,botDifficulty,rounds));
        return true;
        }
      
        return false;
    }
    
    public boolean addUser(User user)
    {
        if(user != null && !this.spectators.contains(user))
        {
            this.spectators.add(user);
            return true;   
        }
        return false;
    }
    /**
     * removes a user if this exists, if the user is an admin, check if there are more users. if there are more users give admin to the next user
     * if there are no new users, return a value that shows that the lobby has to be removed
     * @param user
     * @return if return -1 delete this lobby, if 0 no user has been removed if 1 user has been removed
     */
    public int removeUser(User user)
    {
        int removedUser = 0;
        
        if(this.spectators.contains(user)){
            this.spectators.remove(user);
            removedUser = 1;
        }else if (this.players.contains(user)){
            this.players.remove(user);
            removedUser = 1;
        }
        if (this.admin == user && this.spectators.iterator().hasNext()){
            this.admin = this.spectators.iterator().next();            
        } else if (this.admin == user){
            removedUser = -1;
        }
        return removedUser;
          
    }
    
    
    public boolean assignSlot(User user)
    {
        if(this.spectators.contains(user) && !this.players.contains(user))
        {
            this.players.add(user);
            this.spectators.remove(user);
            return true;
        }
        return false;
    }
    
    public boolean clearSlot(User user)
    {
        if(!this.spectators.contains(user) && this.players.contains(user))
        {
            this.spectators.add(user);
            this.players.remove(user);
            return true;
        }
        return false;
    }   
    
    public String ToString()
    {
       return this.lobbyName; 
    }
}
