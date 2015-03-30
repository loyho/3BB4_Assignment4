

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
		System.out.format("Process %d loaded into ready Queue\n",t.id);
		try {
			sleep(RRScheduler.sTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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