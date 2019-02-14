// This problem was asked by Facebook.

// A builder is looking to build a row of N houses that can be of K different colors. 
// He has a goal of minimizing cost while ensuring that no two neighboring houses are of the same color.

// Given an N by K matrix where the nth row and kth column represents the cost to build the nth house with kth color, 
// return the minimum cost which achieves this goal

class heuristic {

    final int MAX = 99999;
    int[][] matrix;
    int[] heuristic;
    public heuristic(int[][] matrix){
        this.matrix = matrix;
        initHeuristic(matrix);
    }

    public void initHeuristic(int[][] matrix){
        heuristic = new int[matrix.length];
        int total = 0;
        for (int i = matrix.length - 1; i >= 0; i--){
            int min = MAX;
            for (int j = 0; j < matrix[i].length; j++){
                if (matrix[i][j] < min){
                    min = matrix[i][j];
                }
            }
            total += min;
            heuristic[i] = total;
        }
    }

    public static int get_heuristic(int depth){
        return heuristic[depth];
    }
}

class Node {
    int g_cost;
    int h_cost;
    int f_cost;
    Node prev_node;
    int color;

    public Node(int g, int depth, Node prev_node, int color){
        this.g_cost = g;
        this.h_cost = get_heuristic(depth);
        this.f_cost = g_cost + h_cost;
        this.prev_node = prev_node;
        this.color = color;
    }

}
public class App {

    // A* search
    public static int a_search(int[][] matrix){
        HashSet<Node> visited = new HashSet<Node>();
        HashSet<Node> unvisited = new HashSet<Node>();
        // Store up to current path;
        // Add herustic and check if less than min
        unvisited.add(new Node(0, 0, null, 0));
        int curr_depth = 0;
        
        while (!unvisited.isEmpty()){
            Node current = get_lowest(unvisited);
            if (curr_depth == matrix.length){
                return curr.g_cost;
            }    
            unvisited.remove(current);
            visited.add(current);

            for (int i = 0; i < matrix[curr_depth].length ; i++){
                if (i != current.color){
                    int tentative_g_score = current.g_cost + node;
                    unvisited.add(new Node(tentative_g_score, curr_depth + 1, current, i));
    
                }
            }

            curr_depth += 1;
        }
        
    }

    public static void main(String[] args){
        System.out.println("Starting ...");
    }
}