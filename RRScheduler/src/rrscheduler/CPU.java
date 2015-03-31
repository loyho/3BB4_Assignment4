
package rrscheduler;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CPU extends Thread{

	int maxExecutionTime;
	GrimReaper reaper;
	Process loadedThread;

    public CPU(int maxExecution){
		maxExecutionTime=maxExecution;
		
		loadedThread=null;
	}
	
	public void load(Process p){
		loadedThread = p;
		
		
	}
	
	
	private void unload() throws InterruptedException{
                
		
		
		generateMessage();
                
                reaper=new GrimReaper();
                reaper.give(loadedThread);
                reaper.start();      
                reaper.join();
                
	}
	private void execute() throws InterruptedException{
		
            loadedThread.updateTime(maxExecutionTime);
             loadedThread.run();
                
	}
	private void generateMessage(){
		System.out.format("Process %d executed for %d seconds\n",loadedThread.getid(),loadedThread.checkRunTime()/1000);
            
                //The current thread then sleeps so the output is friendly to the human eye (The messages might print to quickly otherwise)
            try {
                sleep(RRScheduler.messageTime);
            } catch (InterruptedException ex) {
                Logger.getLogger(CPU.class.getName()).log(Level.SEVERE, null, ex);
            }
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
