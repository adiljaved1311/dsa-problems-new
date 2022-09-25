package multiThreading.numbers;

public class OddNumber extends Thread {
    Number num;
    public OddNumber(Number num){
        this.num = num;
    }
    public void run(){
        while (true){
            try {
                Thread.sleep(1000);
            }catch (Exception e){}
            this.num.oddNumber();
        }
    }
}
