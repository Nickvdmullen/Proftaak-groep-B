package test;


import java.awt.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Melanie
 */
public class Manager
{
    private Game game;
    private Object cube1 = new Cube(1, 1, 100, 100, Color.BLUE);
    private Object cube2 = new Cube(1, 1, 100, 100, Color.RED);
    
    public Manager(Game game)
    {
        //this.game = game;
        this.game = new Game(9, 9);
    }
    
    public void setUp()
    {
        this.game.addObject(cube1);
        this.game.addObject(cube2);
    }
    
    public Game getGame()
    {
        return this.game;
    }
}
