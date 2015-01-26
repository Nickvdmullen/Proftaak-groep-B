/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.awt.Scrollbar;
import java.util.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.stage.*;

/**
 *
 * @author Melanie
 */
public class Test extends Application
{
    private Game game;
    private Rectangle field;
    private Rectangle playfield;
    private int maxX = 1700;
    private int widthPixels;
    private int widthCubes;
    private int maxY = 900;
    private int heightPixels;
    private int heightCubes;
    private AnchorPane box;
    private AnchorPane canvas;
    private Timer timer;
    
    private Rectangle player;
    private Rectangle playerCopy;
    
    List<Rectangle> listCubes;
    List<Rectangle> listBoxes;
    
    private int viewport;
    
    @Override
    public void start(Stage primaryStage) throws Exception
    {    
        viewport = 4;
        
        gotoLobbyselect(primaryStage);
        
        this.timer = new Timer();
        this.timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                javafx.application.Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        updateGame();
                    }
                });
            }
        }, 0, 1000);
    }
    
    protected void gotoLobbyselect(Stage primaryStage)
    {
        //Get game
        game = new Game(9,9);
        widthPixels = game.getWidthPixels();
        widthCubes = game.getWidthCubes();
        heightPixels = game.getHeightPixels();
        heightCubes = game.getHeightCubes();
        
        listCubes = game.getCubes();
        listBoxes = game.getBoxes();
        
        //Create the scene
        Group root = new Group();
        Scene scene = new Scene(root, maxX, maxY);
        
        //ScrollPane s1 = new ScrollPane();
        //s1.setLayoutX(50);
        //s1.setLayoutY(50);
        //s1.setPrefSize(1600, 800);
        
        box = new AnchorPane();
        box.setLayoutX(50);
        box.setLayoutY(50);
        box.setPrefSize(1600, 800);
        //s1.setContent(box);
        
        canvas = new AnchorPane();
        box.getChildren().add(canvas);
        
        field = new Rectangle(widthPixels, heightPixels);
        field.setFill(Color.PINK);       
        
        playfield = new Rectangle(100, 100, (widthCubes*100), (heightCubes*100));
        playfield.setFill(Color.WHITE);
        
        //player
        player = new Rectangle(100, (heightCubes*100), 100, 100);
        player.setFill(Color.YELLOW);
        
        root.getChildren().add(box);

        // Define title and assign the scene for main window
        primaryStage.setTitle("Game test");
        primaryStage.setScene(scene);
        primaryStage.show();        
        
        scene.setOnKeyPressed((KeyEvent keyEvent) -> {
            if(keyEvent.getCode().toString().equals("W"))
            {
                // move character up. Calls playerCharacter.Move(Direction.UP)
                double newY = player.getY() - 100;
                
                if (newY >= 100)
                {
                    player.setY(newY);
                }
            }
            
            if(keyEvent.getCode().toString().equals("A"))
            {
                // move character left Calls playerCharacter.Move(Direction.LEFT)
                double newX = player.getX() - 100;
                
                if (newX >= 100)
                {
                    player.setX(newX);
                }
            }
            
            if(keyEvent.getCode().toString().equals("S"))
            {
                // move character down Calls playerCharacter.Move(Direction.DOWN)
                double newY = player.getY() + 100;
                
                if (newY <= (heightCubes*100))
                {
                    player.setY(newY);
                }
            }
            
            if(keyEvent.getCode().toString().equals("D"))
            {
                // move character right Calls playerCharacter.Move(Direction.RIGHT)
                double newX = player.getX() + 100;
                
                if (newX <= (widthCubes*100))
                {
                    player.setX(newX);
                }
            }
            
            if(keyEvent.getCode().toString().equals("Q"))
            {
                // put ballista down and shoots left/right first Calls playerCharacter.createBallista(Direction.UP,4,1)
            }
            
            if(keyEvent.getCode().toString().equals("E"))
            {
                // put ballista down and shoots up/down first.Calls playerCharacter.createBallista(Direction.RIGHT,4,1)
            }
        });
    }
    
    public void updateGame()
    {
        canvas.getChildren().clear();   
        Rectangle borderXleft = null;
        Rectangle borderXright = null;
        Rectangle borderYtop = null;
        Rectangle borderYbottom = null;
        
        System.out.println(player.getX() + ", " + player.getY());        
        
        //set range
        double maxrange = 5 * 100;
        double range = viewport * 100;        
        double maxfieldsize = 1100;
        double fieldsize = (range*2)+100;
        
        //draw playfield
        Rectangle backfield = new Rectangle(0,0,maxfieldsize,maxfieldsize);
        backfield.setFill(Color.BLACK);
        canvas.getChildren().add(backfield);
        
        Rectangle testfield = new Rectangle(maxrange-range,maxrange-range,fieldsize,fieldsize);
        testfield.setFill(Color.LIGHTBLUE);
        canvas.getChildren().add(testfield);
        
        //draw copy of player in range
        playerCopy = new Rectangle(player.getX(), player.getY(), 100, 100);
        playerCopy.setFill(player.getFill());
        playerCopy.setX(maxrange);
        playerCopy.setY(maxrange);
        canvas.getChildren().add(playerCopy);        
        
        //get min and max values
        double minX = player.getX() - range;
        double maxX = player.getX() + range;
        double minY = player.getY() - range;
        double maxY = player.getY() + range;
        
        //draw cubes in range
        for (Rectangle r : listCubes)
        {
            double rX = r.getX();
            double rY = r.getY();
                
            if (rX >= minX && rX <= maxX && rY >= minY && rY <= maxY)
            {                
                double changeX = rX - player.getX();
                double changeY = rY - player.getY();
                Rectangle r2 = new Rectangle(playerCopy.getX() + changeX, playerCopy.getY() + changeY, 100, 100);
                r2.setFill(r.getFill());
                canvas.getChildren().add(r2);
            }
        }
        
        //draw boxes in range
        for (Rectangle b : listBoxes)
        {
            double bX = b.getX();
            double bY = b.getY();
            
            if (bX >= minX && bX <= maxX && bY >= minY && bY <= maxY)
            {                
                double changeX = bX - player.getX();
                double changeY = bY - player.getY();
                Rectangle b2 = new Rectangle(playerCopy.getX() + changeX, playerCopy.getY() + changeY, 100, 100);
                b2.setFill(b.getFill());
                canvas.getChildren().add(b2);
            }
        }        
        
        double var1 = maxrange-range;        
        double var2 = (widthCubes*100)-player.getX();
        double var3 = (heightCubes*100)-player.getY();
        
        //set gamefield border
        if (player.getX() <= range)
        {
            borderXleft = new Rectangle(var1,var1,range+100-player.getX(),fieldsize);
            borderXleft.setFill(Color.WHITE);
            canvas.getChildren().add(borderXleft);
        }
        
        if (player.getX() >= (widthCubes*100)-range+100)
        {            
            borderXright = new Rectangle(range+var1+var2+100,var1,range-((widthCubes*100)-player.getX()),fieldsize);
            borderXright.setFill(Color.WHITE);
            canvas.getChildren().add(borderXright);
        }
        
        if (player.getY() <= range)
        {
            borderYtop = new Rectangle(var1,var1,fieldsize,range+100-player.getY());
            borderYtop.setFill(Color.WHITE);
            canvas.getChildren().add(borderYtop);
        }
        
        if (player.getY() >= (heightCubes*100)-range+100)
        {
            borderYbottom = new Rectangle(var1,range+var1+var3+100,fieldsize,range-var3);
            borderYbottom.setFill(Color.WHITE);
            canvas.getChildren().add(borderYbottom);
        }
        
        //canvas.setRotate(90);
        canvas.setScaleX(0.7);
        canvas.setScaleY(0.7);
        canvas.setMaxSize(1100, 1100);
        canvas.setLayoutX(-150);
        canvas.setLayoutY(-150);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
    
    @Override
    public void stop()
    {
        timer.cancel();
    }
}
