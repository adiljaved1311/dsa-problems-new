package multiThreading;

public class DaemonThreadTest {
    public static void main(String[] args) {
        DaemonThread dt = new DaemonThread();
        dt.setDaemon(true);
        dt.start();
        for(int i = 1; i <= 1000; i++){
            System.out.println(i);
        }
    }
}

class DaemonThread extends Thread{
    public void run(){
        System.out.println("Daemon Thread");
    }
}
