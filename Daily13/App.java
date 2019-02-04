// This problem was asked by Amazon.

// Given an integer k and a string s, 
// find the length of the longest substring that contains at most k distinct characters.

// For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
import java.util.*;
public class App {

    public static boolean isValid(String s, int left, int right, int k){
        if (left > right){
            return false;
        }
        HashSet<Character> uniques = new HashSet<Character>();
        for (int i = left; i <= right; i ++){
            uniques.add(s.charAt(i));
        }
        if (uniques.size() > k){
            return false;
        }
        return true;
    }

    public static String longest_substring(String s, int k){
        int left = 0;
        int right = 0;
        int max_left = 0;
        int max_right = 0;
        while (right < s.length()){
            if (isValid(s, left, right, k)){
                right ++;
            }
            else {
                if (right - left > max_right - max_left){
                    max_right = right;
                    max_left = left;
                }
                left ++;
            }
        }
        if (right - left > max_right - max_left){
            max_right = right;
            max_left = left;
        }
        return s.substring(max_left,max_right);
    }

    public static void main(String[] args){
        System.out.println("Starting ...");
        int k = 2;
        String s = "abcbbbbaaaaaa";
        String longest = longest_substring(s, k);
        System.out.println(longest);
    }
}