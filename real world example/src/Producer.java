
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer implements Runnable {
    
        private final BoundedBuffer buffer;
        private final Jtable table;
        
        int agent ;
        int window ;

    public Producer(BoundedBuffer buffer , Jtable table) {
        this.buffer = buffer;
        this.table = table;
        agent = 1;
        window = 0;
    }
   

 @Override
    public void run() {
        
        boolean awokenByPauseButton = false;
        while (agent<20) {
            // nap for awhile
            // produce an item & enter it into the buffer
            buffer.insert( table);
           // table.insert_table(window+1, agent);
            //table.insert_producer(window+1,agent);
            agent++;
            window = (window+1) % 7;
           
           }
           
        }

    }
