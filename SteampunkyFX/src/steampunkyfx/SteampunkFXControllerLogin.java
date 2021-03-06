/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package steampunkyfx;

import classes.Server;
import classes.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    
    //Kijk of de user kan inloggen met het opgeven wachtwoord en username
    @FXML
    private void Btlogin() throws IOException 
    {
       if(TFUsernamelogin.getText().isEmpty() && TFWachtwoordlogin.getText().isEmpty())
       {
           JOptionPane.showMessageDialog(null,"Password or username is empty");
       }
       else
       {
           if(server.loginUser(TFUsernamelogin.getText(), TFWachtwoordlogin.getText()))
           {
               System.out.println("longin succes"); 
               try
               {  
                   User tempuser = new User(TFUsernamelogin.getText(), TFWachtwoordlogin.getText());
                   server.Userlogedin(tempuser);
                   main.gotoLobbyselect(tempuser);
               }
               catch(Exception ex)
               {
                    System.out.println("Error at starting lobby : " + ex);
               }
               
           }
           else
           {
               JOptionPane.showMessageDialog(null,"Password or username are incorrect");
           }
       }
    }
    
    //Maakt een user aan in de database
    @FXML
    private void BtCreatecreate() 
    {
       if(TFUsernamecreate.getText().isEmpty() && TFWachtwoordcreate.getText().isEmpty())
       {
           JOptionPane.showMessageDialog(null,"No username or password was filled in");
       }
       else
       {
           if(server.createUser(TFUsernamecreate.getText(), TFWachtwoordcreate.getText()))
           {
               Logintabs.getSelectionModel().select(loginuser);
               JOptionPane.showMessageDialog(null,"User created");
           }
           else
           {
               JOptionPane.showMessageDialog(null,"User already registerd");
           }
       }
    }
}
