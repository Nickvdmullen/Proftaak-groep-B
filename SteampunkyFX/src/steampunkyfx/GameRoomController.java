/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steampunkyfx;

import classes.Lobby;
import classes.Server;
import static classes.Server.getServer;
import classes.User;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author Willem
 */
public class GameRoomController implements Initializable, Observer {

    @FXML private Font x1;
    @FXML private Button BTSpectator;
    @FXML private Button BTPlayer;
    @FXML private Button BTReturn;
    @FXML private Label LBLusername;
    @FXML private Label LBLRemaining;
    @FXML private Label LBLGameState;
    @FXML private Button BTReady;
    @FXML private Label LBLPlayer1Status;
    @FXML private Label LBLPlayer2Status;
    @FXML private Label LBLPlayer3Status;
    @FXML private Label LBLPlayer4Status;
    @FXML private Label LBLSize;
    @FXML private Label LBLTime;
    @FXML private TextField TextSize;
    @FXML private TextField TextTime;
    @FXML private ListView LBPlayers;
    @FXML private ListView LBSpectators;
    
    private Lobby lobby;
    private Server server;
    private SteampunkyFX main;
    private User admin;
    
    private ArrayList<String> SpectatorNames;
    private ArrayList<String> PlayerNames;

    public void setApp(SteampunkyFX application, User admin, Lobby lobby)
    {
        this.main = application;
        this.admin = admin;
        this.lobby = lobby;
        this.lobby.addObserver(this);
  
        LBLusername.setText("Welcome: " + admin.getUsername());
        
        LBLSize.setVisible(false);
        LBLTime.setVisible(false);
        TextSize.setVisible(false);
        TextTime.setVisible(false);
        
        for (User u : lobby.getSpectators()) {
            if (u == admin) {
                LBLSize.setVisible(true);
                LBLTime.setVisible(true);
                TextSize.setVisible(true);
                TextTime.setVisible(true);
            }
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        server = (Server) getServer();
        SpectatorNames = new ArrayList<>();
        PlayerNames = new ArrayList<>();
    }
    
    @FXML
    public void becomeSpectator() 
    {
        
    }
    
    @FXML
    public void becomePlayer()
    {
        
    }
    
    @FXML
    public void ReturnToMenu() 
    {    
    }   
    
    @FXML
    public void Gameready()
    {
        System.out.print("Add game code here");
        ///Teken code hier aan toevoegen
    }

    /**
     *
     * @param o
     * @param o1
     */
    @Override
    public void update(Observable o, Object o1) {
//        try {
//            User user = (User) o1;
//            SpectatorNames.add(user.toString());
//        } catch(Exception ex) {
//            System.out.println("fout" + ex);
//        }    
            
        
        for (User u : this.lobby.getPlayers()) {
            this.PlayerNames.add(u.toString());
        }
        
        for (User u : this.lobby.getSpectators()) {
            this.SpectatorNames.add(u.toString());
        }     
        
        this.LBSpectators.setItems(FXCollections.observableList(this.SpectatorNames));
        this.LBPlayers.setItems(FXCollections.observableList(this.PlayerNames));
    }
}
