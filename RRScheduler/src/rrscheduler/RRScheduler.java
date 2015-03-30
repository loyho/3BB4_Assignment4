/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrscheduler;

import java.util.Random;

/**
 *
 * @author Jenell
 */
public class RRScheduler {
    
    public static ReadyQueue readyQueue;
    
    public static GrimReaper reaper;
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Random r=new Random();
        int maxExecutionTime=5000;
        
        readyQueue=new ReadyQueue();    
        
        
       
        Dispatcher dispatcher = new Dispatcher();
        Generator generator = new Generator();
        
        generator.start();
        dispatcher.start();
        
        
    }
}
