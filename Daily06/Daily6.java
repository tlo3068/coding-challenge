// This problem was asked by Google.

// An XOR linked list is a more memory efficient doubly linked list. 
// Instead of each node holding next and prev fields, it holds a field named both, 
// which is an XOR of the next node and the previous node. 
// Implement an XOR linked list; it has an add(element) which adds the element to the end,
// and a get(index) which returns the node at index.

// If using a language that has no pointers (such as Python), you can assume you have access to 
// get_pointer and dereference_pointer functions that converts between nodes and memory addresses.

class Node {
    private long link_field;

    public Node(long link_field){
        this.link_field = link_field;
    }
    public void set_link_field(long link_field){
        this.link_field = link_field;
    }
    public long get_link_field(){
        return this.link_field;
    }
    // Incomplete
    public void add(Node node){
        long next = get_pointer(node);
        node.set_link_field(this.link_field);
        this.link_field = next ^ link_field;
    }
    // Incomplete
    public Node get(int index){
                
        long current_address = 0;
        long next_address = this.link_field;
        long next_next_address = current_address ^ next_address;

        Node current_node = null;
        Node next_node = this;
        Node next_next_node = dereference_pointer(next_next_address);

        while (int i = 0; i < index; i++){
            current_address = next_address;
            next_address = next_next_address;
            next_next_address = next_next_node.get_link_field() ^ next_address;    
            Node next_next_node = dereference_pointer(next_next_address);
        }

        return current_address;

    }
    // public Node dereference_pointer(long address){}
    // public void get_pointer(Node node){}
}