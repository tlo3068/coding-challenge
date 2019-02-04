// This problem was asked by Google.

// The area of a circle is defined as πr^2. Estimate π to 3 decimal places using a Monte Carlo method.

// Hint: The basic equation of a circle is x2 + y2 = r2.

import java.util.*;

public class App {

    private int success = 0;
    private int failure = 0;
    int attempts = 0;
    private Object lock1 = new Object();
    private Object lock2 = new Object();
    
    public App(){}
    public void increment_success(){
        synchronized(lock1){
            this.success ++;
        }
    }
    public void increment_failure(){
        synchronized(lock2){
            this.failure ++;
        }
    }
    public int get_success(){
        return this.success;
    }
    public int get_failure(){
        return this.failure;
    }
    public boolean check_success(double x, double y){
        if (x*x + y*y <= 1){
            return true;
        }
        return false;
    }
    public void generate_random_point(Random random_num){
        double x = (random_num.nextDouble() - 0.5)*2;
        double y = (random_num.nextDouble() - 0.5)*2;

        
            if (check_success(x, y)){
                increment_success();
            }
            else {
                increment_failure();
            }
            // try {
            //     Thread.sleep(1);
            // }
            // catch (Exception e ){}
        
    }

    public void run_threads(){
        Thread t1 = new Thread(new Runnable(){
            public void run(){
                Random random_num = new Random();
                for (int i = 0; i < 1000000; i++){
                    generate_random_point(random_num);
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable(){
            public void run(){
                Random random_num = new Random();
                for (int i = 0; i < 1000000; i++){
                    generate_random_point(random_num);
                }
            }
        });
        t2.start();
        Thread t3 = new Thread(new Runnable(){
            public void run(){
                Random random_num = new Random();
                for (int i = 0; i < 1000000; i++){
                    generate_random_point(random_num);
                }
            }
        });
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){

        long start = System.currentTimeMillis();
        App monte = new App();
        monte.run_threads();

        int success = monte.get_success();
        int failure = monte.get_failure();
        System.out.println("success = " + success + "; total = " + (failure + success));
        float success_rate = (float) success/(success+failure);
        float pi = success_rate * 4;
        System.out.println(pi);

        long end = System.currentTimeMillis();

        System.out.println("Time taken: " + (end - start));
    }
}