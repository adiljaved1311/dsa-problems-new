package multiThreading;

public class Main {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        t1.start();
        t2.start();
    }
}

class Thread1 extends Thread{

    public void run(){
        try{
            for(int i=1; i<=10; i++){
                Thread.sleep(1000);
                System.out.println("Thread 1 -> "+i);
            }
        }catch (InterruptedException e){
            System.out.println(e);
        }

    }
}

class Thread2 extends Thread{

    public void run(){
        for(int i=1; i<=10; i++){
            System.out.println("Thread 2 -> "+i);
        }
    }
}