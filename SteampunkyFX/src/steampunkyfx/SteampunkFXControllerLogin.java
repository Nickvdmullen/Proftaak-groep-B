/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package steampunkyfx;

import classes.Server;
import classes.User;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author bart
 */
public class SteampunkFXControllerLogin implements Initializable
{
    // Loginproftaak
    @FXML Tab loginuser;
    @FXML Tab Createuser;
    @FXML TabPane Logintabs;
    //Login user
    @FXML Button BTloginuserlogin;
    @FXML Button BTExitlogin;
    @FXML TextField TFUsernamelogin;
    @FXML TextField TFWachtwoordlogin;
    @FXML Label LBUsernamelogin;
    @FXML Label LBWachtwoordlogin;
    
    //Create user
    @FXML Button BtCreatecreate;
    @FXML Button BTExitcreate;
    @FXML TextField TFUsernamecreate;
    @FXML TextField TFWachtwoordcreate;
    @FXML Label LBUsernamecreate;
    @FXML Label LBWachtwoordcreate;

    // Lobby
    @FXML Button Btcreatelobby;
    @FXML Button Btdeletelobby;
    @FXML Button btjoinlobby;
    @FXML TextField TfCreatename;
    @FXML TextField Tfvreatepassword;
    @FXML ListView Lblobby;
    @FXML ComboBox CBdeletelobby; 
    @FXML ComboBox CBjoinlobby; 

    
    
    private Server server;
    private SteampunkyFX main;


    public void setApp(SteampunkyFX application)
    {
        this.main = application;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {    
        server = Server.getServer();
    }
    
    @FXML
    private void BTExitlogin()
    {
        Stage stage = (Stage) BTExitlogin.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void Btlogin() throws IOException 
    {
       if(TFUsernamelogin.getText().isEmpty() && TFWachtwoordlogin.getText().isEmpty())
       {
           JOptionPane.showMessageDialog(null,"Wachtwoord of usernaam is niet ingevuld");
       }
       else
       {
           if(server.loginUser(TFUsernamelogin.getText(), TFWachtwoordlogin.getText()))
           {
               System.out.println("longin succes"); 
               try
               {  
                   System.out.println(TFUsernamelogin.getText());
                   System.out.println(TFWachtwoordlogin.getText());
                   User tempuser = new User(TFUsernamelogin.getText(), TFWachtwoordlogin.getText());
                   server.Userlogedin(tempuser);
                   main.gotoLobbyselect(tempuser);
               }
               catch(Exception ex)
               {
                    System.out.println("Fout bij starten lobby : " + ex);
               }
               
           }
           else
           {
               JOptionPane.showMessageDialog(null,"Wachtwoord of usernaam is niet correct");
           }
       }
    }
    
    @FXML
    private void BtCreatecreate() 
    {
       if(TFUsernamecreate.getText().isEmpty() && TFWachtwoordcreate.getText().isEmpty())
       {
           JOptionPane.showMessageDialog(null,"Geen user of wachtwoord ingevuld");
       }
       else
       {
           if(server.createUser(TFUsernamecreate.getText(), TFWachtwoordcreate.getText()))
           {
               Logintabs.getSelectionModel().select(loginuser);
               JOptionPane.showMessageDialog(null,"User is aangemaakt");
           }
           else
           {
               JOptionPane.showMessageDialog(null,"Usernaam bestaat al in de database");
           }
       }
    }
}
