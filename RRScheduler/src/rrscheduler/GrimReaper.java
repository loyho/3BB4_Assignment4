package rrscheduler
public class GrimReaper {
	
	Process currentThread;
	ReadyQueue readyQ;
	long timeLeft;
	public GrimReaper(ReadyQueue readyQ){
		this.readyQ=readyQ;
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
		readyQ.enqueue(p);
	}
	public void dequeue(){
		readyQ.dequeue();
		
	}
}
