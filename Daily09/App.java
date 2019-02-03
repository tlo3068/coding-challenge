// This problem was asked by Airbnb.

// Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. 
// Numbers can be 0 or negative.

// For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, 
// since we pick 5 and 5.

// Follow-up: Can you do this in O(N) time and constant space?


public class App {

    public static int largest_non_adjacent(int[] arr){
        int length = arr.length;
        int curr_max = 0;
        int prev_max = 0;

        for(int i = 0; i < length; i++){
            int curr_max_new = max(curr_max, prev_max);
            curr_max = prev_max + arr[i];
            prev_max = curr_max_new;
            
        }
        return max(curr_max, prev_max);
        
    }

    public static int max(int x, int y){
        return (x >= y) ? x: y;
    }
    public static void main(String[] args){
        int[] arr = {2, 4, 6, 2, 5};
        System.out.println(largest_non_adjacent(arr));

    }
}