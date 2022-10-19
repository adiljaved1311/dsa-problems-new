package tree;

public class Test {
    static void p(long l){
        System.out.println("L");
    }
    static void p(Integer l){
        System.out.println("IN");
    }

    public static void main(String[] args) {
        p(5);
    }
}
