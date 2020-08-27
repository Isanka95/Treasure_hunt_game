/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedemo;

/**
 *
 * @author Asus
 */

public class Innocent_fish extends Fish  {
    
    public Innocent_fish(){
        System.out.println("Innocent fish  was positioned at "+this.get_location().get_x()+','+this.get_location().get_y());
    }
    
}