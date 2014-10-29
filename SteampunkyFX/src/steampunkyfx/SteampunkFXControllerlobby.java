/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steampunkyfx;

import classes.Lobby;
import classes.Server;
import static classes.Server.getServer;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Bart
 */
public class SteampunkFXControllerlobby  implements Initializable 
{
    //Lobby
    @FXML Label Creatlobbynamelb;
    @FXML Label Creatlobbypasswordlb;
    @FXML Label joinlobbynamelb;
    @FXML ComboBox CBjoinlobby;
    @FXML TextField TfCreatename;
    @FXML TextField Tfvreatepassword;
    @FXML Button Btcreatelobby;
    @FXML Button btjoinlobby;
    @FXML ListView Lblobby;
    
    

    private SteampunkyFX main;
    private Server server;
    
    public SteampunkFXControllerlobby() {
        //enpty
    }

    public void setApp(SteampunkyFX application)
    {
        this.main = application;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {    
        this.server = (Server) getServer();
        Lblobby.setItems(server.getLobbies());
        CBjoinlobby.setItems(server.getLobbies());
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
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Lobby creation has failed" + ex.getMessage());
            }
        }
        Lblobby.setItems(server.getLobbies());
        CBjoinlobby.setItems(server.getLobbies());
    }
}
