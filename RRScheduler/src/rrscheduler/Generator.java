import java.util.Random;
package rrscheduler

public class Generator implements GeneratorInterface {
	int processCount;
	int waiting;
	Process t;

	RRScheduler scheduler;
	ReadyQueue readyQ;    

    public void Generator(ReadyQueue readyQ){
        this.readyQ=scheduler.readyQ;
    }
	private void enqueue(){
		t=new Process(processCount);
		readyQ.enqueue(t);
		
		
	}
	private void checkQueue(){
        waiting = readyQ.threadQueue.length;
	}
	private void generateMessage(){
		System.out.format("Process %d loaded into ready Queue",t.id);
	}

	
}
