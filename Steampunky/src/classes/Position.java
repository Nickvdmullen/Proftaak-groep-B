/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author Cyril
 */
public class Position {
    private int x;
    private int y;
    private List<Object> objects;
    
    /**
     * creates instance of Position with an X and Y coordinate
     * @param x
     * @param y 
     */
    public Position(int x,int y){
        this.x = x;
        this.y = y;
    }
    
    /**
     * 
     * @return the X coordinate of this instance
     */
    public int getX(){
        return this.x;
    }
    
    /**
     * 
     * @return the Y coordinate of this instance
     */
    public int getY(){
        return this.y;
    }
    
    /**
     * 
     * @return a list of objects in this instance
     */
    public List<Object> getObjects(){
        return Collections.unmodifiableList(objects);    
    }
    
    /**
     * gets an object and removes that from the list of objects in this instance.
     * @param o
     * @return true if this object is removed else return false.
     */
    public boolean removeObject(Object o) {
        try {
            this.objects.remove(o);
            return true;
        }
        catch(NullPointerException e){
            return false;
        }
    }
    
    /**
     * add an object to the list of objects
     * @param o
     * @return the object that has been added.
     */
    public Object addObject(Object o){
        if(o == null){
            return null;
        }
        else if (this.objects.contains(o)){
            return o;
        } else {
            this.objects.add(o);
            return o;
        }
    }
    
    
    
}
