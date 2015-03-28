/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrscheduler;



/**
 *
 * @author Jenell
 */
public class ReadyQueue implements Runnable{
    int waiting;
    Process[] threadQueue;
    
    public ReadyQueue(){
        waiting=0;
        threadQueue=new Process[5];
    }
    
   
    public boolean isFull(){
       
       for(int i=0;i<threadQueue.length;i++){
           if(threadQueue[i]==null){
               return false;
           }
       }
       return true;
    }

  
    public void enqueue(Process process) {
        int index=this.findEmptyIndex();
        this.threadQueue[index]=process;
        waiting=waiting+1;
        
    }

    
    public void dequeue() {
        int index=this.findNonEmptyIndex();
        this.threadQueue[index]=null;
        waiting=waiting-1;
    
    }

    
    public void backInQueue(Process process) {
        int index=this.findNonEmptyIndex();
        this.threadQueue[index]=process;
        
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int findEmptyIndex() {
       for(int i=0;i<this.threadQueue.length;i++){
           if(threadQueue[i]==null){
               return i;
           }
       }
       return -1;
    }

    private int findNonEmptyIndex() {
        int firstEmpty=findEmptyIndex();
        if (firstEmpty==0){
            return 0;
        }
        else{
            return firstEmpty-1;
        }
    }
    
}
