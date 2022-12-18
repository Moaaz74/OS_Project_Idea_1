import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Create buffer and within we will activate the semaphore , initialize the full and empty and set the size of the buffer
        BoundedBuffer buffer = new BoundedBuffer();
        // now create the producer and consumer threads
        // create producer and consumer threads
        Thread producer = new Thread(new Producer(buffer));
        producer.setName("Producer 1");
        Thread producer2 = new Thread(new Producer(buffer));
        producer2.setName("Producer 2");
        Thread consumer = new Thread(new Consumer(buffer));
        consumer.setName("Consumer 1");
        Thread consumer2 = new Thread(new Consumer(buffer));
        consumer2.setName("Consumer 2");
        producer.start();producer2.start();consumer.start();consumer2.start();
        try{
            producer.join();producer2.join();consumer.join();consumer2.join();
        }catch (InterruptedException e){}

    }
}
