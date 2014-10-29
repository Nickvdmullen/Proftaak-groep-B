/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steampunkyfx;

import classes.Game;
import classes.Lobby;
import classes.Server;
import static classes.Server.getServer;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author Willem
 */
public class GameRoomController implements Initializable {
    @FXML
    private Font x1;
    @FXML
    private Button BTSpectator;
    @FXML
    private Button BTPlayer;
    @FXML
    private Button BTReturn;
    @FXML
    private Label LBLusername;
    @FXML
    private Label LBLRemaining;
    @FXML
    private Label LBLGameState;
    @FXML
    private Button BTReady;
    @FXML
    private Label LBLPlayer1Status;
    @FXML
    private Label LBLPlayer2Status;
    @FXML
    private Label LBLPlayer3Status;
    @FXML
    private Label LBLPlayer4Status;
    
    
    private Server server;
    private SteampunkyFX main;

    public void setApp(SteampunkyFX application)
    {
        this.main = application;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        server = (Server) getServer();
    }
    
    @FXML
    public void becomeSpectator() 
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
}
