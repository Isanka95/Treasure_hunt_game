/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedemo;

import static gamedemo.Adventure_Nozama.entities;
import static gamedemo.Grid.map;
import java.util.Random;

/**
 *
 * @author Asus
 */
public abstract class Fish{
    
    private final  Location location;
    
    public Fish(){
       location=new Location( this);
       entities.add(this);
       set_position();
    }
    public Location get_location(){
        return location;
    }

    public void set_position(){
        while (true){
            Random  random= new Random();
            int x=random.nextInt(10);
            int y=random.nextInt(10);
            if (map [x][y][0]==null){
                location.set_location(x,y);
                break;
            }
        }
    }   
}
