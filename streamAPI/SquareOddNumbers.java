package streamAPI;

import java.util.Arrays;
import java.util.List;

// square only the odd numbers in sorted order
public class SquareOddNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 4, 2, 7, 6, 8, 5);

        numbers.stream().
                filter(num -> num % 2 == 1).  // Filter the odd numbers {1,7,5}
                sorted().                     // sort the odd numbers {1,5,7}
                map(num -> num * num).        // squared the numbers {1,25,49}
                forEach(num -> System.out.println(num));  // print the numbers

        // if you want to reduce the stream and add all the filtered numbers
        int result = numbers.stream().
                filter(num -> num % 2 == 1).
                map(num -> num * num).
                reduce(0,(ans,num) -> ans+num);
        System.out.println("Result : "+result);

        // same thing can be achieved by using parallel stream
        int result_p = numbers.parallelStream().
                filter(num -> num % 2 == 1).
                map(num -> num * num).
                reduce(0,(ans,num) -> ans+num);
        System.out.println("Result using parallel stream : "+result_p);
    }
}
