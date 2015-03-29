/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrscheduler;


import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jenell
 */
public class Process extends Thread {
    
    long executionTime;
    int id;
    long runTime;
    
    
    public Process(int id){
        this.id=id;
        Random r=new Random();
        executionTime=r.nextLong();
        
    }
    
    
    
    @Override
    public void run() {
        try {
            
            sleep(100);
            
        
        }
        
        
        catch (InterruptedException ex) {
            Logger.getLogger(Process.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
 

    
    public long updateTime(long cpuRunTime) {
        long newTime=(executionTime-cpuRunTime);
        long r=executionTime;
        
        if(newTime>0){
            executionTime=newTime;
            runTime=cpuRunTime;
            return executionTime;
            
        }
        else{
            runTime=executionTime;
            this.executionTime=0;      
            return r;
        }
    }

    
    public long checkTime() {
        return executionTime;
    }
    
    public long checkRunTime(){
        return runTime;
    }

    
    public int getid(){
        return this.id;
    }


    
    
    
    
    
}
