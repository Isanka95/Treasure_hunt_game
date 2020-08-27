/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedemo;

import static gamedemo.Adventure_Nozama.entities;
import static gamedemo.Adventure_Nozama.swimmersList;
import static gamedemo.Grid.map;
import static gamedemo.Observable.observers;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Asus
 */
public abstract class Swimmer implements Runnable,Observer{
    
    
    private int     age;
    private int     finishingTime;
    private String  name;
    private static int swimmerCount;
    private boolean immortality;
    private boolean mobility;
    private static boolean winStatus;
    private Location location;
    private Fins    swimFins;
    
    public Swimmer(String name,int age){
        this.name=  name;
        this.age=   age;
        swimmerCount ++;
        mobility=   true; 
        immortality=false;
        swimFins =  new Fins();
        location=   new Location(this);
        winStatus=  true;
        swimmersList.add(this);
        observers.add(this);
        entities.add(this);
        set_position();
    }
    
                                                         
    
    public void set_swimmerCount(int value){
        this.swimmerCount=value;
    }
    public int get_swimmerCount(){
        return swimmerCount;
    }
    public String get_name(){
       return name;
    }
    public void set_immortality(boolean value){
        this.immortality=value;
    }
    public boolean get_immortality(){
        return immortality;
    }
    public void set_mobility(boolean value){
        this.mobility=value;
    }
    public boolean get_mobility(){
        return mobility;
    }
    public void set_finishingTime(int t){
        t=finishingTime;
    }
    public int get_finishingTime(){
        return finishingTime;
    }
    public void set_winStatus(boolean value){
        this.winStatus=value;
    }
    public boolean get_winStatus(){
        return winStatus;
    }
    public Location get_location(){
        return location;
    }
    
    public void set_position(){  // set the initial position of swimmers
        while (true){
            Random  random= new Random();
            int x=(random.nextInt(10));
            int y = random.nextInt(10);
            if ((x==0|x==10) | (y==10|y==0)){
                if (null==map [x][y][1]){
                    this.location.setSwimmer_newLocation(x,y);
                    if(this instanceof Super_swimmer){
                        System.out.println("Super swimmer "+this.get_name()+" was  positioned at "+x+","+y);
                    }else{
                         System.out.println("Normal swimmer "+this.get_name()+" was  positioned at "+x+","+y);
                    }
                    break;
                }
            }
        }
    }
    
    public Fins loseFins(){                                                              //if RubberEat fish eats swimmer's fins,swimmer cannot swim.
        System.out.println("RubberEat fish ate swimmer "+this.get_name()+"'s fins");
        this.set_mobility(false);
        swimmersList.remove(this);
        Fins sf = swimFins;
        swimFins=null;                                                                     //swimmer loses fins.
        return sf;
    }
    
    public void loseLife(){                                                        //when killer fish kills swimmer
        if (this.get_immortality()==false){                                        //check immortility
            System.out.println("Killer fish killed swimmer "+this.get_name());
            swimmersList.remove(this);
            observers.remove(this);
            this.set_mobility(false);
        }else{                                                                     //if swimmer is immortility,fish cannot kill.
            System.out.println("Swimmer "+this.get_name()+" met a killer fish");
        }
        
    }
    
    public void pluckFlower(){
        if (this.get_immortality()==true){                                                  //if swimmer is immortal,only plucks petals
            System.out.println("Swimmer "+this.get_name()+" plucked a lotus petal");
        }else{
            System.out.println("Swimmer "+this.get_name()+" plucked a lotus petal and became immortal ");
            this.set_immortality(true);                                                      //method calling to make immortal relevant swimmer
            }
    }
    
    public void metInnocentFish(){
        System.out.println("Swimmer "+this.get_name()+" met an innocent fish");
    }
    
    public void winGame(){
        System.out.println("Swimmer "+this.get_name()+" found Treasure and won the game!!!!!");
        //this.set_winStatus(true); 
      
    }
        
    public abstract void eat();
    public abstract void sleep();
    public abstract void swim();
    
    public void swimToNewLocation(){                                   //find a new location and move to there.
        
        location=this.get_location();   
        int pre_x=location.get_x();
        int pre_y=location.get_y();
        map[pre_x][pre_y][1]=null;                                              //when swimmer swims forward,previous location should be null
        
        ArrayList<int[]> possible_moves=new ArrayList<>();                      //to find the possible moves swimmer can.
        possible_moves.add(new int[]{0,-1});
        possible_moves.add(new int[]{0,1});
        possible_moves.add(new int[]{-1,0});
        possible_moves.add(new int[]{1,0});
        
        Random random=new Random();
        while(true){
            int k=random.nextInt(possible_moves.size());
            int x=this.location.get_x() + possible_moves.get(k)[0];
            int y=this.location.get_y() + possible_moves.get(k)[1];

            if ((x != pre_x)| (y != pre_y)){                                    //check conditions to find a possible move
                if((x<11 && x>-1 && y<11 && y>-1) && (map[x][y][1]==null)){     //check wheather any swimmer in this location
                    if( this.get_mobility()==true ){                            //if mobility=false,swimmer can't swim   
                        this.location.setSwimmer_newLocation(x,y);
                        break;
                    }else{
                        break;
                    }
                }
            }
        }
            
        }

    @Override
    public void run(){
        while(mobility & winStatus){
            swim();    
            int x=get_location().get_x();
            int y=get_location().get_y();
            Location loc=map[x][y][0]; 
  
            while(true){
               
                    if (loc!=null){                                             //check  this location has positioned any object
                        Object actor=loc.get_location_owner();                  //location owner is specialized 
                        if (actor instanceof Lotus_flower){
                            pluckFlower();
                            ((Lotus_flower) actor).lose_petal();
                        }else if(actor instanceof Killer_fish){
                            ((Killer_fish)actor).kill_swimmer();
                            loseLife();
                            //t.detach(this);
                        }else if(actor instanceof RubberEat_fish){
                            ((RubberEat_fish)actor).eatFin(loseFins());
                        }else if(actor instanceof Innocent_fish){
                            metInnocentFish();
                        }else if(actor instanceof Treasure){
                            winGame();
                            ((Treasure)actor).notify_to_observers(); 
                            Adventure_Nozama.makeGameSummeryFile(this);
                            
                        }
                         break;
                    }else{
                        System.out.println("Swimmer "+get_name()+"  swam to "+x+","+y);
                        break; 
                    }   
                
            }
            try { Thread.sleep(10); }
            catch (InterruptedException e) {}
        }    
    }
    public void update(){
        set_mobility(false);
        set_winStatus(false);
       
    }
}