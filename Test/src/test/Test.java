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
    private Manager manager;
    private Rectangle field;
    private Rectangle playfield;
    private int maxX = 1700;
    private int widthPixels;
    private int widthCubes;
    private int maxY = 900;
    private int heightPixels;
    private int heightCubes;
    
    @Override
    public void start(Stage primaryStage) throws Exception
    {     
        gotoLobbyselect(primaryStage, new Game(19, 19));
    }
    
    protected void gotoLobbyselect(Stage primaryStage, Game game){
        //Get game
        //game = new Game(9, 9);
        game = new Game(19, 19);
        manager = new Manager(game);
        widthPixels = game.getWidthPixels();
        widthCubes = game.getWidthCubes();
        heightPixels = game.getHeightPixels();
        heightCubes = game.getHeightCubes();
        
        //Create the scene
        Group root = new Group();
        Scene scene = new Scene(root, maxX, maxY);
        
        ScrollPane s1 = new ScrollPane();
        s1.setLayoutX(50);
        s1.setLayoutY(50);
        s1.setPrefSize(1600, 800);
        
        AnchorPane box = new AnchorPane();
        s1.setContent(box);
        
        field = new Rectangle(widthPixels, heightPixels);
        field.setFill(Color.PINK);
        box.getChildren().add(field);        
        
        playfield = new Rectangle(100, 100, (widthCubes*100), (heightCubes*100));
        playfield.setFill(Color.WHITE);
        box.getChildren().add(playfield);
        
        List<Rectangle> listCubes = game.getCubes();
        for (Rectangle r : listCubes)
        {
            box.getChildren().add(r);
        }
        
        List<Rectangle> listBoxes = game.getBoxes();
        for (Rectangle b : listBoxes)
        {
            box.getChildren().add(b);
        }
        
        root.getChildren().add(s1);

        // Define title and assign the scene for main window
        primaryStage.setTitle("Game test");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        scene.setOnKeyPressed((KeyEvent keyEvent) -> {
            if(keyEvent.getCode().toString().equals("W"))
            {
                // move character up. Calls playerCharacter.Move(Direction.UP)
            }
            
            if(keyEvent.getCode().toString().equals("A"))
            {
                // move character left Calls playerCharacter.Move(Direction.LEFT)
            }
            
            if(keyEvent.getCode().toString().equals("S"))
            {
                // move character down Calls playerCharacter.Move(Direction.DOWN)
            }
            
            if(keyEvent.getCode().toString().equals("D"))
            {
                // move character right Calls playerCharacter.Move(Direction.RIGHT)
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
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
}
