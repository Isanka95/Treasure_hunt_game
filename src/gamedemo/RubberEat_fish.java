/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedemo;

import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class RubberEat_fish extends Fish {
    
    public  ArrayList<Fins> grabbedFins;
    
    public RubberEat_fish(){
        System.out.println("RubberEat fish was positioned at "+this.get_location().get_x()+','+this.get_location().get_y()); 
        grabbedFins=new ArrayList<>();                                         // to collect the swim fins which fish ate. 
    }
    
    public void eatFin(Fins f){                                                 //eta fins and collect them
        this.grabbedFins.add(f);  
    }
    
   
}