package test;


import java.util.*;

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
     * @param height uneven number of cubes, minimum of 9
     * @param width uneven number of cubes, minimum of 9
     */
    public Game(int height, int width)
    {
        if ((height%2 == 0 && width%2 == 0) && (height >= 9 && width >= 9))
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
    
    public int getWidthPixels()
    {
        return this.widthPixels;
    }
    
    public List<Object> getObjects()
    {
        return this.objects;
    }
    
    public void addObject(Object object)
    {
        this.objects.add(object);
    }
}
