package multiThreading.numbers;

public class EvenNumber extends Thread{
    Number num;
    public EvenNumber(Number num){
        this.num = num;
    }
    public void run(){
        while (true){
            try {
                Thread.sleep(1000);
            }catch (Exception e){}
            this.num.evenNumber();

        }
    }
}
