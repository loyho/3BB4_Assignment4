/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrscheduler;

import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Jenell
 */
class Dispatcher extends Thread{
    
    private Process processSelected;
    
    public Dispatcher(){
        
    }
    
    
    @Override
    public void run() {
        while(true){
            try {
                this.select();
                generateMessage();
            } 
            
            
            catch (InterruptedException ex) {
                Logger.getLogger(Dispatcher.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void select() throws InterruptedException{
      
      this.processSelected=RRScheduler.readyQueue.select();
      
      RRScheduler.cpu.load(processSelected);
      RRScheduler.cpu.run();
      RRScheduler.cpu.join(); //Wait for cpu to finish executing
      
    }
    
    
    
    
    private void generateMessage(){
        String message="Process ";
        String id=Integer.toString(processSelected.getid());
        message=message+id+" loaded into the CPU";
        System.out.println(message);
        
       
    }
    
}
