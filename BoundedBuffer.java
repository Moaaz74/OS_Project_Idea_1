public class BoundedBuffer {
    private static final int BUFFER_SIZE = 7;
    private final Semaphore mutex;
    private final Semaphore empty;
    private final Semaphore full;
    public Integer[] buffer;
    private int in, out;
    private int count=0;
    public BoundedBuffer() {
        in = 0;
        out = 0;
        buffer = new Integer[BUFFER_SIZE];
        mutex = new Semaphore(1);
        empty = new Semaphore(BUFFER_SIZE);
        full = new Semaphore(0);
    }


    public  void insert() {
        empty.acquire();
        mutex.acquire();
        buffer[in] = count;
        // will put the item into the text filed
        in = (in + 1) % BUFFER_SIZE;
        System.out.println(Thread.currentThread().getName() + " has inserted " + count);
        count++;
        mutex.release();
        full.release();
    }

    public  void remove() {
        full.acquire();
        mutex.acquire();
        Integer item;
        // remove an item from the buffer
        item = buffer[out];
        out = (out + 1) % BUFFER_SIZE;
        System.out.println(Thread.currentThread().getName() + " has removed " + item);
        mutex.release();
        empty.release();
    }
}
