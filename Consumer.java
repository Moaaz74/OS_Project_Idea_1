public class Consumer implements Runnable {
    private final BoundedBuffer buffer;

    public Consumer(BoundedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {

        while (true) {
            // will make the thread be sleeping for the first time until the buffer has values and that will not allow the deadlock
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                System.out.println(Thread.currentThread().getName() + " interrupted");
//            }
            // consume an item from the buffer
            buffer.remove();
        }
    }
}
