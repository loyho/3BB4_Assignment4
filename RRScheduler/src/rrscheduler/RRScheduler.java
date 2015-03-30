import java.util.Random;

/**
 *
 * @author Jenell
 */
public class RRScheduler {
    
    public static ReadyQueue readyQueue;
    
    public static GrimReaper reaper;
    public static int sTime=500;
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Random r=new Random();
        int maxExecutionTime=5000;
        
        readyQueue=new ReadyQueue();    
        
        
       
        Dispatcher dispatcher = new Dispatcher();
        Generator generator = new Generator();
        
        generator.start();
        dispatcher.start();
        
        
    }
}