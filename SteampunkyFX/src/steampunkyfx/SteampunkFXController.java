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
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 *
 * @author bart
 */
public class SteampunkFXController implements Initializable
{
    //MENUs en TABs
    @FXML MenuBar Menubar;
    @FXML MenuItem MIfile;
    @FXML MenuItem MIedit;
    @FXML Tab loginuser;
    @FXML Tab Createuser;

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
    private void Btlogin() 
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
               System.out.println("user aanmaken mislukt");
           }
       }
    }
}
