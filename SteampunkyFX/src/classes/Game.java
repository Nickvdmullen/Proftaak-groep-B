/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

import java.util.*;

/**
 * 
 * @author Melanie
 */
public class Game
{
    //************************datavelden*************************************
    private int heightPixels;
    private int heightCubes;
    private int widthPixels;
    private int widthCubes;
    
    private List<Position> grid;
    private int botDifficulty;
    private double timer;
    private double totalTime; //in seconds
    private int totalRounds;
    private int round;
    private List<Level> levels;
    private List<Object> objects;
    private boolean gameEnd;
    private Level currentLevel;

    //***********************constructoren***********************************
    /**
     * Constructor of Game
     * @param height uneven number of cubes, minimum of 9
     * @param width uneven number of cubes, minimum of 9
     * @param timelimit          The max amount of time a game can last.
     * @param botDifficulty      The difficulty of the bots.
     * @param rounds             The number of rounds that can be played.
     */
    public Game(int height, int width, double timelimit, int botDifficulty, int rounds)
    {
        if ((height%2 == 1 && width%2 == 1) && (height >= 9 && width >= 9))
        {
            this.heightCubes = height;
            this.heightPixels = (height * 100) + 200;
            this.widthCubes = width;
            this.widthPixels = (width * 100) + 200;
            this.objects = new ArrayList<>();
            
            this.botDifficulty = botDifficulty;
            this.totalTime = timelimit;
            this.timer = 0;
            this.totalRounds = rounds;
            this.round = 1;
            
            this.grid = new ArrayList<>();
            int row = 1;
            int col = 1;
            
            while (row <= this.widthCubes)
            {            
                col = 1;

                while (col <= this.heightCubes)
                {
                    Position p = new Position(col, row);
                    this.grid.add(p);
                    col ++;
                }

                row ++;
            }

            this.levels = new ArrayList<>();
            this.objects = new ArrayList<>();
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    //**********************methoden****************************************
    
    /**
     * gets a list of objects on the position with coordinates (x,y).
     * @param x the x coordinate of the position.
     * @param y the y coordinate of the position.
     * @return the list of objects on the position(x,y), if there are no objects returns null.
     */
    public List<Object> getObjectsFromGrid(int x, int y)
    {
        for (Position p : grid)
        {
            if(p.getX() == x && p.getY() == y)
            {
                return p.getObjects();
            }
        }
        
        return null;
    }
    
    /**
     * Getter of botDifficulty
     * @return  an int representing the difficulty level of the bots
     */
    public int getBotDifficulty()
    {
        return this.botDifficulty;
    }
    
    /**
     * Getter of TotalRounds
     * @return  an int with the amount of rounds
     */
    public int getTotalRounds()
    {
        return this.totalRounds;
    }
    
    /**
     * Getter of CurrentRound
     * @return  an int with the value of current round
     */
    public int getCurrentRound()
    {
        return this.round;
    }
    
    /**
     * Getter of TotalTime
     * @return   a double with the value of the maximum time per round
     */
    public double getTotalTime()
    {
        return this.totalTime;
    }
    
    /**
     * Getter of CurrentTime
     * @return   a double with the value of the remaining time left
     */
    public double getCurrentTime()
    {
        return this.timer;
    }
    
    /**
     * Getter of Characters
     * @return a list of objects with the type Character
     */
    public List<Object> getCharacters()
    {
        return this.objects;
    }
    
    /**
     * Getter of Levels
     * @return a list of Levels
     */
    public List<Level> getLevels()
    {
        return this.levels;
    }
    
    public Level getCurrentLevel()
    {
        return this.currentLevel;
    }
    
    public boolean getGameEnd()
    {
        return this.gameEnd;
    }
    
    /**
     * Setter of botDifficulty
     * @param difficulty    The difficuly of the bots
     * @return   a boolean whether raising or lowering difficulty was succesfull
     */
    public boolean setBotDifficulty(int difficulty)
    {
        this.botDifficulty = difficulty;
        
        //Check if this botDifficulty isn't to low or to high???
        return false;
    }    

    public void addLevel(Level level)
    {
        this.levels.add(level);
    }
    
    public void addObject(Object object)
    {
        this.objects.add(object);
    }
    
    public List<Object> getCubes()
    {
        //field op positie 200x200 pixels
        List<Object> cubes = new ArrayList<>();
        int row = 2;
        int col = 2;
        
        while (row < this.widthCubes)
        {
            col = 2;
            
            while (col < this.heightCubes)
            {
                Position p = new Position(col, row);
                Object ob = new Obstacle("cube", false, p, true, false);
                cubes.add(ob);
                col += 2;
            }
            
            row += 2;
        }
        
        return cubes;    
    }
    
    public List<Object> getBoxes()
    {
        List<Object> boxes = new ArrayList<>();
        int row = 1;
        int col = 1;
        
        //first boxes around player
        Position p = new Position(3, 1);
        Object ob = new Obstacle("box", false, p, true, false);
        boxes.add(ob);
        p = new Position(1, 3);
        ob = new Obstacle("box", false, p, true, false);
        boxes.add(ob);
        
        p = new Position(this.widthCubes - 2, 1);
        ob = new Obstacle("box", false, p, true, false);
        boxes.add(ob);
        p = new Position(this.widthCubes, 3);
        ob = new Obstacle("box", false, p, true, false);
        boxes.add(ob);
        
        p = new Position(1, this.heightCubes - 2);
        ob = new Obstacle("box", false, p, true, false);
        boxes.add(ob);
        p = new Position(3, this.heightCubes);
        ob = new Obstacle("box", false, p, true, false);
        boxes.add(ob);
        
        p = new Position(this.widthCubes - 2, this.heightCubes);
        ob = new Obstacle("box", false, p, true, false);
        boxes.add(ob);
        p = new Position(this.widthCubes, this.heightCubes - 2);
        ob = new Obstacle("box", false, p, true, false);
        boxes.add(ob);
        
        while (row <= this.widthCubes)
        {            
            col = 1;
            
            while (col <= this.heightCubes)
            {
                //can't place in the corners
                if (((row == 1 && col > 3 && col < (this.heightCubes -2)) ||
                        (row == 2 && col > 2 && col < (this.heightCubes -1)) ||
                        (row == 3 && col > 1 && col < this.heightCubes) ||
                        (row == (this.widthCubes - 2) && col > 1 && col < this.heightCubes) ||
                        (row == (this.widthCubes - 1) && col > 2 && col < (this.heightCubes -1)) ||
                        (row == this.widthCubes && col > 3 && col < (this.heightCubes -2)) || 
                        (row > 3 && row < (this.widthCubes -2))) &&
                        ((row%2 == 1 && col%2 == 0) || (row%2 == 0 && col%2 == 1) || (row%2 == 1 && col%2 == 1)))
                {
                    //place boxes random
                    if (getRandomBool(0.4))
                    {
                        p = new Position(col, row);
                        ob = new Obstacle("box", false, p, true, false);
                        boxes.add(ob);
                    }
                }
                
                col ++;
            }
            
            row ++;
        }
        
        return boxes;
    }
    
    public boolean getRandomBool(double perc)
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
    
    /**
     * Method to set and object into the grid
     * @param object    object to be put into the grid
     */
    public void setObjectInGrid(Object object)
    {
        for (Position p : this.grid)
        {
            if (p.getX() == object.getPositionX() && p.getY() == object.getPositionY())
            {
                p.addObject(object);
            }
        }
    }
    
    public void setGameEnd(boolean isEnded)
    {
        if (isEnded)
        {
            this.gameEnd = true;
            
            //Ga naar de volgende ronde mits die er is
            if (this.round < this.totalRounds)
            {               
                this.round++;
                startRound();
            }
        }
    }
    
    public void startRound()
    {
        /**
         * this creates positions and puts them in the grid.
         */
        for (Position p : this.grid)
        {
            p.clearAllObjects();
        }
        
        setupLevel();
    }
    
    public void setupLevel()
    {
        this.objects.addAll(this.getBoxes());
        this.objects.addAll(this.getCubes());
        
        for (Object o : this.objects)
        {
            this.setObjectInGrid(o);
        }
    }
}
