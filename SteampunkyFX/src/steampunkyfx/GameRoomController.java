/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steampunkyfx;

import classes.Direction;
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
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
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
    @FXML private Label LBLsize;
    @FXML private Label LBLHeight;
    @FXML private Label LBLWidth;
    @FXML private Label LBLTime;
    @FXML private Label LBLRound;
    @FXML private ListView LBPlayers;
    @FXML private ListView LBSpectators;
    @FXML private ComboBox CBlevelsizeHeight;
    @FXML private ComboBox CBlevelsizeWidth;
    @FXML private ComboBox CBMinutes;
    @FXML private ComboBox CBrounds;

    private Lobby lobby;
    private Server server;
    private SteampunkyFX main;
    private User admin;
    private Stage stage;
    private int slotsleft = 4;

    private Game game;
    private int widthPixels;
    private int widthCubes;
    private int heightPixels;
    private int heightCubes;
    private Rectangle field;
    private Rectangle playfield;

    private ArrayList<String> SpectatorNames;
    private ArrayList<String> PlayerNames;
    private ArrayList<String> Roomsizewidth;
    private ArrayList<String> Roomsizeheight;
    private ArrayList<String> Rounds;
    private ArrayList<String> Time;
    private transient ObservableList<String> observableRounds;
    private transient ObservableList<String> observableTime;
    private transient ObservableList<String> observableRoomsizewidth;
    private transient ObservableList<String> observableRoomsizeheight;
    private Timer timer;
    private int timercount = 6;
    private int countdown = 6;

    public void setApp(SteampunkyFX application, User admin, Lobby lobby, Stage stage) {
        this.stage = stage;
        this.main = application;
        this.admin = admin;
        this.lobby = lobby;
        this.lobby.addObserver(this);
        this.game = null;

        LBLusername.setText("Welcome: " + admin.getUsername());
        LBLRemaining.setText("Remaining slots: " + this.slotsleft);
        BTReady.setDisable(true);
        BTSpectator.setDisable(true);

        LBLsize.setDisable(true);
        LBLHeight.setDisable(true);
        LBLWidth.setDisable(true);
        LBLTime.setDisable(true);
        LBLRound.setDisable(true);
        CBlevelsizeHeight.setDisable(true);
        CBlevelsizeWidth.setDisable(true);
        CBMinutes.setDisable(true);
        CBrounds.setDisable(true);

        //add level size 
        observableRounds = observableList(this.Rounds);
        observableTime = observableList(this.Time);
        observableRoomsizewidth = observableList(this.Roomsizewidth);
        observableRoomsizeheight = observableList(this.Roomsizeheight);

        for (int TimeRound = 1; TimeRound < 5; TimeRound++) {
            String temp = "" + TimeRound;
            observableRounds.add(temp);
            observableTime.add(temp);
        }

        for (int widthheight = 9; widthheight < 20; widthheight++) {
            if (widthheight % 2 != 0) {
                String temp = "" + widthheight;
                observableRoomsizewidth.add(temp);
                observableRoomsizeheight.add(temp);
            }
        }

        InitCombos();
        this.CBMinutes.getSelectionModel().select(0);
        this.CBrounds.getSelectionModel().select(0);
        this.CBlevelsizeWidth.getSelectionModel().select(0);
        this.CBlevelsizeHeight.getSelectionModel().select(0);

        for (User u : lobby.getSpectators()) {
            if (u == admin) {
                LBLsize.setDisable(false);
                LBLHeight.setDisable(false);
                LBLWidth.setDisable(false);
                LBLTime.setDisable(false);
                LBLRound.setDisable(false);
                CBlevelsizeHeight.setDisable(false);
                CBlevelsizeWidth.setDisable(false);
                CBMinutes.setDisable(false);
                CBrounds.setDisable(false);
            }
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        server = (Server) getServer();
        SpectatorNames = new ArrayList<>();
        PlayerNames = new ArrayList<>();
        Roomsizewidth = new ArrayList<>();
        Roomsizeheight = new ArrayList<>();
        Rounds = new ArrayList<>();
        Time = new ArrayList<>();
    }

    @FXML
    public void becomeSpectator() {
        lobby.clearSlot(admin);
        slotsleft++;
        LBLRemaining.setText("Remaining slots: " + slotsleft);
        BTReady.setDisable(true);
        this.BTPlayer.setDisable(false);
        BTSpectator.setDisable(true);
    }

    @FXML
    public void becomePlayer() {
        lobby.assignSlot(admin);
        slotsleft--;
        BTReady.setDisable(false);
        this.BTPlayer.setDisable(true);
        BTSpectator.setDisable(false);
        LBLRemaining.setText("Remaining slots: " + slotsleft);
    }

    @FXML
    public void ReturnToMenu() {
        main.gotoLobbyselect(admin);
    }

    public void Countdown() {
        countdown--;
        System.out.println(countdown);
        String number = "Game wil start in: " + countdown;
        this.LBLGameState.setText(number);

        if (countdown == 0) 
        {
            //Teken code hier aan toevoegen
        
        //Moeten groter zijn dan 9; melding?!
        int width = Integer.parseInt(this.CBlevelsizeWidth.getValue().toString());
        int height = Integer.parseInt(this.CBlevelsizeHeight.getValue().toString());
        
        double time = Integer.parseInt(this.CBMinutes.getValue().toString()) * 60;
        int botdif = 1; //afhankelijk van level spelers, nog niet geimplementeerd
        int rounds = Integer.parseInt(this.CBrounds.getValue().toString());
        
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
        
        game.addPlayer(admin);
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
        this.stage.setMinHeight(900);
        this.stage.setMinWidth(1700);
        stage.setScene(scene);  
        
        scene.setOnKeyPressed((KeyEvent keyEvent) -> {
            if(keyEvent.getCode().toString().equals("W"))
            {
                game.getCharacter().move(Direction.Up);
            }
            
            if(keyEvent.getCode().toString().equals("A"))
            {
                game.getCharacter().move(Direction.Left);
            }
            
            if(keyEvent.getCode().toString().equals("S"))
            {
                game.getCharacter().move(Direction.Down);
            }
            
            if(keyEvent.getCode().toString().equals("D"))
            {
                game.getCharacter().move(Direction.Right);
            }
            
            if(keyEvent.getCode().toString().equals("Q"))
            {
             classes.Character c= (classes.Character) game.getCharacter();
             c.createBallista(Direction.Right ,4 , 1);
               
            }
            
            if(keyEvent.getCode().toString().equals("E"))
            {
                classes.Character c= (classes.Character) game.getCharacter();
                c.createBallista(Direction.Up ,4 , 1);
            }
        });
     }
}
    
        

    @FXML
    public void Gameready() {
        //System.out.print("Add game code here");
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                javafx.application.Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(timercount--);
                        Countdown();

                        if (timercount == 0) {
                            timer.cancel();
                            timercount=  6;
                        }
                    }
                });
            }
        }, 0, 1000);
    }

        
   


    @Override
    public void update(Observable o, java.lang.Object o1) {
        InitCombos();
    }

    public void InitCombos() {
        this.LBSpectators.getItems().clear();
        this.LBPlayers.getItems().clear();

        for (User u : this.lobby.getPlayers()) {
            this.PlayerNames.add(u.toString());
        }

        for (User u : this.lobby.getSpectators()) {
            this.SpectatorNames.add(u.toString());
        }
        
        this.CBlevelsizeWidth.setItems(this.observableRoomsizewidth);
        this.CBlevelsizeHeight.setItems(this.observableRoomsizeheight);
        this.CBMinutes.setItems(this.observableTime);
        this.CBrounds.setItems(this.observableRounds);
        this.LBSpectators.setItems(FXCollections.observableList(this.SpectatorNames));
        this.LBPlayers.setItems(FXCollections.observableList(this.PlayerNames));
    }
}
