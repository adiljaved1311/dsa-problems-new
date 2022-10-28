package streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterEx {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 4, 6, 8, 3, 23, 45);
        System.out.println(numbers);
        List<Integer> evenNumbers = numbers.stream().
                filter(num -> num % 2 == 0).
                collect(Collectors.toList());
        System.out.println(evenNumbers);

        //Reduce
        int even = numbers.stream().
                filter(x -> x % 2 == 0).
                reduce(0, (answer, i) -> answer + i);
        System.out.println(even);
    }
}
