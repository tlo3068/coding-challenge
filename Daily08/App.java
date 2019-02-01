// This problem was asked by Google.

// A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.

// Given the root to a binary tree, count the number of unival subtrees.

// For example, the following tree has 5 unival subtrees:

//    0
//   / \
//  1   0
//     / \
//    1   0
//   / \
//  1   1


class Node {
    Node left;
    Node right;
    int val;
    public Node (int val){
        this.val = val;
    }
}
class Count {
    int count = 0;
    public Count(){}

    public void increment(){
        count += 1;
    }
    public int get_count(){
        return this.count;
    }
}
public class App {

    // Accepts the root and also an external counter
    public static boolean unival(Node root, Count c){
        // Count the number of "true"
        if (root == null){
            return true;
        }
        // Check if the next level down is unival
        boolean left_unival = unival(root.left, c);
        boolean right_unival = unival(root.right, c);
        
        // Is only unival if next level is also unival
        if (left_unival == false || right_unival == false){
            return false;
        }
        // Is only unival if the next level values have the same values as current node
        if (root.left != null && root.val != root.left.val){
            return false;
        }
        if (root.right != null && root.val != root.right.val){
            return false;
        }
        // This means both left_unival and right_unival are true
            c.increment();
        return true;
    }

    // Initialize unival count class
    public static int count_unival(Node root){
        Count new_count = new Count();
        unival(root, new_count);
        return new_count.get_count();
    }
    public static void main(String[] args) {
        System.out.println("Starting ...");
        Node node1 = new Node(0);
        Node node2 = new Node(1);
        Node node3 = new Node(0);
        Node node4 = new Node(1);
        Node node5 = new Node(0);
        Node node6 = new Node(1);
        Node node7 = new Node(1);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        node4.left = node6;
        node4.right = node7;
        System.out.println(count_unival(node1));
    }
}