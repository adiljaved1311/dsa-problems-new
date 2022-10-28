package systemDesign.messagingQueue;

public class Producer extends Thread{
    KafkaMQ queue;
    public Producer(KafkaMQ queue){
        this.queue = queue;
    }
    public void run(){
        int i = 1;
        while (true){
            queue.produceMessage(i);
            try {
                Thread.sleep(500);
            }catch (Exception e){}
            i++;
        }
    }
}
