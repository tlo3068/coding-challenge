// This problem was asked by Facebook.

// Given a stream of elements too large to store in memory, 
// pick a random element from the stream with uniform probability.

import java.util.*;
class Node {
    int data;
    Node next;
    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
    public void setNext(Node next){
        this.next = next;
    }
    public boolean hasNext(){
        if (this.next != null){
            return true;
        }
        return false;
    }
    public String toString(){
        return "Node: " + this.data;
    }
}

public class App {

    public static Node randomly_pick(Node root){
        int i = 1;
        Node current = root;
        Node stored_value = null;
        Random random = new Random();
        while (current != null){
            // System.out.println(current.data);
            if (random.nextFloat() <= (float) 1/i){
                stored_value = current;
            }
            i++;
            current = current.next;
        }
        // First value must be 100%
        // Second will have 50% chance of swapping
        // Third will have 33% chance of swapping
        return stored_value;
    }

    public static void main(String[] args){

        Node next9 = new Node(10, null);
        Node next8 = new Node(9, next9);
        Node next7 = new Node(8, next8);
        Node next6 = new Node(7, next7);
        Node next5 = new Node(6, next6);
        Node next4 = new Node(5, next5);
        Node next3 = new Node(4, next4);
        Node next2 = new Node(3, next3);
        Node next = new Node(2, next2);
        Node root = new Node(1, next);
        // root.setNext(next);
        int[] numbers = new int[10];
        Arrays.fill(numbers, 0);
        for (int i = 0; i < 100000; i++){
            Node node = randomly_pick(root);
            int value = node.data;
            numbers[value-1] += 1;
        }
        // System.out.println(randomly_pick(root));
        System.out.println(Arrays.toString(numbers));
    }
}