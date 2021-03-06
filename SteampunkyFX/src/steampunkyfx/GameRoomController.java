/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steampunkyfx;

import classes.Character;
import classes.Direction;
import classes.Game;
import classes.Lobby;
import classes.Object;
import classes.Position;
import classes.Projectile;
import classes.Server;
import static classes.Server.getServer;
import classes.User;
import images.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Bart
 */
public class GameRoomController implements Initializable, Observer {

    //JAVAFX CONTROLS
    @FXML private Font x1;
    @FXML private Button BTSpectator;
    @FXML private Button BTPlayer;
    @FXML private Button BTReturn;
    @FXML private Button BTstop;
    @FXML private Button BTReady;
    @FXML private Label LBLusername;
    @FXML private Label LBLRemaining;
    @FXML private Label LBLGameState;
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

    //JAVAFX referenties / mee gegeven objecten van andere forums
    private Lobby lobby;
    private Server server;
    private SteampunkyFX main;
    private User admin;
    private Stage stage;
    
    //Game refereantie met game eigenschappen
    private Game game;
    private int widthPixels;
    private int widthCubes;
    private int heightPixels;
    private int heightCubes;
    private ImageSelector selector;
    private Group root;
    private ScrollPane s1;
    private AnchorPane box;
    private Rectangle field;
    private Rectangle playfield;
    private List<Object> objects;

    //Listen die nodig zijn voor de gui te updaten
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
    
    //Classe variable plus timer instantie
    private Timer timer;
    private Timer gameTickTimer;
    private int timercount = 6;
    private int countdown = 6;
    private int slotsleft = 4;
    
    private int level = 0;
    
    private int character;

    public void setApp(SteampunkyFX application, User admin, Lobby lobby, Stage stage) {
        this.stage = stage;
        this.main = application;
        this.admin = admin;
        this.lobby = lobby;
        this.lobby.addObserver(this);
        this.game = null;
        this.selector = new ImageSelector();

        this.LBLusername.setText("Welcome: " + admin.getUsername());
        this.LBLRemaining.setText("Remaining slots: " + this.slotsleft);
        this.BTReady.setDisable(true);
        this.BTSpectator.setDisable(true);

        this.LBLsize.setDisable(true);
        this.LBLHeight.setDisable(true);
        this.LBLWidth.setDisable(true);
        this.LBLTime.setDisable(true);
        this.LBLRound.setDisable(true);
        this.CBlevelsizeHeight.setDisable(true);
        this.CBlevelsizeWidth.setDisable(true);
        this.CBMinutes.setDisable(true);
        this.CBrounds.setDisable(true);
        this.BTstop.setDisable(true);

        //add level size 
        observableRounds = observableList(this.Rounds);
        observableTime = observableList(this.Time);
        observableRoomsizewidth = observableList(this.Roomsizewidth);
        observableRoomsizeheight = observableList(this.Roomsizeheight);

        //vult de ronde en game comboboxen
        for (int TimeRound = 1; TimeRound < 5; TimeRound++) {
            String temp = "" + TimeRound;
            observableRounds.add(temp);
            observableTime.add(temp);
        }

        // vult de hoogte en breedte lijst van het speelveld in de combobox
        for (int widthheight = 9; widthheight < 20; widthheight++) {
            if (widthheight % 2 != 0) {
                String temp = "" + widthheight;
                observableRoomsizewidth.add(temp);
                observableRoomsizeheight.add(temp);
            }
        }

        //Vult de comboboxen bij load en standaard waarde instellen
        InitCombos();
        this.CBMinutes.getSelectionModel().select(0);
        this.CBrounds.getSelectionModel().select(0);
        this.CBlevelsizeWidth.getSelectionModel().select(0);
        this.CBlevelsizeHeight.getSelectionModel().select(0);

        //Kijkt of de ingelogde speler een admin is
        for (User u : lobby.getSpectators()) {
            if (u == admin) {
                this.LBLsize.setDisable(false);
                this.LBLHeight.setDisable(false);
                this.LBLWidth.setDisable(false);
                this.LBLTime.setDisable(false);
                this.LBLRound.setDisable(false);
                this.CBlevelsizeHeight.setDisable(false);
                this.CBlevelsizeWidth.setDisable(false);
                this.CBMinutes.setDisable(false);
                this.CBrounds.setDisable(false);
            }
        }
    }

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

