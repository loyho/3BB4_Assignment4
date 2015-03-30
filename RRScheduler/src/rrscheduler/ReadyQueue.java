


/**
 *
 * @author Jenell
 */
public class ReadyQueue {
    int waiting;
    Process[] threadQueue;
    boolean isLoaded=false;
    
    
    public ReadyQueue(){
        waiting=0;
        threadQueue=new Process[5];
    }
    
    
    
    private synchronized boolean isEmpty(){
        if (waiting==0){
            return true;
        }
        return false;
    }
    
   
    private synchronized boolean isFull(){
      if(waiting==threadQueue.length){
           return true;
       }
       return false;
    }

  
    
    public synchronized void enqueue(Process process) throws InterruptedException{
        
        //While the thread is full, wait...
        while(isFull()||isLoaded){
            wait();
        }
  
        int index=this.findEmptyIndex();
        this.threadQueue[index]=process;
        
        waiting=waiting+1;
        
        notifyAll();
        
    }

    
    /**
     *
     */
    public synchronized void dequeue() {
        
        //Find the last non-null entry's index
        int lastEntry=this.findNonEmptyIndex();
        
        //"Shift over every entry in the queue"
        for (int i=1;i<lastEntry;i++){
            this.threadQueue[i-1]=threadQueue[i];
        }
        //"The order of the queue is preserved. Now delete the last entry so the size decreases"
        threadQueue[lastEntry]=null;
        
        //Update state variables to reflect the size of the queue
        waiting=waiting-1;
        
        isLoaded=false;
        notify();
        //There's a new space in the queue, so notifyAll the threads that are waiting 
            
    }

    
    public synchronized void backInQueue(Process p) {
        //This method takes the first entry and puts in into the last..
        //It should be noted that p is the modified version of the first thread in the queue.
        
        //Find the lastEntry's place
        int index=this.findNonEmptyIndex();
        
        
               
        //Shift all the entries over
        for (int i=1;i<index;i++){
            threadQueue[i-1]=threadQueue[i];
        }
        
        //Now, replace the last known entry with the first
        threadQueue[index]=p;
        
        //Notify the generator and dispatcher
        isLoaded=false;
        notify();
        
        
    }
    
    /**
     *
     * @return
     */
    public synchronized Process select() throws InterruptedException{
        
        while(isEmpty()){
            
            wait();
            boolean isEmpty=isEmpty();
        }
        isLoaded=true;
        return threadQueue[0];
    }

 

    private synchronized int findEmptyIndex(){
        if (waiting==0){
            return 0;
        }
        
        else{
            return waiting-1;
        }
    }

    private synchronized int findNonEmptyIndex() {
       
        if(waiting==0|waiting==1){
           return 0;
       }
       else{
           return waiting-1;
       }
        
    }   
}