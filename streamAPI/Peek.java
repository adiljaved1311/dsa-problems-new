package streamAPI;

import java.util.Arrays;
import java.util.List;

public class Peek {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,3,5,6,7,2);
        List<Integer> list2 = Arrays.asList(1,3,5,6,7,2);
        list1.stream().forEach(e -> System.out.println(e));
    }
}
