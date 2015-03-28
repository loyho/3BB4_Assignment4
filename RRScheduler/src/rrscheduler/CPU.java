package rrscheduler
public class CPU implements CPUInterface {

	long maxExecutionTime;
	GrimReaper reaper;
	Process loadedThread;
	
	public void load(Process p){
		loadedThread = p;
		execute();
		
	}
	
	public CPU(long maxExecution,GrimReaper reaper){
		maxExecutionTime=maxExecution;
		this.reaper=reaper;
		loadedThread=null;
	}
	private void unload(){
		reaper.checkTime(loadedThread);
		loadedThread=null;
		generateMessage();
	}
	private void execute(){
		loadedThread.run();
		try {
			wait(maxExecutionTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loadedThread.notify();	
		generateMessage();
	}
	private void generateMessage(){
		System.out.format("Process %d executed for %d seconds",loadedThread.id,loadedThread.executionTime);
	}
}

