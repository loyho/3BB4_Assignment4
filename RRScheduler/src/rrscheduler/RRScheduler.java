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
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Random r=new Random();
        int maxExecutionTime=5000;
        
        readyQueue=new ReadyQueue();
        Generator generator = new Generator();
        GrimReaper reaper = new GrimReaper();
       
        Dispatcher dispatcher = new Dispatcher();
        
        generator.start();
        dispatcher.start();
        
        
    }
}
