package streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
        List<Integer> even_numbers = numbers.stream().filter(num -> num%2 == 0).collect(Collectors.toList());
        System.out.println(even_numbers);

        List<Integer> odd_numbers = numbers.stream().filter(num -> num%2 != 0).collect(Collectors.toList());
        System.out.println(odd_numbers);

        //Reduce
        int even_numbers_sum = numbers.stream().filter(x -> x % 2 == 0).reduce(0, (answer, i) -> answer + i);
        System.out.println(even_numbers_sum);
    }
}
