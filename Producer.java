public class Producer implements Runnable {
    private final BoundedBuffer buffer;

    public Producer(BoundedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {

        while (true) {
            // produce an item and enter it into the buffer
            buffer.insert();
            // will make the thread be sleeping for 1 seconds
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                System.out.println(Thread.currentThread().getName() + " interrupted");
//            }
        }

    }
}