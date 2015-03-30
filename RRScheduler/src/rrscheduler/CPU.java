package rrscheduler;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CPU extends Thread{

	int maxExecutionTime;
	
	Process loadedThread;

    
	
	public void load(Process p){
		loadedThread = p;
		
		
	}
	
	public CPU(int maxExecution){
		maxExecutionTime=maxExecution;
		
		loadedThread=null;
	}
	private void unload() throws InterruptedException{
                
		
		
		generateMessage();
                
                GrimReaper reaper=new GrimReaper();
                reaper.give(loadedThread);
                reaper.start();      
                reaper.join();
                
	}
	private void execute() throws InterruptedException{
		
            loadedThread.updateTime(maxExecutionTime);
                loadedThread.run();
                
	}
	private void generateMessage(){
		System.out.format("Process %d executed for %d seconds\n",loadedThread.getid(),loadedThread.checkRunTime());
	}

    @Override
    public void run() {
        
            try {
                
                execute();
                unload();
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(CPU.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
}

