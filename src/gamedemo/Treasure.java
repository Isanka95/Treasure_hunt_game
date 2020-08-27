/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedemo;

import static gamedemo.Adventure_Nozama.entities;
import static gamedemo.Grid.map;

/**
 *
 * @author Asus
 */
public class Treasure implements Observable{
    
    private final Location location;
    
    public Treasure(){
      location =new Location( this);
      entities.add(this);
      set_position(); 
      
    }
    
    public void set_position(){
        location.set_location(5,5);
        System.out.println("Treasure was positioned at 5,5");
    }
   
    @Override
    public void  attach(Observer o){
        observers.add(o);
    }
    @Override
    public void detach(Observer o){
        observers.remove(o);
        }
    @Override
    public void notify_to_observers(){
            for(Observer o :observers){
                o.update();
            
        }
    }
}
