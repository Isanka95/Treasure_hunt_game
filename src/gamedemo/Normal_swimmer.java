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

public class Normal_swimmer extends Swimmer implements Grid{

    public Normal_swimmer(String name,int age){
       super(name,age);
    }
  
    @Override
    public void swim(){
        this.swimToNewLocation();
    }
    public void eat(){}
    public void sleep(){}
    
}