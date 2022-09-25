package multiThreading.questions;

// what happened if we call run method instead of start method

class Test1 extends Thread{
    public void run(){
        for (int i=1; i<=100;i++){
            System.out.println(i);
        }
    }
}
public class RunMethodTest {
    public static void main(String[] args) {
        Test1 t1 = new Test1();
        t1.run();
        System.out.println("Main Method");
    }
}
