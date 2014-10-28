/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steampunkyfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 *
 * @author Willem
 */
public class SteampunkyFX extends Application {
    
    
    @Override
    public void start(Stage stage) throws Exception 
    {
        Class<?> c;
        c = this.getClass();
        java.net.URL r = c.getResource("Loginproftaak.fxml");
        Parent root = FXMLLoader.load(r);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(SteampunkyFX.class.getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Steampunky");
        stage.getIcons().add(new Image(SteampunkyFX.class.getResourceAsStream( "icon.png" ))); 
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
