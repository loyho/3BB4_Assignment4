package rrscheduler;



public class Generator implements Runnable {
	int processCount;	
	Process t;
	   

   
    public Generator(){
        
    }
    
    
	
    
    
    private void enqueue() throws InterruptedException{
		t=new Process(processCount);
		RRScheduler.readyQueue.enqueue(t);
                processCount++;
                
                
		
		
	}
	
	
    private void generateMessage(){
		System.out.format("Process %d loaded into ready Queue",t.id);
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
