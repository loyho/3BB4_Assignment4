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
    public static Generator generator;
    public static CPU cpu;
    public static GrimReaper reaper;
    public static Dispatcher dispatcher;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Random r=new Random();
        long maxExecutionTime = r.nextLong();
        
        readyQueue=new ReadyQueue();
        generator=new Generator();
        reaper=new GrimReaper();
        cpu=new CPU(maxExecutionTime);
        dispatcher=new Dispatcher();
        
        generator.start();
        dispatcher.start();
        
        
    }
}