    //Methode die er voor zorgt dat een speler een spectator wordt
    @FXML
    public void becomeSpectator() {
        this.lobby.clearSlot(this.admin);
        this.slotsleft++;
        this.LBLRemaining.setText("Remaining slots: " + this.slotsleft);
        this.BTReady.setDisable(true);
        this.BTPlayer.setDisable(false);
        this.BTSpectator.setDisable(true);
    }

    //Methode die er voor zorgt dat een speler een player wordt
    @FXML
    public void becomePlayer() {
        lobby.assignSlot(this.admin);
        this.slotsleft--;
        this.BTReady.setDisable(false);
        this.BTPlayer.setDisable(true);
        this.BTSpectator.setDisable(false);
        this.LBLRemaining.setText("Remaining slots: " + this.slotsleft);
    }

    //Methode die de van de gameroom terug gaat naar de lobby
    @FXML
    public void ReturnToMenu() {
        this.main.gotoLobbyselect(admin);
    }
    
    //Stopt het starten van de game als op readt is geklikt
    @FXML
    public void StopGame() {
        this.timer.cancel(); 
        this.timercount = 6;
        this.countdown = 6;
        this.LBLGameState.setText("Waiting for players");
        this.BTstop.setDisable(true);
        this.BTReady.setDisable(false);
    }
    
