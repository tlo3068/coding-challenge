// Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.

// For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.

// In this example, assume nodes with the same value are the exact same node objects.

// Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.


class Node {
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

}
public class App {

    public static Node findNode(Node list1, Node list2) throws Exception{
        int lengthM = listLength(list1);
        int lengthN = listLength(list2);
        int difference = (lengthM > lengthN) ? lengthM - lengthN : lengthN - lengthM;
        Node start1 = list1;
        Node start2 = list2;
        try {
            if (lengthM > lengthN){
                start1 = iterate(list1, difference);
            }
            else {
                start2 = iterate(list2, difference);
            }
        }
        catch (Exception e ){
            throw e;
        }
        while (start1 != null && start2 != null && start1.data != start2.data){
            start1 = start1.next;
            start2 = start2.next;
        }
        if (start1 == null || start2 == null || start1.data != start2.data){
            throw new Exception("No common node");
        }
        return start1;
    }
    public static int listLength(Node root){
        int length = 0;
        Node current = root;
        while (current != null){
            length++;
            current = current.next;
        };
        return length;
    }
    public static Node iterate(Node root, int length) throws Exception{
        int total = length;
        Node tempNode = root;
        while (root != null && total != 0){
            total -= 1;
            tempNode = tempNode.next;
        }
        if (total > 0){
            throw new Exception("Could not iterate length");
        }
        return tempNode;
    }

    public static void main(String[] args){
        System.out.println("Starting ...");

        Node a1 = new Node(3);
        Node a2 = new Node(7);
        Node a3 = new Node(2);
        Node a4 = new Node(10);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        Node b1 = new Node(99);
        Node b2 = new Node(1);
        Node b3 = new Node(2);
        Node b4 = new Node(10);
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        try {
            System.out.println(findNode(a1, b1).data);
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
}