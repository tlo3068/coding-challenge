/**
 * This problem was asked by Square.
 *
 * Assume you have access to a function toss_biased() which returns 0 or 1 with a probability that's not 50-50 
 * (but also not 0-100 or 100-0). You do not know the bias of the coin.
 *
 * Write a function to simulate an unbiased coin toss.
 */

public class Daily66 {
    public static int toss_unbiased(){
        int val1 = toss_biased();
        int val2 = toss_biased();

        if (val1 == 1 && val2 == 0){
            return 1;
        }
        if (val1 == 0 && val2 == 1){
            return 0;
        }
        return toss_unbiased();
    }


    public static int toss_biased(){
        return 0
    }

    public static void main(String[] args){
        System.out.println("%d", toss_unbiased());
    }
}