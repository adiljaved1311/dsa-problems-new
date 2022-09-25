package multiThreading.comp;

public class Company {
    int n;
    boolean f = false;

    //f = false : chance : producer
    //f = true : chance : consumer
    synchronized public void produce_item(int n) {
        if(f){
            try{wait();}catch (Exception e){}
        }
        this.n = n;
        System.out.println("Produced : "+this.n);
        f = true;
        notify();
    }

    synchronized public int consume_item(){
        if(!f){
            try{wait();}catch (Exception e){}
        }
        System.out.println("Consumed : "+this.n);
        f = false;
        notify();
        return this.n;
    }
}
