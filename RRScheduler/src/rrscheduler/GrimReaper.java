package rrscheduler;

public class GrimReaper extends Thread {
	
	Process currentThread;
	
	long timeLeft;
	public GrimReaper(){
		
		currentThread=null;

	}
	
	
	public void judge(){
		timeLeft=currentThread.checkTime();
		if (timeLeft>0){
			generateMessage(currentThread.getid(),timeLeft);
			backInQueue(currentThread);

		}else{
			dequeue();
            generateMessage();

			
		}
		}
	
	public void generateMessage(int id,long x){
		long remainingTime = x/1000;
		System.out.format("Process %d recycled into ready queue with %d seconds remaining}\n", id,remainingTime);
		try {
			sleep(RRScheduler.sTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void generateMessage(){
                
		System.out.format("Process %d finished executing\n", currentThread.getid());
		try {
			sleep(RRScheduler.sTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void backInQueue(Process p){
		
			RRScheduler.readyQueue.backInQueue(p);
		
	}
	public void dequeue(){
		RRScheduler.readyQueue.dequeue();
		
	}

	@Override
	public void run() {
		
		// TODO Auto-generated method stub
            this.judge();
                
                
		
	}

    void give(Process loadedThread) {
        this.currentThread=loadedThread;
    }
}