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
    static ReadyQueue readyQ;
    static CPU cpu;
    private Process processSelected;
    
    public Dispatcher(ReadyQueue ready,CPU c){
        Dispatcher.readyQ=ready;
        Dispatcher.cpu=c;
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
      
      this.processSelected=readyQ.select();
      cpu.load(processSelected);
      cpu.run();
      cpu.join(); //Wait for cpu to finish executing
      
    }
    
    
    
    
    private void generateMessage(){
        String message="Process ";
        String id=Integer.toString(processSelected.getid());
        message=message+id+" loaded into the CPU";
        System.out.println(message);
        
       
    }
    
}
