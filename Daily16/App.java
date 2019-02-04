
// Probably try a circular buffer?

public class App {

    public final HashMap<Integer, Integer> logs= new HashMap<Integer, Integer> ();
    public int size = 0;

    public class App(){}

    public void record(int order_id){
        logs.put(++size, order_id);
    }
    public int get_last(int i ){
        return size - i;
    }

    public static void main(String[] args){
        System.out.println("Starting ...");
    }
}