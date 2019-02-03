// This problem was asked by Twitter.

// Implement an autocomplete system. That is, given a query string s and a set of all possible query strings, 
// return all strings in the set that have s as a prefix.

// For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].

// Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.


// Using a trie
import java.util.*;
import java.lang.*;
class Node {
    public Character current;
    public HashMap<Character, Node> next = new HashMap<Character, Node>();
    public boolean isEnd;
    public Node(Character current, boolean isEnd){
        this.current = current;
        this.isEnd = isEnd;
    }
    public void addNode(char c, Node node){
        next.put(c, node);
    }
    public void set_isEnd(boolean b){
        this.isEnd = b;
    }
}

public class App{
    private HashMap<Character,Node> root = new HashMap<Character, Node>();

    public static void processString(String word, Node trieNode){
        if (word == null){
            trieNode.set_isEnd(true);
            return;
        } 
        char c = word.charAt(0);

        String new_message = null;
        if (word.length() > 1){
            new_message = word.substring(1);
        }

        if (trieNode.next.containsKey(c)){
            Node next_node = trieNode.next.get(c);
            processString(new_message ,next_node);
        }
        else {
            Node next_node = new Node(c, false);
            trieNode.addNode(c, next_node);
            processString(new_message, next_node);
        }
    }   
    public static List<String> queryString(String word, Node rootNode) throws Exception {
        try {
            List<String> possible_strings = new ArrayList<String>();
            Node next_node = rootNode.next.get(word.charAt(0));
            for (int i = 1; i < word.length(); i++){
                next_node = next_node.next.get(word.charAt(i));
                if (next_node == null){
                    throw new Exception("No possible strings");
                }
            }
            if (!next_node.next.isEmpty()){
                Set<Character> next_char = next_node.next.keySet();
                for (char c : next_char){
                    Node next_node2 = next_node.next.get(c);
                    rQuery(word, new String(), next_node2, possible_strings);
                }
            }
            return possible_strings;


        }
        catch (Exception e){
            throw e;
        }

    }

    public static void rQuery(String root, String path, Node current_node, List<String> possible){
        if (current_node.isEnd){
            possible.add(root + path + current_node.current);
        }

        if (!current_node.next.isEmpty()){
            Set<Character> next_char = current_node.next.keySet();
            for (char c : next_char){
                Node next_node = current_node.next.get(c);
                rQuery(root, path + current_node.current, next_node, possible);
            }
        }
        return;
    } 

    public static void main(String[] args){
        System.out.println("Starting...");
        Node root_node = new Node(null, false);
        String new_string = "hello";
        processString(new_string, root_node);
        String new_string2 = "help";
        processString(new_string2, root_node);

        String query_string = "he";
        try {
            List<String> possible_strings = queryString(query_string, root_node);
            for (String s: possible_strings){
                System.out.println(s);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

    }


}