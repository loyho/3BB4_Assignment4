package rrscheduler;

import java.util.logging.Level;
import java.util.logging.Logger;


public class GrimReaper extends Thread {
	
	private Process currentThread;
	
        
        
	public GrimReaper(){
		
		currentThread=null;

	}
	
	
	private void checkTime(){
		int timeLeft=currentThread.checkTime();
                
		if (timeLeft>0){
			backInQueue(currentThread);
		}else{
			dequeue();
			
		}
		}
	
	private void generateMessage(int id,long x){
		System.out.format("Process %d recycled into ready queeu with %d seconds remaining}\n", id,x);
            
                
                
            //Sleep for a while so the messages don't print out too fast    
            try {                
                sleep(RRScheduler.messageTime);
            
            
            } catch (InterruptedException ex) {
                Logger.getLogger(GrimReaper.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
	private void generateMessage(){
                
		System.out.format("Process %d finished executing\n", currentThread.getid());
            
                //Sleep for a while so the messages don't print out too fast
                try {
                sleep(RRScheduler.messageTime);
            
            
            } catch (InterruptedException ex) {
                Logger.getLogger(GrimReaper.class.getName()).log(Level.SEVERE, null, ex);
            }
	}

	private void backInQueue(Process p){
		
			RRScheduler.readyQueue.backInQueue(p);
		
	}
	private void dequeue(){
		RRScheduler.readyQueue.dequeue();
		
	}

	@Override
	public void run() {
		
		// TODO Auto-generated method stub
            this.checkTime();
            generateMessage();
                
                
		
	}

    public void give(Process loadedThread) {
        this.currentThread=loadedThread;
    }
}
