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

public class Lotus_flower {
    
    private final Location  location;
    private  int    petals;
    
    public Lotus_flower(){
        location=new Location( this);
        petals=100;
        entities.add(this);
        set_position();   
    }
    
  
    public void set_position() {
        while (true){
            Random  random= new Random();
            int x=random.nextInt(10);
            int y=random.nextInt(10);
            if (map [x][y][0]==null){
                location.set_location(x,y);
                System.out.println("Lotus flower was positioned at "+x+','+y);
                break;
            }
        }
    }
    public int get_petals(){
        return petals;
    }
    public void lose_petal(){     
        if(petals>0){
            petals--;
        }
    }
}