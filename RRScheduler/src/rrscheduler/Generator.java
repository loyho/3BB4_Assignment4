package rrscheduler;

import java.util.logging.Level;
import java.util.logging.Logger;



public class Generator extends Thread {
	int processCount;	
	Process t;
	   

   
    public Generator(){
        processCount=0;
    }
    
    
	
    
    
    private void enqueue() throws InterruptedException{
		t=new Process(processCount);
                generateMessage();
		RRScheduler.readyQueue.enqueue(t);
                processCount++;
                
                
		
		
	}
	
	
    private void generateMessage(){
		System.out.format("Process %d loaded into ready Queue\n",t.getid());
            
                //This method sleeps for a time so that the messages being generated aren't printed too quickly.
                try {                
                sleep(RRScheduler.messageTime);
            } catch (InterruptedException ex) {
                Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
            }
	}

    @Override
    public void run() {
        while(true){
            
            try {
                
                
                enqueue();
                
            } catch (InterruptedException ex) {
            }
        }
    }

	
}