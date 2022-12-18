
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer implements Runnable{
    private final BoundedBuffer buffer;
    private final Jtable table;
        Integer index;
        int i = 1;
   
    public Consumer(BoundedBuffer buffer,Jtable table) {
        this.buffer = buffer;
        this.table = table;
    }

    public void run() {
        
        boolean awokenByPauseButton;
        while (i<20) {
             
            // consume an item from the buffer
            index = (Integer) buffer.remove();
            //table.insert_consumer(index,i);
            i++;
           
                
                
         }
            
        }
    }
    

