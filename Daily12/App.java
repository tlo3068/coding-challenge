// This problem was asked by Amazon.

// There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. 
// Given N, write a function that returns the number of unique ways you can climb the staircase. 
// The order of the steps matters.

//9* For example, if N is 4, then there are 5 unique ways:

// 1, 1, 1, 1
// 2, 1, 1
// 1, 2, 1
// 1, 1, 2
// 2, 2
// 
// For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.

public class App {

    public static int find_ways(int n){
        if (n <= 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        return find_ways(n-1) + find_ways(n-2);
    }

    public static void main(String[] args){

        int total = 4;
        System.out.println(find_ways(total));
    }
}