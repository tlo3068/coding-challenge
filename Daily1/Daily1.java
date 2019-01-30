// Given a list of numbers and a number k, return whether any two numbers from the list add up to k

// For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17
// Bonus: Can you do this in one pass

import java.util.*;

public class Daily1 {

    public Daily1(){}

    public static Boolean possibleSum(int[] numbers, int k){
        HashSet<Integer> visited = new HashSet<Integer>();
        for (int number: numbers){
            if (visited.contains(number)){
                return true;
            }
            int remainder = k - number;
            visited.add(remainder);
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println("Daily 1 running");
        int[] numbers = {9, 15, 3, 7};
        int k = 17;
        System.out.println(possibleSum(numbers, k));
    }
}