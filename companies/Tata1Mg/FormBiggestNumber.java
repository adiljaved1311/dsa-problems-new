package companies.Tata1Mg;

import javax.swing.*;

public class FormBiggestNumber {
    public static void main(String[] args) {
        int arr[] = {9, 98, 7};
        formBiggestNumber(arr);
    }

    public static void formBiggestNumber(int arr[]) {
        int OutputArraySize = factorial(arr.length);
        int numbers[] = new int[OutputArraySize];
        int index = 0;
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            String num = arr[i] + "";
            for (int j = 0; j < arr.length; j++) {
                if(i != j){
                    num = num + "" + arr[j];
                    counter++;
                    System.out.println(num);
                }
            }
            numbers[index++] = Integer.parseInt(num);
            //System.out.println(num);
        }
        System.out.println(counter);
    }

    private static int factorial(int num) {
        int factorial = 1;
        for (int i = 2; i <= num; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }
}
