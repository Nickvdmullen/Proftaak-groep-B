/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steampunkyfx;

import classes.Game;
import classes.Lobby;
import classes.Object;
import classes.Position;
import classes.Server;
import static classes.Server.getServer;
import classes.User;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Willem
 */
public class GameRoomController implements Initializable, Observer {

    @FXML private Font x1;
    @FXML private Button BTSpectator;
    @FXML private Button BTPlayer;
    @FXML private Button BTReturn;
    @FXML private Label LBLusername;
    @FXML private Label LBLRemaining;
    @FXML private Label LBLGameState;
    @FXML private Button BTReady;
    @FXML private Label LBLPlayer1Status;
    @FXML private Label LBLPlayer2Status;
    @FXML private Label LBLPlayer3Status;
    @FXML private Label LBLPlayer4Status;
    @FXML private Label LBLSize;
    @FXML private Label LBLWidth;
    @FXML private Label LBLHeight;
    @FXML private Label LBLTime;
    @FXML private Label LBLRounds;
    @FXML private TextField TextWidth;
    @FXML private TextField TextHeight;
    @FXML private TextField TextTime;
    @FXML private TextField TextRounds;
    @FXML private ListView LBPlayers;
    @FXML private ListView LBSpectators;
    
    private Lobby lobby;
    private Server server;
    private SteampunkyFX main;
    private User admin;
    private Stage stage;
    
    private Game game;
    private int widthPixels;
    private int widthCubes;
    private int heightPixels;
    private int heightCubes;
    private Rectangle field;
    private Rectangle playfield;
    
    private ArrayList<String> SpectatorNames;
    private ArrayList<String> PlayerNames;

    public void setApp(SteampunkyFX application, User admin, Lobby lobby,Stage stage)
    {
        this.stage = stage;
        this.main = application;
        this.admin = admin;
        this.lobby = lobby;
        this.lobby.addObserver(this);
        
        this.game = null;
  
        LBLusername.setText("Welcome: " + admin.getUsername());
        
        LBLSize.setVisible(false);
        LBLWidth.setVisible(false);
        LBLHeight.setVisible(false);
        LBLTime.setVisible(false);
        LBLRounds.setVisible(false);
        TextWidth.setVisible(false);
        TextHeight.setVisible(false);
        TextTime.setVisible(false);
        TextRounds.setVisible(false);
        
        for (User u : lobby.getSpectators()) {
            if (u == admin) {
                LBLSize.setVisible(true);
                LBLWidth.setVisible(true);
                LBLHeight.setVisible(true);
                LBLTime.setVisible(true);
                LBLRounds.setVisible(true);
                TextWidth.setVisible(true);
                TextHeight.setVisible(true);
                TextTime.setVisible(true);
                TextRounds.setVisible(true);
            }
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        server = (Server) getServer();
        SpectatorNames = new ArrayList<>();
        PlayerNames = new ArrayList<>();
        //InitCombos();
    }
    
    @FXML
    public void becomeSpectator() 
    {
        
    }
    
    @FXML
    public void becomePlayer()
    {
        
    }
    
    @FXML
    public void ReturnToMenu() 
    {    
    }   
    
    @FXML
    public void Gameready() 
    {
        System.out.print("Add game code here");


        ///Teken code hier aan toevoegen
        
        //Moeten groter zijn dan 9; melding?!
        int width = Integer.parseInt(TextWidth.getText());
        int height = Integer.parseInt(TextHeight.getText());
        
        double time = Integer.parseInt(TextTime.getText()) * 60;
        int botdif = 1; //afhankelijk van level spelers, nog niet geimplementeerd
        int rounds = Integer.parseInt(TextRounds.getText());
        
        this.game = new Game(width, height, time, botdif, rounds);
        widthPixels = this.game.getWidthPixels();
        widthCubes = this.game.getWidthCubes();
        heightPixels = this.game.getHeightPixels();
        heightCubes = this.game.getHeightCubes();
        
        Group root = new Group();
        Scene scene = new Scene(root, 1700, 900);
        
        ScrollPane s1 = new ScrollPane();
        s1.setLayoutX(50);
        s1.setLayoutY(50);
        s1.setPrefSize(1600, 800);
        
        AnchorPane box = new AnchorPane();
        s1.setContent(box);
        
        field = new Rectangle(widthPixels, heightPixels);
        field.setFill(Color.GRAY);
        box.getChildren().add(field);        
        
        playfield = new Rectangle(100, 100, (widthCubes*100), (heightCubes*100));
        playfield.setFill(Color.WHITE);
        box.getChildren().add(playfield);
        
        game.startRound(); // hier gaat het fout met debugen even naar kijken
        
        for (Position p : game.getGrid())
        {
            List<Object> objects = p.getObjects();
            
            for (Object o : objects)
            {
                Shape s = o.getShape();
                box.getChildren().add(s);
            }
        }
        
        root.getChildren().add(s1);
        this.stage.setMinHeight(1700);
        this.stage.setMinWidth(900);
        stage.setScene(scene);  
    }

    /**
     *
     * @param o
     * @param o1
     */
    @Override
    public void update(Observable o, java.lang.Object o1) {
//        try {
//            User user = (User) o1;
//            SpectatorNames.add(user.toString());
//        } catch(Exception ex) {
//            System.out.println("fout" + ex);
//        }    
          InitCombos();
    }
    
    public void InitCombos() {
        for (User u : this.lobby.getPlayers()) {
            this.PlayerNames.add(u.toString());
        }
        
        for (User u : this.lobby.getSpectators()) {
            this.SpectatorNames.add(u.toString());
        }     
        
        this.LBSpectators.setItems(FXCollections.observableList(this.SpectatorNames));
        this.LBPlayers.setItems(FXCollections.observableList(this.PlayerNames));
    }
}
