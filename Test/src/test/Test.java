/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.input.*;
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
    private TextField text1;
    private TextField text2;
    private int maxX = 1000;
    private int width;
    private int maxY = 600;
    private int height;
    
    @Override
    public void start(Stage primaryStage) throws Exception
    {     
        //Get game
        /*manager = new Manager(null);
        Game game = manager.getGame();
        width = game.getWidthPixels();
        height = game.getHeightPixels();*/
        width = 900;
        height = 500;
        
        //Create the scene
        Group root = new Group();
        Scene scene = new Scene(root, maxX, maxY);

        //Indicate Level
        text1 = new TextField("Width");
        text1.setLayoutX(10);
        text1.setLayoutY(10);
        root.getChildren().add(text1);
        
        text2 = new TextField("Height");
        text2.setLayoutX(210);
        text2.setLayoutY(10);
        root.getChildren().add(text2);
        
        Button but1 = new Button("Draw");
        but1.setLayoutX(410);
        but1.setLayoutY(10);
        but1.addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        width = Integer.parseInt(text1.getText());
                        height = Integer.parseInt(text2.getText());
                    }
                });
        root.getChildren().add(but1);
        
        /*ScrollBar s1 = new ScrollBar();
        s1.setOrientation(Orientation.VERTICAL);
        ScrollBar s2 = new ScrollBar();
        s2.setOrientation(Orientation.VERTICAL);*/ 
        
        //Rectangle(posX, posY, width, height)
        field = new Rectangle(50, 50, width, height);
        field.setFill(Color.LIGHTYELLOW);
        root.getChildren().add(field);

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
        field.setWidth(width);
        field.setHeight(height);
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
