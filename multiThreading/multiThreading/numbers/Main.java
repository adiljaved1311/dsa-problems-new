package multiThreading.numbers;

public class Main {
    public static void main(String[] args) {
        Number num = new Number();
        OddNumber on = new OddNumber(num);
        EvenNumber en = new EvenNumber(num);
        on.start();
        en.start();
    }
}
