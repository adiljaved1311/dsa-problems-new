package multiThreading;

public class DaemonThreadTest {
    public static void main(String[] args) {
        DaemonThread dt = new DaemonThread();
        dt.setDaemon(true);
        dt.start();
        System.out.println(dt.isDaemon());
    }
}

class DaemonThread extends Thread{
    public void run(){
        System.out.println("Daemon Thread");
    }
}
