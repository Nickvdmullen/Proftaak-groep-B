/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.*;

/**
 * OK
 * <p>
 * @author Melanie
 */
public class Bot {

    //************************datavelden*************************************
    private int botID;
    private int nextBotID = 1;
    private String name;
    private int difficulty;
    private Character character;
    private Game game;

    //***********************constructoren***********************************
    /**
     * Constructor of this class
     * <p>
     * @param name The name of the Bot
     * @param difficulty The difficulty of the bot
     */
    public Bot(String name, int difficulty, Game game) {
        this.name = name;
        this.difficulty = difficulty;
        this.botID = this.nextBotID;
        this.nextBotID++;
        this.game = game;
    }

    //**********************methoden****************************************
    /**
     * The getter of BotID
     * <p>
     * @return an int with the botID
     */
    public int getBotID() {
        return this.botID;
    }

    /**
     * Getter of name
     * <p>
     * @return a String with the name of the bot
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter of the Difficulty of the bot
     * <p>
     * @return the difficulty of the bot
     */
    public int getDifficulty() {
        return this.difficulty;
    }

    public Character getCharacter() {
        return this.character;
    }

    /**
     * The setter of the difficulty
     * <p>
     * @param difficulty an int with the new difficulty
     */
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public void AI() {
        int X = this.character.getPosition().getX();
        int Y = this.character.getPosition().getY();

        List<Position> grid = this.game.getGrid();
        List<Position> movableGrid = new ArrayList<>();
        getMovableGrid(X, Y, grid, movableGrid);
        
        if (this.difficulty == 1) {
            Random rand = new Random();
            int randomNum = rand.nextInt(4) + 1;
            if (randomNum == 1 && this.game.getObjectsFromGrid(X, Y + 1).isEmpty()) {
                this.character.move(Direction.Up);
            } else if (randomNum == 2 && this.game.getObjectsFromGrid(X + 1, Y).isEmpty()) {
                this.character.move(Direction.Right);
            } else if (randomNum == 3 && this.game.getObjectsFromGrid(X, Y - 1).isEmpty()) {
                this.character.move(Direction.Down);
            } else if (randomNum == 4 && this.game.getObjectsFromGrid(X - 1, Y).isEmpty()) {
                this.character.move(Direction.Left);
            }
        }
        if (this.difficulty == 2) {
        }
    }

    public List<Position> getUsableGrid(int X, int Y, List<Position> grid) {
        List<Position> tempList = new ArrayList<>();
        for (int x = X + this.character.getTorchRange(); x == X - this.character.getTorchRange() || x == 0; x--) {
            if (this.game.getObjectsFromGrid(x, Y).isEmpty()) {
                for (Position P : grid) {
                    if (P.getX() == x && P.getY() == Y) {
                        tempList.add(P);
                    }
                }
            }
        }

        for (int y = Y + this.character.getTorchRange(); y == Y - this.character.getTorchRange() || y == 0; y--) {
            if (this.game.getObjectsFromGrid(X, y).isEmpty()) {
                for (Position P : grid) {
                    if (P.getX() == X && P.getY() == y) {
                        tempList.add(P);
                    }
                }
            }

        }

        return tempList;
    }

    public boolean isVisible(int X, int Y) {
        int x = this.character.getPosition().getX();
        int y = this.character.getPosition().getY();
        int t = this.character.getTorchRange();
        //if X=x and Y is within torch range return true
        if (X == x) {
            if (y == Y) {
                return true;
            } else if ((Y >= y && Y <= (y + t)) || (Y <= y && Y >= (y - t))) {
                return true;
            }
            //if X>x or X<x but within torch range
        } else if ((X > x && X <= (x + t)) || (X < x && X >= (x - t))) {
            //if Y==y =true
            if (Y == y) {
                return true;
            }
            if (X > x) {
                //if X > x,Y is within range return true
                if ((Y > y && Y - y <= t - (X - x)) || (Y < y && y - Y <= t - (X - x))) {
                    return true;
                }
                //if X < x, Y is within range return true   
            } else {
                if ((Y > y && Y - y <= t - (x - X)) || (Y < y && y - Y <= t - (x - X))) {
                    return true;
                } 
            }
        }
        return false;
    }

    public void getMovableGrid(int X, int Y, List<Position> grid, List<Position> tempList) {
        int x = this.character.getPosition().getX();
        int y = this.character.getPosition().getY();
        int t = this.character.getTorchRange();

        for (Position P : grid) {
            if (P.getX() == X && P.getY() == Y && !tempList.contains(P)) {
                tempList.add(P);
            }
            if (P.getX() == X && P.getY() == Y + 1) {
                if (this.isVisible(X, Y + 1)) {
                    for (Object O : P.getObjects()) {
                        if (!(O instanceof Ballista) && !(O instanceof Obstacle)) {
                            this.getMovableGrid(X, Y + 1, grid, tempList);
                        }
                    }
                }
            }
            if (P.getX() == X + 1 && P.getY() == Y) {
                if (this.isVisible(X + 1, Y)) {
                    for (Object O : P.getObjects()) {
                        if (!(O instanceof Ballista) && !(O instanceof Obstacle)) {
                            this.getMovableGrid(X + 1, Y, grid, tempList);
                        }
                    }
                }
            }
            if (P.getX() == X && P.getY() == Y - 1) {
                if (this.isVisible(X, Y - 1)) {
                    for (Object O : P.getObjects()) {
                        if (!(O instanceof Ballista) && !(O instanceof Obstacle)) {
                            this.getMovableGrid(X, Y - 1, grid, tempList);
                        }
                    }
                }
            }
            if (P.getX() == X - 1 && P.getY() == Y) {
                if (this.isVisible(X - 1, Y)) {
                    for (Object O : P.getObjects()) {
                        if (!(O instanceof Ballista) && !(O instanceof Obstacle)) {
                            this.getMovableGrid(X - 1, Y, grid, tempList);
                        }
                    }
                }
            }
        }
    }
}
