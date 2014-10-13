package test;


import java.awt.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Melanie
 */
public class Cube extends Object
{
    private int height;
    private int width;
    private Color color;

    public Cube(int posX, int posY, int height, int width, Color color)
    {
        super(posX, posY);
        this.height = height;
        this.width = width;
        this.color = color;
    }
}
