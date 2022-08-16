package streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapEx {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2,5,7,9,4);
        System.out.println(numbers);
        List<String> numbersInString = numbers.stream().map(num -> num.toString()).collect(Collectors.toList());
        System.out.println(numbersInString);

        List<Integer> squareOfNumbers = numbers.stream().map(num -> num*num).collect(Collectors.toList());
        System.out.println(squareOfNumbers);
    }
}
