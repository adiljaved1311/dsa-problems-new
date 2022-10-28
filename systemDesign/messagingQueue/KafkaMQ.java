package systemDesign.messagingQueue;

import java.util.LinkedList;
import java.util.Queue;

public class KafkaMQ {

    Queue<Integer> queue = new LinkedList<>();

    public synchronized void produceMessage(int n){
        queue.offer(n);
        System.out.println("Produced Item : "+n);
    }
    public synchronized void consumeMessage(){
        if(queue.size() > 0){
            System.out.println("Consumed Item : "+queue.poll());
        }else{
            System.out.println("Queue is Empty, nothing to consume");
        }
    }
}
