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
    private final double MINIMUM_WINDOW_WIDTH = 390.0;
    private final double MINIMUM_WINDOW_HEIGHT = 500.0;

    @Override
    public void start(Stage stage) throws Exception {
        try {
            stage = stage;
            stage.setTitle("SteamPunky");
            stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
            stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
            gotologinselect();

            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void gotologinselect() {
        try {
            SteampunkFXController loginselect = (SteampunkFXController) replaceSceneContent("Loginproftaak.fxml");
            loginselect.setApp(this);
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
        Scene scene = new Scene(page, 800, 600);
        // scene.getStylesheets().add("bank/gui/ING.css");
        stage.setScene(scene);
        stage.sizeToScene();
        return (Initializable) loader.getController();
    }

//        Class<?> c;
//        c = this.getClass();
//        java.net.URL r = c.getResource("Loginproftaak.fxml");
//        Parent root = FXMLLoader.load(r);
//
//        Scene scene = new Scene(root);
//        scene.getStylesheets().add(SteampunkyFX.class.getResource("style.css").toExternalForm());
//        stage.setScene(scene);
//        stage.setTitle("Steampunky");
//        stage.getIcons().add(new Image(SteampunkyFX.class.getResourceAsStream("icon.png"))); 
//        stage.show();
//        this.stage = stage;
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
