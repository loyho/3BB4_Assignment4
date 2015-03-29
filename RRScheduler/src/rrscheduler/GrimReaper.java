package rrscheduler;


public class GrimReaper implements Runnable {
	
	Process currentThread;
	
	long timeLeft;
	public GrimReaper(){
		
		currentThread=null;

	}
	
	public void checkTime(Process p){
		currentThread=p;
		judge();
		
	}
	public void judge(){
		timeLeft=currentThread.checkTime();
		if (timeLeft>0){
			backInQueue(currentThread);
		}else{
			dequeue();
			currentThread=null;
		}
		}
	
	public void generateMessage(int id,long x){
		System.out.format("Process %d recycled into ready queeu with %d seconds remaining}", id,x);
	}
	public void generateMessage(int id){
		System.out.format("Process %d finished executing", id);
	}

	public void backInQueue(Process p){
		try {
			RRScheduler.readyQueue.enqueue(p);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void dequeue(){
		RRScheduler.readyQueue.dequeue();
		
	}

	@Override
	public void run() {
		
		// TODO Auto-generated method stub
		
	}
}
