/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steampunkyfx;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Bart
 */
public class SteampunkyFX extends Application {

    private Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        try {
            this.stage = stage;
            this.stage.setTitle("SteamPunky");
            this.stage.setMinWidth(100);
            this.stage.setMinHeight(100);
            gotoLoginselect();
            

            this.stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void gotoLoginselect() {
        try {
            SteampunkFXController loginselect = (SteampunkFXController) replaceSceneContent("LoginProftaak2.fxml");
            loginselect.setApp(this); 
        } catch (Exception ex) {
            Logger.getLogger(SteampunkyFX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void gotoLobbyselect() {
        try {
            SteampunkFXControllerlobby lobbyselect = (SteampunkFXControllerlobby) replaceSceneContent("Lobby3.fxml");
            lobbyselect.setApp(this);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            Logger.getLogger(SteampunkyFX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void gotoGameRoomselect() {
        try {
            GameRoomController GameRoomselect = (GameRoomController) replaceSceneContent("GameRoom.fxml");
           GameRoomselect.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(SteampunkyFX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = SteampunkyFX.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(SteampunkyFX.class.getResource(fxml));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        }
        
        Scene scene = null;
        if(fxml.equals("LoginProftaak2.fxml"))
        {
            this.stage.setMinWidth(300);
            this.stage.setMinHeight(268);
            scene = new Scene(page, 300, 268); 
        }
        else if(fxml.equals("Lobby3.fxml"))
        {
            this.stage.setMinWidth(630);
            this.stage.setMinHeight(400);
            scene = new Scene(page, 630, 400); 
        }        
        else if(fxml.equals("GameRoom.fxml"))
        {
            this.stage.setMinWidth(600);
            this.stage.setMinHeight(400);
            scene = new Scene(page, 600, 400); 
        }
        else {
            System.out.println("FATAL GUI ERROR");
        }
        
        if (scene != null) {
            scene.getStylesheets().add(SteampunkyFX.class.getResource("style.css").toExternalForm());
        stage.setTitle("Steampunky");
        stage.getIcons().add(new Image(SteampunkyFX.class.getResourceAsStream("icon.png"))); 
        stage.setScene(scene);
        } else {
            System.out.println("You done fucked up now");
        }
        
        
        //stage.sizeToScene();
        return (Initializable) loader.getController();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public Stage getstage()
    {
        return this.stage;
    }  
}
