package systemDesign.messagingQueue;

public class Driver {
    public static void main(String[] args) {
        KafkaMQ queue = new KafkaMQ();
        Producer producer = new Producer(queue);
        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);
        producer.start();
        consumer1.start();
        consumer2.start();
    }
}

//Queue<Map<Integer,Queue>>

// [map -> {orderID,[1,2,3,4,5,6]}]
