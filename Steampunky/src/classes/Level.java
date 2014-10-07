/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

/**
 * OK
 * @author Melanie
 */
public class Level
{
     //************************datavelden*************************************
    private int levelID;
    private int nextLevelID = 1;
    private int height;
    private int width;
    private String texture;
    private String name;

    //***********************constructoren***********************************
    /**
     * creates a level with height, width, texture and name
     */
    public Level(int height, int width, String texture, String name)
    {
        this.height = height;
        this.width = width;
        this.texture = texture;
        this.name = name;
        
        this.levelID = this.nextLevelID;
        this.nextLevelID++;
    }

    //**********************methoden****************************************
    public int getLevelID()
    {
        return this.levelID;
    }
    
    public int getHeight()
    {
        return this.height;
    }
    
    public int getWidth()
    {
        return this.width;
    }
    
    public String getTexture()
    {
        return this.texture;
    }
    
    public String getName()
    {
        return this.name;
    }
}
