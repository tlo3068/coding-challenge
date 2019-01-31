// This problem was asked by Stripe.

// Given an array of integers, find the first missing positive integer in linear time and constant space. 
// In other words, find the lowest positive integer that does not exist in the array. 
// The array can contain duplicates and negative numbers as well.

// For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

// You can modify the input array in-place.
import java.util.*;
import java.lang.*;
public class Daily4 {

    // Essentially, to solve this question, you must first split up the negatives and the positive values
    // After this, we do things by indexes and marking

    // We have 2 checks, first check is to make sure that the value is less than the size (because we are marking indexes)
    // Second is to make sure that the value in the position that we want to change is positive.
    // If that is positive, then we convert it to negative
    // After this, we find the index of the first possible positive value

    // This works because we are abusing the index of the array.
    // I.e. find 1, put it in 1. find 2, put it in 2. and so on.
    // If theres multiple, then we leave it.
    public static int[] sortNegatives(int[] arr){
        int[] sorted_arr = arr;
        int length = arr.length;
        int head = 0;
        for (int i = 0; i < length; i++){
            if (sorted_arr[i]<=0){
                sorted_arr[length-1] = sorted_arr[i];
                length -= 1;
            }
            else {
                sorted_arr[head] = sorted_arr[i];
                head += 1;
            }
        }
        return sorted_arr;
    }

    public static int missingInt(int[] arr){
        int[] sorted_arr = sortNegatives(arr);
        int length = arr.length;
        for (int i = 0; i < length; i++){
            int index = Math.abs(sorted_arr[i]);
            if (index <= length && sorted_arr[index-1]>0){
                sorted_arr[index-1] = -sorted_arr[index-1];
            }
        }
        for (int i = 0; i < length; i++){
            if (sorted_arr[i] > 0){
                return i+1;
            }
        }

        return length+1;

    }

    public static void main (String[] args){
        int[] numbers = {3, 4, -1, 1};
        System.out.println(missingInt(numbers));
    }
}