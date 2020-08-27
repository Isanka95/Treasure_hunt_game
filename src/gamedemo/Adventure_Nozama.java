/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedemo;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author Asus
 */
public class Adventure_Nozama {
    
    public static ArrayList<Swimmer> swimmersList = new ArrayList<>();          //keep the swimmers in an arralist
    public static ArrayList<Object> entities = new ArrayList<>();               //keep the all entities of the game in a one array
    public void createEntities(){                                               //create the objects 
        
        Treasure t = new Treasure();
        
        System.out.println();
        
        Lotus_flower l1= new Lotus_flower();
        Lotus_flower l2= new Lotus_flower();
        Lotus_flower l3= new Lotus_flower();
        Lotus_flower l4= new Lotus_flower();
        Lotus_flower l5= new Lotus_flower();
        
        System.out.println();
        
        Fish f1 = new Innocent_fish();
        Fish f2 = new Innocent_fish();
        Fish f3 = new Killer_fish();
        Fish f4 = new Killer_fish();
        Fish f5 = new RubberEat_fish();
        Fish f6 = new RubberEat_fish();
        
        System.out.println();
        
        Swimmer s1=new Normal_swimmer("Kumu", 21);
        Swimmer s2=new Normal_swimmer("Jimmy",22);
        Swimmer s3=new Super_swimmer("Leshi",23);
        Swimmer s4=new Super_swimmer("Issa", 23);
         
        System.out.println();
        
    
        new Thread(s1).start();
        new Thread(s2).start();
        new Thread(s3).start();
        new Thread(s4).start();
        
        
        

    }
    public static void makeGameSummeryFile(Swimmer s){
            
        String fileName="game.txt";  // writting game summery to a text file
        try{
            FileWriter fileWriter= new FileWriter(fileName);
            BufferedWriter bufferdWriter = new BufferedWriter(fileWriter);
            bufferdWriter.write("Game summery");
            bufferdWriter.newLine();
            bufferdWriter.write("=================");
            bufferdWriter.write(s.get_name()+"won the game!!!");
            bufferdWriter.close();
            
        } catch (IOException ice) {
           System.out.println("Error writtng to the file");
        }
        
    }
    

}
