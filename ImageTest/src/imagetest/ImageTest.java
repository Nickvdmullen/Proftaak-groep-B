/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package imagetest;

import images.*;
import java.io.File;
import java.net.URL;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Melanie
 */
public class ImageTest extends Application
{
    
    public ImageSelector selector;
    
    @Override
    public void start(Stage primaryStage) {
        
        selector = new ImageSelector();
        
        StackPane root = new StackPane();
        
        String urlString = "/images/player.png";
        String urlString2 = "player.png";
        String urlString3 = "." + File.separatorChar + "images" + File.separatorChar + "player.png";
        //FileInputStream stream = null;
        //File file = null;
        Image image = null;
        ImageView img = null; 

        try
        {
            //image = new Image(urlString, 100, 100, false, false);
            //URL url = getClass().getResource(urlString2);
            //System.out.println("File exists: " + url.getPath());
            //File file = new File(url.getPath());
            //System.out.println("File exists: " + file.exists());            
            //image = new Image(file.toURI().toString());
            
            //image = new Image(this.getClass().getResourceAsStream(urlString2));
            image = selector.getImage("character");
            img = new ImageView(image);
            root.getChildren().add(img);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }        
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }   
}
