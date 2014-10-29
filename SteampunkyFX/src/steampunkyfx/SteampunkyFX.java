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
    private final double MINIMUM_WINDOW_WIDTH = 300.0;
    private final double MINIMUM_WINDOW_HEIGHT = 276.0;

    @Override
    public void start(Stage stage) throws Exception {
        try {
            this.stage = stage;
            this.stage.setTitle("SteamPunky");
            this.stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
            this.stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
            gotologinselect();

            this.stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void gotologinselect() {
        try {
            SteampunkFXController loginselect = (SteampunkFXController) replaceSceneContent("loginProftaak2.fxml");
            loginselect.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(SteampunkyFX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void gotolobbyselect() {
        try {
            SteampunkFXControllerlobby lobbyselect = (SteampunkFXControllerlobby) replaceSceneContent("lobby2.fxml");
            lobbyselect.setApp(this);
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
        if(fxml.equals("loginProftaak2.fxml"))
        {
            scene = new Scene(page, 300, 276); 
        }
        if(fxml.equals("lobby2.fxml"))
        {
            scene = new Scene(page, 300, 276); 
        }

        // scene.getStylesheets().add("bank/gui/ING.css");
        stage.setScene(scene);
        stage.sizeToScene();
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
