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
        
        while (row < this.heightCubes)
        {
            col = 2;
            
            while (col < this.widthCubes)
            {
                Rectangle rec = new Rectangle((col*100), (row*100), 100, 100);
                rec.setFill(Color.BLACK);
                cubes.add(rec);
                col += 2;
            }
            
            row += 2;
        }
        
        return cubes;    
    }
    
    public List<Rectangle> getBoxes()
    {
        List<Rectangle> boxes = new ArrayList<>();
        int row = 1;
        int col = 1;
        
        //bigger field means more cubes
        double perc = 0.4;
            if(this.heightCubes >15 ||this.widthCubes > 15)
            {
                perc = 0.5;
            }
        
        //first boxes around player
        Rectangle rec = new Rectangle((3*100), (1*100), 100, 100);
        boxes.add(rec);
        rec = new Rectangle((1*100), (3*100), 100, 100);
        boxes.add(rec);
        
        rec = new Rectangle(((this.widthCubes - 2)*100), (1*100), 100, 100);
        boxes.add(rec);
        rec = new Rectangle((this.widthCubes*100), (3*100), 100, 100);
        boxes.add(rec);
        
        rec = new Rectangle((1*100), ((this.heightCubes - 2)*100), 100, 100);
        boxes.add(rec);
        rec = new Rectangle((3*100), (this.heightCubes*100), 100, 100);
        boxes.add(rec);
        
        rec = new Rectangle(((this.widthCubes - 2)*100), (this.heightCubes*100), 100, 100);
        boxes.add(rec);
        rec = new Rectangle((this.widthCubes*100), ((this.heightCubes - 2)*100), 100, 100);
        boxes.add(rec);
        
        while (row <= this.heightCubes)
        {            
            col = 1;
            
            while (col <= this.widthCubes)
            {
                //can't place in the corners
                if (((row == 1 && col > 3 && col < (this.widthCubes -2)) ||
                        (row == 2 && col > 2 && col < (this.widthCubes -1)) ||
                        (row == 3 && col > 1 && col < this.widthCubes) ||
                        (row == (this.heightCubes - 2) && col > 1 && col < this.widthCubes) ||
                        (row == (this.heightCubes - 1) && col > 2 && col < (this.widthCubes -1)) ||
                        (row == this.heightCubes && col > 3 && col < (this.widthCubes -2)) || 
                        (row > 3 && row < (this.heightCubes -2))) &&
                        ((row%2 == 1 && col%2 == 0) || (row%2 == 0 && col%2 == 1) || (row%2 == 1 && col%2 == 1)))
                {
                    //place boxes random
                    if (getRandomBool(perc))
                    {
                        rec = new Rectangle((col*100), (row*100), 100, 100);
                        boxes.add(rec); 
                    }
                }
                
                col ++;
            }
            
            row ++;
        }
        
        for (Rectangle a : boxes)
        {
            a.setFill(Color.BROWN);
            a.setStroke(Color.RED);
            a.setStrokeWidth(2);
        }
        
        return boxes;
    }
    
    public void addObject(Object object)
    {
        this.objects.add(object);
    }
    
    public boolean getRandomBool(double perc)
    {
        if(perc>0 && perc <1)
        {
            Random r = new Random();
            double b = r.nextDouble();
        
            if (b <= perc)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }
}
