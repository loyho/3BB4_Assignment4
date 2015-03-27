/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author Jenell
 */
public interface ProcessInterface extends Runnable {
    
    
    public long updateTime(long cpuRunTime);
    
    public long checkTime();
    
    public int getId();
    
    
}