    public void SetupStage(){
            this.field = new Rectangle(this.widthPixels*this.getScale(), this.heightPixels*this.getScale());
            this.field.setFill(Color.GRAY);  
            box.getChildren().add(this.field);   
    }
    //Start de game als de teller op 0 komt wordt het speel veld geladen
    public void Countdown() {
        this.countdown--;
        String number = "Game wil start in: " + this.countdown;
        this.LBLGameState.setText(number);

        if (this.countdown == 0) 
        {
            //get random level from 1 to 3
            Random levelInt = new Random();
            level = levelInt.nextInt(3) + 1;
            
            this.SetupDraw();
            this.setKeyBindings();
            this.game.addPlayer(this.admin);
            this.game.startRound();
        }
    }
    //clears the scene and draws new boxes for every object.
    public void DrawGame()
    { 
        box.getChildren().clear();
        
        switch (level)
        {
            case 1:
                this.field.setFill(Color.SADDLEBROWN);
                this.playfield.setFill(Color.BURLYWOOD);
                break;
            case 2:
                this.field.setFill(Color.DIMGRAY);
                this.playfield.setFill(Color.LIGHTGRAY);
                break;
            case 3:
                this.field.setFill(Color.PERU);
                this.playfield.setFill(Color.BEIGE);
                break;
        }
        
        box.getChildren().add(this.field);
        box.getChildren().add(this.playfield);
         
        for (Position p : this.game.getGrid())
        {
            objects = p.getObjects();

            for (Object object : objects)
            {   
                Image image = null;
                ImageView img = null; 

                try
                {
                    //level nog niet geimplementeerd
                    image = selector.getImage(object, level);
                    img = new ImageView(image);
                    img.setScaleX(this.getScale());
                    img.setScaleY(this.getScale());
                    img.setX((p.getX()*100*this.getScale()) + (-50 * (1-this.getScale())));
                    img.setY((p.getY()*100*this.getScale()) + (-50 * (1-this.getScale())));  
                    
                    if (object instanceof Projectile || object.equals(this.game.getCharacter()))
                    {
                        img.setRotate(getRotation(object));
                    }
                    else
                    {
                        img.setRotate(0);
                    }
                    
                    box.getChildren().add(img);
                }
                catch (Exception ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
    
    public double getRotation(Object o)
    {
        double rotation = 0;

        switch(o.getDirection())
        {
            case Up:
                rotation = 0;
                break;
            case Right:
                rotation = 90;
                break;
            case Down:
                rotation = 180;
                break;
            case Left:
                rotation = 270;
                break; 
        }
        
        return rotation;
    }
    
    //Sets up the settings needed to draw.
    public void SetupDraw(){
        
        //Teken code hier aan toevoegen
        int width = Integer.parseInt(this.CBlevelsizeWidth.getValue().toString());
        int height = Integer.parseInt(this.CBlevelsizeHeight.getValue().toString());

        double time = Integer.parseInt(this.CBMinutes.getValue().toString()) * 60;
        int botdif = 1; //afhankelijk van level spelers, nog niet geimplementeerd
        int rounds = Integer.parseInt(this.CBrounds.getValue().toString());

        this.game = new Game(width, height, time, botdif, rounds);
        this.widthPixels = this.game.getWidthPixels();
        this.widthCubes = this.game.getWidthCubes();
        this.heightPixels = this.game.getHeightPixels();
        this.heightCubes = this.game.getHeightCubes();

        root = new Group();
        Scene scene = new Scene(root, 1700, 900);

        s1 = new ScrollPane();
        s1.setLayoutX(50);
        s1.setLayoutY(50);
        s1.setPrefSize(1600, 800);

        box = new AnchorPane();
        s1.setContent(box);
        
        this.field = new Rectangle(this.widthPixels*this.getScale(), this.heightPixels*this.getScale());
        this.field.setFill(Color.GRAY);      

        this.playfield = new Rectangle(100*this.getScale(), 100*this.getScale(), (this.widthCubes*100*this.getScale()), (this.heightCubes*100*this.getScale()));
        this.playfield.setFill(Color.WHITE);        
        
        root.getChildren().add(s1);
        this.stage.setMinHeight(900);
        this.stage.setMinWidth(1700);
        this.stage.setScene(scene);
    }
    
    //Set the keybindings for this Scene
    public void setKeyBindings(){
        this.stage.getScene().setOnKeyPressed((KeyEvent keyEvent) -> {
            if(keyEvent.getCode().toString().equals("W"))
            {
                this.game.getCharacter().move(Direction.Up);             
            }
            
            if(keyEvent.getCode().toString().equals("A"))
            {
                this.game.getCharacter().move(Direction.Left);               
            }
            
            if(keyEvent.getCode().toString().equals("S"))
            {
                this.game.getCharacter().move(Direction.Down);
            }
            
            if(keyEvent.getCode().toString().equals("D"))
            {
                this.game.getCharacter().move(Direction.Right);
            }
            
            if(keyEvent.getCode().toString().equals("Q"))
            {
                Character c = (classes.Character) game.getCharacter();
                c.createBallista(Direction.Right , 1);
            }
            
            if(keyEvent.getCode().toString().equals("E"))
            {
                Character c = (classes.Character) game.getCharacter();
                c.createBallista(Direction.Up , 1);
            }            
        });
    }
    
    //Zodra er op ready wordt geklikt start de timer die aftelt tot de game start
    @FXML
    public void Gameready() {
        this.timer = new Timer();
        this.BTstop.setDisable(false);
        this.BTReady.setDisable(true);
        this.timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                javafx.application.Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Countdown();

                        if (countdown == 0){
                            timer.cancel();
                        }
                    }
                });
            }
        }, 0, 1000);
        GameUpdate();
    }

    public void GameUpdate()
    {
        this.gameTickTimer = new Timer();        
        
        this.gameTickTimer.scheduleAtFixedRate(new TimerTask()
        {            
            @Override
            public void run()
            {
                javafx.application.Platform.runLater(() -> 
                {
                    try
                    {
                        if(game.getGameEnd())
                        {
                            gameTickTimer.cancel();
                        }
                        
                        game.updateGame();
                        DrawGame();
                    }
                    catch(NullPointerException ex)
                    {                    
                    }                    
                });                
            }           
        },200,200);
        main.gotoLobbyselect(admin);
    }
    
    public double getScale()
    {
        double scale = 1;
        
        //check scale for admin
        /*for (String name : this.PlayerNames)
        {
            if (name.equals(this.admin.getUsername()))
            {
                scale = 1;
            }
        }
        
        for (String name : this.SpectatorNames)
        {
            if (name.equals(this.admin.getUsername()))
            {*/
                double hoogteScherm = 800;
                double hoogteSpel = game.getHeightPixels();                
                scale = hoogteScherm/hoogteSpel;
            /*}
        }*/
        
        return scale;
    }
    
    //Update methode als er iets wordt geupdate in een lijst dan worde de methode InitCombos aangeroepen
    @Override
    public void update(Observable o, java.lang.Object o1) {
        InitCombos();
    }

    //Initialiseert de combo boxen
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
