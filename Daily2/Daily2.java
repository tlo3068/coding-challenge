// Given an array of integers, return a new array such that each element at index i 
//  of the new array is the product of all the numbers in the original array except the one at i.

// For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. 
// If our input was [3, 2, 1], the expected output would be [2, 3, 6].

// Follow-up: what if you can't use division?

import java.util.*;
public class Daily2 {
 
    static int[] myProduct(int[] numbers){
        int length = numbers.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int[] product = new int[length];

        left[0] = 1;
        right[length-1] = 1;
        for (int i = 1; i < length; i ++){
            left[i] = left[i-1] * numbers[i-1];
            int index = length - i;
            right[length-i-1] = right[index] * numbers[index];
        }
        for (int i = 0; i < length; i++){
            product[i] = left[i] * right[i];
        }
        return product;

    }
    public static void main(String[] args){
        System.out.println("Daily2 running");
        int[] numbers = {1, 0, 3, 4, 5};
        System.out.println(Arrays.toString(myProduct(numbers)));
    }
}