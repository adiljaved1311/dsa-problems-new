package systemDesign.messagingQueue;

public class Consumer extends Thread {
    KafkaMQ queue;
    public Consumer(KafkaMQ queue){
        this.queue = queue;
    }
    public void run(){
        while (true){
            queue.consumeMessage();
            try {
                Thread.sleep(1000);
            }catch (Exception e){}
        }
    }
}
