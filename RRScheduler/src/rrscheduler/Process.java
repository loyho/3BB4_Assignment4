

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jenell
 */
public class Process extends Thread {
    
    int remainingExecutionTime;
    int id;
    long runTime;
    
    private int randInt(int min, int max){
        //Generates a random integer inbetween the range min,max
        Random r=new Random();
        int randomNum=r.nextInt((max-min)+1)+min;
        return randomNum;
        
    }
    
    public Process(int id){
        this.id=id;
        
        remainingExecutionTime=randInt(1000,7000);
        
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
    
 

    
    public long updateTime(int cpuRunTime) {
        int newTime=(remainingExecutionTime-cpuRunTime);
        int r=remainingExecutionTime;
        
        if(newTime>0){
            remainingExecutionTime=newTime;
            runTime=cpuRunTime;
            return remainingExecutionTime;
            
        }
        else{
            runTime=remainingExecutionTime;
            this.remainingExecutionTime=0;      
            return r;
        }
    }

    
    public long checkTime() {
        return remainingExecutionTime;
    }
    
    public long checkRunTime(){
        return runTime;
    }

    
    public int getid(){
        return this.id;
    }


    
    
    
    
    
}