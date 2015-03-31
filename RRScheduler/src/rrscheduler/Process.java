
package rrscheduler;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jenell
 */
public class Process extends Thread {
    
    private int remainingExecutionTime;
    private int id;
    private int runTime;
    
   
    
    public Process(int id){
        this.id=id;
        
        int num=randInt(1,7);
        remainingExecutionTime=num*1000;
        
    }
    
    
    
    @Override
    public void run() {
        try {
            
            this.sleep(runTime);
            
        
        }
        
        
        catch (InterruptedException ex) {
            Logger.getLogger(Process.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
 

    
    public void updateTime(int cpuRunTime) {
        
        int difference=(remainingExecutionTime-cpuRunTime);
        int r=remainingExecutionTime;
        
        if(difference>0){
            remainingExecutionTime=difference;
            runTime=cpuRunTime;
            
            
        }
        else{
            runTime=remainingExecutionTime;
            this.remainingExecutionTime=0;      
           
        }
    }

    
    public int checkTime() {
        return remainingExecutionTime;
    }
    
    public int checkRunTime(){
        return runTime;
    }

    
    public int getid(){
        return this.id;
    }
    
     private int randInt(int min, int max){
        //Generates a random integer inbetween the range min,max
        Random r=new Random();
        int randomNum=r.nextInt((max-min)+1)+min;
        return randomNum;
        
    }


    
    
    
    
    
}