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
    
    //A time for thread to wait after printing a message (This is so the output is more human observer-friendly.
    public static int messageTime=500;
    
    
    public static ReadyQueue readyQueue;
    
    public static GrimReaper reaper;
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Random r=new Random();
        
        
        readyQueue=new ReadyQueue();    
        
        
       
        Dispatcher dispatcher = new Dispatcher();
        Generator generator = new Generator();
        
        generator.start();
        dispatcher.start();
        
        
    }
    }
