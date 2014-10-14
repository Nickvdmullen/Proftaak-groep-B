/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

/**
 * OK
 * @author Melanie
 */
public class Server
{
    //************************datavelden*************************************
    private List<User> users;
    private List<Lobby> lobbies;
    private Connection con;

    //***********************constructoren***********************************
    /**
     * creates a server with ...
     * 
     */
    public Server()
    {
        this.users = new ArrayList<>();
        this.lobbies = new ArrayList<>();
        
    }

    public void Connectionstring()
    {
        try
        {
        con = DriverManager.getConnection("jdbc:oracle:thin:@fhictora01.fhict.local:1521:fhictora", "dbi291539", "H96K7hR65A");
        }
        
        catch(Exception ex)
        {
            System.out.println("Geen verbinding met database mogelijk: " + ex);
        }
    }
    //**********************methoden****************************************
    public boolean createUser(String username, String password)
    {
        boolean adduser = true;
        try
        {
        Connectionstring();
        Statement stat = con.createStatement();
        String queryread = "SELECT NAAM FROM USERS";
        ResultSet rs = stat.executeQuery(queryread);
        while
                (rs.next())
                {     
                    if(rs.getString("Naam").equals(username))
                    {
                    adduser = false;
                    System.out.println("Dubbele gebruiker gevonden");
                    }
                }
        }
        catch(Exception ex)
        {
            System.out.println("Dubbele gebruiker gevonden" + ex);
            return false;
        }
  
        if(adduser == true)
        {
            try
            {
            Connectionstring();
            String querywrite = "INSERT INTO USERS VALUES (2,?,?)";
            PreparedStatement stat2 = con.prepareStatement(querywrite);
            stat2.setString(1, username);
            stat2.setString(2, password);
            stat2.execute();
            return true;
            }
        catch(Exception ex)
        {
            System.out.println("Aanmaken van de user is milsukt: " + ex);
            return false;
        }
        }
        return false;
    }
    
    public boolean loginUser(String username, String password)
    {       
        try
        {
        Connectionstring();
        String queryread = "SELECT NAAM,WACHTWOORD FROM USERS";
        PreparedStatement stat2 = con.prepareStatement(queryread);
        ResultSet rs = stat2.executeQuery();    
        while
                (rs.next())
                {     
                    if(rs.getString("NAAM").equals(username) && rs.getString("WACHTWOORD").equals(password))
                    {
                    System.out.println("Gebruiker mag inloggen");
                    return true;
                    }   
                }
        }
        catch(Exception ex)
        {
            System.out.println("Gebruiker niet gevonden" + ex);
            return false;
        }
        System.out.println("Gebruiker mag niet inloggen"); 
        return false;
    }
    
    public boolean createLobby(String lobbyName, String password, User admin)
    {
        if(lobbyName != null && admin != null)
        {
        this.lobbies.add(new Lobby(lobbyName,admin,password));
        return true;
        }
        else
        {
         return false;   
        }
        //password
    }
    
    public boolean joinLobby(Lobby lobby, User user, String password)
    {
        //todo
        //lobby.addUser(user);
        return false;
    }
    
    public boolean leaveLobby(Lobby lobby, User user)
    {
        //todo
        return false;
    }
    
    public boolean deleteLobby(Lobby lobby)
    {
        Lobby templobby = null;
        for(Lobby lobbylist : lobbies)
        {
            if(lobbylist == lobby)
            {
                templobby = lobbylist;
            }
        }
        if(templobby != null)
        {
        lobbies.remove(templobby);
        return true;
        }
        else 
        {
          return false;  
        } 
    }
    
    public Server getServer()
    {
        //todo
        return null;
    }
}
