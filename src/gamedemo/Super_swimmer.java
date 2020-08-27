/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedemo;

import static gamedemo.Grid.map;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class Super_swimmer extends Swimmer{
    
  
    
    public Super_swimmer(String name,int age){
        
        super(name,age);
        Binocular bino = new Binocular();
    }
    
    @Override
    public void swim(){
        if (this.get_immortality()==false){                                     //only immortal swimmers check the flowers through binocular
            this.see_through_binocular();
        }else{
            this.swimToNewLocation();
        }
    }
    public void eat(){}
    public void sleep(){}
    public void update(){}
    
    public void see_through_binocular(){                                        //check the around loaction has any flower
        
        int pre_x=this.get_location().get_x();
        int pre_y=this.get_location().get_y();
       
         
        ArrayList<int[]> sides=new ArrayList<>();
        sides.add(new int[]{pre_x+1,pre_y});
        sides.add(new int[]{pre_x,pre_y+1});
        sides.add(new int[]{pre_x-1,pre_y});
        sides.add(new int[]{pre_x,pre_y+1});
        
        
        while(true){
            for (int i = 0; i < sides.size(); i++){
                int[] side =sides.get(i);
                if((side[0]<11 && side[0]>-1) && (side[1]<11 && side[1]>-1)){
                    if (map[side[0]][side[1]][1]!=null){
                        Location loc=map[side[0]][side[1]][0];
                        if((loc!=null) && (loc.get_location_owner() instanceof Lotus_flower)){
                            map[pre_x][pre_y][1]=null;
                            this.get_location().setSwimmer_newLocation(side[0],side[1]);
                            break;
                        }
                    }
                }
            }
            this.swimToNewLocation();
            break;
        } 
    }
}