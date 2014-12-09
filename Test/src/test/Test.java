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
    private Timer timer;
    
    private Rectangle player;
    private Rectangle playerCopy;
    
    List<Rectangle> listCubes;
    List<Rectangle> listBoxes;
    
    @Override
    public void start(Stage primaryStage) throws Exception
    {     
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
        
        ScrollPane s1 = new ScrollPane();
        s1.setLayoutX(50);
        s1.setLayoutY(50);
        s1.setPrefSize(1600, 800);
        
        box = new AnchorPane();
        s1.setContent(box);
        
        field = new Rectangle(widthPixels, heightPixels);
        field.setFill(Color.PINK);
        //box.getChildren().add(field);        
        
        playfield = new Rectangle(100, 100, (widthCubes*100), (heightCubes*100));
        playfield.setFill(Color.WHITE);
        //box.getChildren().add(playfield);
        
        //player
        player = new Rectangle(100, (heightCubes*100), 100, 100);
        //player = new Rectangle(400, (heightCubes*100)-300, 100, 100);
        player.setFill(Color.YELLOW);
        //box.getChildren().add(player);
        
        /*for (Rectangle r : listCubes)
        {
            box.getChildren().add(r);
        }
        
        for (Rectangle b : listBoxes)
        {
            box.getChildren().add(b);
        }*/
        
        root.getChildren().add(s1);

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
        box.getChildren().clear();   
        Rectangle borderXleft = null;
        Rectangle borderXright = null;
        Rectangle borderYleft = null;
        Rectangle borderYright = null;
        
        System.out.println(player.getX() + ", " + player.getY());        
        
        //set range
        double range = 300;
        double fieldsize = (range*2)+100;
        
        //draw playfield
        Rectangle testfield = new Rectangle(0,0,fieldsize,fieldsize);
        testfield.setFill(Color.LIGHTBLUE);
        box.getChildren().add(testfield);
        
        //draw copy of player in range
        playerCopy = new Rectangle(player.getX(), player.getY(), 100, 100);
        playerCopy.setFill(player.getFill());
        playerCopy.setX(range);
        playerCopy.setY(range);
        box.getChildren().add(playerCopy);        
        
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
                box.getChildren().add(r2);
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
                box.getChildren().add(b2);
            }
        }
        
        //set gamefield border
        if (player.getX() <= range)
        {
            borderXleft = new Rectangle(0,0,range+100-player.getX(),fieldsize);
            borderXleft.setFill(Color.WHITE);
            box.getChildren().add(borderXleft);
        }
        
        if (player.getX() >= (widthCubes*100)-range+100)
        {            
            borderXright = new Rectangle(fieldsize-(range-((widthCubes*100)-player.getX())),0,range-((widthCubes*100)-player.getX()),fieldsize);
            borderXright.setFill(Color.WHITE);
            box.getChildren().add(borderXright);
        }
        
        if (player.getY() <= range)
        {
            borderYleft = new Rectangle(0,0,fieldsize,range+100-player.getY());
            borderYleft.setFill(Color.WHITE);
            box.getChildren().add(borderYleft);
        }
        
        if (player.getY() >= (heightCubes*100)-range+100)
        {
            borderYright = new Rectangle(0,fieldsize-(range-((widthCubes*100)-player.getY())),fieldsize,range-((widthCubes*100)-player.getY()));
            borderYright.setFill(Color.WHITE);
            box.getChildren().add(borderYright);
        }
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
