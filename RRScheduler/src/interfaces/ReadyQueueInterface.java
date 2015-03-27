/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author Jenell
 */
public interface ReadyQueueInterface extends Runnable {
    
    public boolean isFull();
    
    public void enqueue(Process process);
    
    public void dequeue();
    
    public void backInQueue();
    
}
