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
public interface Observable {

   
    final ArrayList<Observer> observers = new ArrayList<>();
     
    public void attach(Observer o);
    public void detach(Observer o);
    public void notify_to_observers();
    
}