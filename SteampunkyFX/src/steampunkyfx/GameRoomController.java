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
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author Willem
 */
public class GameRoomController implements Initializable {
    @FXML
    private Font x1;
    private Button BTSpectator;
    private Button BTPlayer;
    private Button BTReturn;
    private Label LBLusername;
    private Label LBLRemaining;
    private Label LBLGameState;
    private Button BTReady;
    private Label LBLPlayer1Status;
    private Label LBLPlayer2Status;
    private Label LBLPlayer3Status;
    private Label LBLPlayer4Status;
    private Label LBLSize;
    private Label LBLTime;
    private TextField TextSize;
    private TextField TextTime;
    
    
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
        LBLRemaining.setText("Remaining slots: 0");
        LBLSize.setVisible(false);
    LBLTime.setVisible(false);
    TextSize.setVisible(false);
    TextTime.setVisible(false);
        
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
