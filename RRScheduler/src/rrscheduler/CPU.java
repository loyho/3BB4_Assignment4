package rrscheduler;

public class CPU extends Thread{

	long maxExecutionTime;
	
	Process loadedThread;
    
	
	public void load(Process p){
		loadedThread = p;
		execute();
		
	}
	
	public CPU(long maxExecution){
		maxExecutionTime=maxExecution;
		
		loadedThread=null;
	}
	private void unload(){
		RRScheduler.reaper.checkTime(loadedThread);
		loadedThread=null;
		generateMessage();
	}
	private void execute(){
		loadedThread.updateTime(maxExecutionTime);
                loadedThread.run();
	}
	private void generateMessage(){
		System.out.format("Process %d executed for %d seconds",loadedThread.id,loadedThread.executionTime);
	}

    @Override
    public void run() {
        execute();
        unload();
        
    }
}

