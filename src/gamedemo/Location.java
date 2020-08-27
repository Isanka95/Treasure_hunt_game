/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedemo;

import static gamedemo.Grid.map;


/**
 *
 * @author Asus
 */
public class Location{
    private int x;
    private int y;
    private Object location_owner;
    
    public Location(Object location_owner){
        this.location_owner=location_owner;
    }
    public void set_x(){
        this.x=x;
    }
    public int get_x(){
        return x;
    }
    public void set_y(){
        this.y=y;
    }
    public int get_y(){
        return y;
    }
    public Object get_location_owner(){
        return location_owner;
    }
    public synchronized void set_location(int x,int y){  
        this.x=x;
        this.y=y;
        map[x][y][0]=this;
        
    }
    public  synchronized void setSwimmer_newLocation(int x, int y){
        this.x=x;
        this.y=y;
        map[x][y][1]=this;
    }
    
    
}
