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
    private Thread threadDraw;
    private Manager manager;
    private Rectangle field;
    private Rectangle playfield;
    private TextField text1;
    private TextField text2;
    private int maxX = 1860;
    private int widthPixels;
    private int widthCubes;
    private int maxY = 960;
    private int heightPixels;
    private int heightCubes;
    
    @Override
    public void start(Stage primaryStage) throws Exception
    {     
        //Get game
        Game game = new Game(9, 9);
        //Game game = new Game(19, 19);
        manager = new Manager(game);
        widthPixels = game.getWidthPixels();
        widthCubes = game.getWidthCubes();
        heightPixels = game.getHeightPixels();
        heightCubes = game.getHeightCubes();
        
        //Create the scene
        Group root = new Group();
        Scene scene = new Scene(root, maxX, maxY);

        //Indicate Form
        text1 = new TextField("Width");
        text1.setLayoutX(10);
        text1.setLayoutY(10);
        text1.setText(String.valueOf(widthPixels));
        root.getChildren().add(text1);
        
        text2 = new TextField("Height");
        text2.setLayoutX(210);
        text2.setLayoutY(10);
        text2.setText(String.valueOf(heightPixels));
        root.getChildren().add(text2);
        
        Button but1 = new Button("Draw");
        but1.setLayoutX(410);
        but1.setLayoutY(10);
        but1.addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        widthPixels = Integer.parseInt(text1.getText());
                        heightPixels = Integer.parseInt(text2.getText());
                    }
                });
        root.getChildren().add(but1);
        
        /*ScrollBar s1 = new ScrollBar();
        s1.setOrientation(Orientation.VERTICAL);
        s1.setLayoutX(maxX - 20);
        s1.setMax(maxY);
        root.getChildren().add(s1);
        
        ScrollBar s2 = new ScrollBar();
        s2.setOrientation(Orientation.HORIZONTAL);
        s2.setLayoutY(maxY - 20);
        s2.setMax(maxX);
        root.getChildren().add(s2);*/
        
        //Indicate level        
        
        //root.getChildren().add(field);
        
        ScrollPane s1 = new ScrollPane();
        s1.setLayoutX(100);
        s1.setLayoutY(100);
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
        
        root.getChildren().add(s1);

        // Define title and assign the scene for main window
        primaryStage.setTitle("Game test");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Start thread to draw each 20 ms
        threadDraw = new Thread(new DrawRunnable());
        threadDraw.start();        
    }
    
    private void update()
    {
        field.setWidth(widthPixels);
        field.setHeight(heightPixels);
    }
    
    @Override
    public void stop()
    {
        threadDraw.interrupt();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
    
    // Update circles each 20 ms
    private class DrawRunnable implements Runnable
    {
        @Override
        public void run()
        {
            try
            {
                while (true)
                {
                    Thread.sleep(20);
                    Platform.runLater(new Runnable(){
                        @Override
                        public void run() {
                            update();
                        }
                    });
                }
            } 
            catch (InterruptedException ex)
            {  
            }
        }
    }
}
