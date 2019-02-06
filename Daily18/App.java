// This problem was asked by Google

// Given an array of integers and a number k, where 1 <=k <= length of the array,
// compute the maximum values of each subarray of length k

// For example, given array [10, 5, 2, 7, 8, 7] and k = 3, we should get [10, 7, 8, 8], since 
// 10 = max (10,5,2)
// 7 = max(5,2,7)
// 8 = max(2,7,8)
// 8 = max(7,8,7)

// Do this in O(n) time and O(k) space. 
// You can modify the input array in place and you do not need to store the results.
// You can simply print them out as you compute them.


// Use DEQUE
import java.util.*;
public class App{

    // Uses Deque
    public static void get_max(int[] arr, int k){
        Deque<Integer> deque = new LinkedList<Integer>();
        // Add the first bracket
        int i;
        for (i = 0; i <k; i++){
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]){
                deque.removeLast();
            }
            deque.addLast(i);
        }

        // Iterate through
        for (;i<arr.length;i++){
            System.out.print(arr[deque.removeFirst()]+ " ");
            while (!deque.isEmpty() && deque.peekFirst() <= i-k){
                deque.removeFirst();
            }
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]){
                deque.removeLast();
            }
            deque.addLast(i);
        }
        System.out.println(arr[deque.peekFirst()]);
    }

    public static void main(String[] args){
        System.out.println("Starting ...");
        int[] intArray = {10, 5, 2, 7, 8, 7};
        int k = 3;
        get_max(intArray, k);
    }
}