package test;


import java.util.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Melanie
 */
public class Game
{
    private int heightPixels;
    private int heightCubes;
    private int widthPixels;
    private int widthCubes;
    private List<Object> objects;
    
    /**
     * Make game with height and width
     * Height and width in cubes extends border, only playable field
     * Height and width in pixels includes border
     * 
     * @param height uneven number of cubes, minimum of 9, maximum of 19
     * @param width uneven number of cubes, minimum of 9, maximum of 19
     */
    public Game(int height, int width)
    {
        if ((height%2 == 1 && width%2 == 1) && (height >= 9 && width >= 9))
        {
            this.heightCubes = height;
            this.heightPixels = (height * 100) + 200;
            this.widthCubes = width;
            this.widthPixels = (width * 100) + 200;
            this.objects = new ArrayList<>();
        }
        else
        {
            throw new IllegalArgumentException();
        }        
    }
    
    public int getHeightPixels()
    {
        return this.heightPixels;
    }
    
    public int getHeightCubes()
    {
        return this.heightCubes;
    }
    
    public int getWidthPixels()
    {
        return this.widthPixels;
    }
    
    public int getWidthCubes()
    {
        return this.widthCubes;
    }
    
    public List<Object> getObjects()
    {
        return this.objects;
    }
    
    public List<Rectangle> getCubes()
    {
        //field op positie 200x200 pixels
        List<Rectangle> cubes = new ArrayList<>();
        int row = 2;
        int col = 2;
        
        while (row < this.widthCubes)
        {
            col = 2;
            
            while (col < this.heightCubes)
            {
                Rectangle rec = new Rectangle(((col*100)), ((row*100)), 100, 100);
                rec.setFill(Color.BLACK);
                cubes.add(rec);
                col += 2;
            }
            
            row += 2;
        }
        
        return cubes;    
    }
    
    public void addObject(Object object)
    {
        this.objects.add(object);
    }
}
