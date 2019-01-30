// Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, 
// and deserialize(s), which deserializes the string back into the tree.

// For example, given the following Node class

// class Node:
//     def __init__(self, val, left=None, right=None):
//         self.val = val
//         self.left = left
//         self.right = right
// The following test should pass:

// node = Node('root', Node('left', Node('left.left')), Node('right'))
// assert deserialize(serialize(node)).left.left.val == 'left.left'

import java.util.*;
public class Node{

    private String val = null;
    private Node left = null;
    private Node right = null;

    public Node(String val){
        this.val = val;
    }

    public static String serialize(Node root){
        if (root == null) return null;
        String value = root.val;
        String left = serialize(root.left);
        String right = serialize(root.right);
        return String.format("%s,%s,%s", value, left, right);
    
    }
    public static Node deserialize(String s){
        String[] arr = s.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(arr));
            return rdeserialize(data_list); 
    }
    public static Node rdeserialize(List<String> l){
        if (l.get(0).equals("null")){
            l.remove(0);
            return null;
        }
        Node node = new Node(l.get(0));
        l.remove(0);
        node.left = rdeserialize(l);
        node.right = rdeserialize(l);
        return node;
    }

    public static void main(String[] args){
        Node root = new Node("root");
        Node left = new Node("left");
        Node right = new Node("right");
        Node leftleft = new Node("left.left");    
        root.left = left;
        root.right = right;
        left.left = leftleft;

        String serializedRoot = serialize(root);
        System.out.println(serializedRoot);
        System.out.println(deserialize(serializedRoot).left.left.val);
        assert deserialize(serialize(root)).left.left.val == "left.left";
    }
}