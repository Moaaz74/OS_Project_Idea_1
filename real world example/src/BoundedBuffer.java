
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


public class BoundedBuffer {
    private static final int BUFFER_SIZE = 7;
    private final Semaphore mutex;
    private final Semaphore empty;
    private final Semaphore full;
    public Object[] buffer;
    private int in, out;
    private JFrame f ;
    int item ;
    private  Jtable table;
int count=0;
    // Continued on next Slide
    public BoundedBuffer() {
        // buffer is initially empty
        in = 0;
        out = 0;     
        buffer = new Object[BUFFER_SIZE];
        mutex = new Semaphore(1);
        empty = new Semaphore(BUFFER_SIZE);
        full = new Semaphore(0);
        f = new JFrame();
        item = 1;
    }


    public void insert(Jtable table) {
        empty.acquire();
        mutex.acquire();
        // add an item to the buffer
        //Date date= new Date();
        this.table = table;
        int window = in+1;
        System.out.println("Agent "+item  +" on window "+window);
        table.insert_table(window, item);
        buffer[in] = item;
        in = (in + 1) % BUFFER_SIZE;
        item++;
        count ++;
        mutex.release();
       // System.out.println("Agent: "+item +" left window " + window);
        full.release();
        //System.out.println( Thread.currentThread().getName() +"turn"+ Arrays.toString(buffer)+"-> "+count);
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
    }

    public Object remove() {
        
       
        full.acquire();
        mutex.acquire();
        // remove an item from the buffer
        //Date date= new Date();
        int window = out+1;
        Object item = buffer[out];
        System.out.println("Agent: "+item +" left window " + window);
        int index = out+1;
        out = (out + 1) % BUFFER_SIZE;
        count --;
        mutex.release();
         //System.out.println("Thread: "+Thread.currentThread().getName()  +" left critical section");
        empty.release();
        //System.out.println( Thread.currentThread().getName()  +"turn "+ item+"-> "+count);
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
        return index;
    }
    
}
