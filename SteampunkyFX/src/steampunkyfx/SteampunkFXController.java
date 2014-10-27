/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package steampunkyfx;

import classes.Server;
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
import javafx.stage.Stage;

/**
 *
 * @author bart
 */
public class SteampunkFXController extends Application implements Initializable
{
    // Loginproftaak
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
           System.out.println("Wachtwoord en usernaam zijn niet correct");
       }
       else
       {
           if(server.loginUser(TFUsernamelogin.getText(), TFWachtwoordlogin.getText()))
           {
               System.out.println("longin succes");
               try
               {        
                   
               }
               catch(Exception ex)
               {
                System.out.println("Fout bij starten lobby : " + ex);
               }
               
           }
           else
           {
               System.out.println("login false");
           }
       }
    }
    
    @FXML
    private void BtCreatecreate() 
    {
       if(TFUsernamecreate.getText().isEmpty() && TFWachtwoordcreate.getText().isEmpty())
       {
           System.out.println("Wachtwoord en usernaam zijn niet correct");
       }
       else
       {
           if(server.createUser(TFUsernamecreate.getText(), TFWachtwoordcreate.getText()))
           {
               System.out.println("user aanmaken geslaagd");
           }
           else
           {
               System.out.println("user aanmaken mislukt user bestaat al");
           }
       }
    }

    @Override
    public void start(Stage stage) throws Exception {
        Class<?> c;
        c = this.getClass();
        java.net.URL r = c.getResource("Loginproftaak.fxml");
        Parent root = FXMLLoader.load(r);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
