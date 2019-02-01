// This problem was asked by Facebook.

// Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

// For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

// You can assume that the messages are decodable. For example, '001' is not allowed.

import java.util.Scanner; 
public class App {


    // Solved recursively
    // Add the ways you can make strings using 1 and 2 characters
    // Consider the number 0
    // Consider the limit 26
    public static int decode(String message){
        if (message.isEmpty()){
            return 0;
        }
        int first_char = toInt(message.charAt(0));
        if (first_char == 0){
            return 0;
        }
        if (message.length() == 1){
            return 1;
        }
        StringBuffer s = new StringBuffer(message);
        String new_message = s.substring(1);
        String new_message_2 = s.substring(2);
        int second_char = toInt(message.charAt(1));
        if (message.length() == 2){
            if (first_char <= 2 && second_char <= 6){
                return 1 + decode(new_message);
            }
            return decode(new_message);
        }
        else {
            if( first_char <= 2 && second_char <= 6){
                return decode(new_message) + decode(new_message_2);
            }
            return decode(new_message);
        }
    
    }
    public static int toInt(char a){
        if (a >= '0' && a <= '9'){
            return a - '0';
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Starting ...");        


        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        System.out.println(s);
        int total = decode(s);
        System.out.println("Total: " + total);
    }
}