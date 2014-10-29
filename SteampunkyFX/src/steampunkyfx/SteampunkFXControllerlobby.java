/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steampunkyfx;

import classes.Server;
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
public class SteampunkFXControllerlobby extends Application implements Initializable 
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
    
    


    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {    
    }
    
    
    @Override
    public void start(Stage stage) throws Exception {
//        Class<?> c;
//        c = this.getClass();
//        java.net.URL r = c.getResource("Loginproftaak.fxml");
//        Parent root = FXMLLoader.load(r);
//
//        Scene scene = new Scene(root);
//        scene.getStylesheets().add(SteampunkyFX.class.getResource("style.css").toExternalForm());
//        stage.setScene(scene);
//        stage.setTitle("Steampunky");
//        stage.getIcons().add(new Image(SteampunkyFX.class.getResourceAsStream( "icon.png" ))); 
//        stage.show();
    }   
}
