package multiThreading.numbers;

public class Number {
    int n = 0;
    boolean flag = false;

    public synchronized void oddNumber(){
        if(flag){
            try{wait();}catch (Exception e){}
        }
        n++;
        System.out.println(n);
        flag = true;
        notify();
    }

    public synchronized void evenNumber(){
        if(!flag){
            try{wait();}catch (Exception e){}
        }
        n++;
        System.out.println(n);
        flag = false;
        notify();
    }
}
