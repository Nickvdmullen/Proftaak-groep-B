/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

import java.util.*;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;

/**
 * OK
 * @author Bart
 */
public class Lobby extends Observable
{
    //************************datavelden*************************************
    private int lobbyID;
    private int nextLobbyID = 1;
    private String lobbyName;
    private String password;
    private String map;
    private ArrayList<String> chatMessages;
    private transient ObservableList<String> observableChat;
    private User admin;
    private ArrayList<User> spectators;
    private transient ObservableList<User> observableSpectators;
    private ArrayList<User> players;
    private transient ObservableList<User> observablePlayers;
    private ArrayList<Game> games;
    private int ratingDifference;
    private Game game;

    //***********************constructoren***********************************
    /**
     * creates a lobby with ...
     */
    public Lobby(String lobbyname, User addedByUser, String password)
    {        
        this.lobbyName = lobbyname;
        this.admin = addedByUser;
        this.lobbyID = this.nextLobbyID;
        this.nextLobbyID++;
        this.password = password;
        this.admin = addedByUser;
        
        this.games = new ArrayList<>();
        this.spectators = new ArrayList<>();
        observableSpectators = observableList(spectators);
        this.players = new ArrayList<>();
        observablePlayers = observableList(players);
        this.chatMessages = new ArrayList<>();
        observableChat = observableList(chatMessages);
    }

    public String GetLobbyname(){
       return this.lobbyName;       
    }
    
    public ObservableList<User> getSpectators() {
        return (ObservableList<User>) FXCollections.unmodifiableObservableList(observableSpectators);
    }
    
    public ObservableList<User> getPlayers() {
        return (ObservableList<User>) FXCollections.unmodifiableObservableList(observablePlayers);
    }
    
    public ObservableList<String> getChat() {
        return (ObservableList<String>) FXCollections.unmodifiableObservableList(observableChat);
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
        if(user != null && !this.observableSpectators.contains(user))
        {
            this.observableSpectators.add(user);
            this.setChanged();
            this.notifyObservers(user);
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
        
        if(this.observableSpectators.contains(user)){
            this.observableSpectators.remove(user);
            this.setChanged();
            this.notifyObservers(user);
            removedUser = 1;
        }else if (this.observablePlayers.contains(user)){
            this.observablePlayers.remove(user);
            this.setChanged();
            this.notifyObservers(user);
            removedUser = 1;
        }
        if (this.admin == user && this.observableSpectators.iterator().hasNext()){
            this.admin = this.observableSpectators.iterator().next();            
        } else if (this.admin == user){
            removedUser = -1;
        }
        return removedUser;
          
    }
    
    
    public boolean assignSlot(User user)
    {
        if(this.observableSpectators.contains(user) && !this.observablePlayers.contains(user))
        {
            this.observablePlayers.add(user);
            this.observableSpectators.remove(user);
            this.setChanged();
            this.notifyObservers(user);
            return true;
        }
        return false;
    }
    
    public boolean clearSlot(User user)
    {
        if(!this.observableSpectators.contains(user) && this.observablePlayers.contains(user))
        {
            this.observableSpectators.add(user);
            this.observablePlayers.remove(user);
            this.setChanged();
            this.notifyObservers(user);
            return true;
        }
        return false;
    }   
    
    @Override
    public String toString()
    {
       return this.lobbyName; 
    }
}
