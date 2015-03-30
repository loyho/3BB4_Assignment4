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
    private CPU cpu;
    private Process processSelected;
    
    public Dispatcher(){
        
    }
    
    
    @Override
    public void run() {
        while(true){
            try {
                this.select();
                
            } 
            
            
            catch (InterruptedException ex) {
                Logger.getLogger(Dispatcher.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void select() throws InterruptedException{
      
      this.processSelected=RRScheduler.readyQueue.select();
      generateMessage();
      
      CPU cpu=new CPU(5000);
      cpu.load(processSelected);
      cpu.start();
      cpu.join();
      
    }
    
    
    
    
    private void generateMessage(){
        String message="Process ";
        String id=Integer.toString(processSelected.getid());
        message=message+id+" loaded into the CPU";
        System.out.println(message);
        
        try {
            sleep(RRScheduler.messageTime);
        } catch (InterruptedException ex) {
            Logger.getLogger(Dispatcher.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }
    
}
