
public class Main {
    
    
     public static void main(String[] args ) throws InterruptedException {
    
    BoundedBuffer buffer = new BoundedBuffer();
    Jtable table = new Jtable();
    
    Producer producer = new Producer(buffer,table);
    Consumer consumer = new Consumer(buffer ,table);
    
    
    Thread producer1Thread = new Thread(producer);
    Thread producer2Thread = new Thread(producer);
    
    
    Thread consumer1Thread = new Thread(consumer);
    Thread consumer2Thread = new Thread(consumer);
    
     
    producer1Thread.start();
    producer2Thread.start();
    
    consumer1Thread.start();
    consumer2Thread.start();
    
    
    producer1Thread.join();
    producer2Thread.join();

    consumer1Thread.join();
    consumer2Thread.join();
   
    
         System.out.println(buffer.count);
}
}