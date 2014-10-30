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
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author Bart
 */
public class SteampunkFXControllerlobby implements Observer, Initializable
{
    //Lobby
    @FXML Label Creatlobbynamelb;
    @FXML Label Creatlobbypasswordlb;
    @FXML Label joinlobbynamelb;
    @FXML Label LBLLobbyWelcome;
    @FXML ComboBox CBjoinlobby;
    @FXML TextField TfCreatename;
    @FXML TextField Tfvreatepassword;
    @FXML Button Btcreatelobby;
    @FXML Button btjoinlobby;
    @FXML ListView Lblobby;
    
    ArrayList<String> lobbyName;

    private SteampunkyFX main;
    private Server server;
    private User user;
    
    public SteampunkFXControllerlobby() {
    }

    public void setApp(SteampunkyFX application,User user)
    {
        this.main = application;
        this.user = user;
        LBLLobbyWelcome.setText("Welcome: " + user.getUsername());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {   
        Clear();
        lobbyName = new ArrayList();
        this.server = (Server) getServer();
        server.addObserver(this);    
    }

    
    @FXML
    public void AddLobby() {
        if (TfCreatename.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"Please enter a valid name.");
        }
        else {
            try {
                server.createLobby(TfCreatename.getText(), Tfvreatepassword.getText(), null);
                JOptionPane.showMessageDialog(null,"Lobby has been created");
                main.gotoGameRoomselect(User admin);
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Lobby creation has failed" + ex.getMessage());
                        System.out.println("Failed");
            }
        }
    }

    @Override
    public void update(Observable o, Object o1) {
        try {
            Lobby lobby = (Lobby) o1;
            lobbyName.add(lobby.ToString());
        } catch(Exception ex) {
            System.out.println("Not an lobby");
        }
        Clear();
        
        Lblobby.setItems(FXCollections.observableList(lobbyName));
        CBjoinlobby.setItems(FXCollections.observableList(lobbyName));
    }
    
    public void Clear() {
        Lblobby.getItems().clear();
        CBjoinlobby.getItems().clear();
    }
}
