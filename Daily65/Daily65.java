/**
 * This problem was asked by Amazon.
 *
 * Given a N by M matrix of numbers, print out the matrix in a clockwise spiral.
 */
public class Daily65 {

    private static final int NORTH = 0;
    private static final int EAST = 1;
    private static final int SOUTH = 2;
    private static final int WEST = 3;

    public static void spiral(int[][] matrix, int N, int M){

        int direction = EAST;
        int turns = 0;
        boolean end = false;
        int current_x = 0;
        int current_y = 0;
        while (!end){
            System.out.println(matrix[current_y][current_x]);
            int total_turns = (turns+1)/4;
            switch(direction){
                case EAST: {
                    if (current_x == N - total_turns){
                        direction ++;
                        turns ++;
                    }
                    break;
                }
                case SOUTH: {
                    if (current_y == M - total_turns){
                        direction ++;
                        turns ++;
                    }
                    break;
                }
                case WEST: {
                    if (current_x == 0 + total_turns){
                        direction = 0;
                        turns ++;
                    }
                    break;
                }
                case NORTH: {
                    if (current_y == 0+ total_turns){
                        direction ++;
                        turns ++;
                    }
                    break;
                }
                default: {
                    break;
                }
            }
            total_turns = (turns+1)/4;
            switch(direction){
                case EAST: {
                    if (current_x == N - total_turns){
                        end = true;
                    }
                    current_x += 1;
                    break;
                }
                case SOUTH: {
                    if (current_y == M- total_turns){
                        end = true;
                    }
                    current_y += 1;
                    break;
                }
                case WEST: {
                    if (current_x == 0+ total_turns){
                        end = true;
                    }
                    current_x -= 1;
                    break;
                }
                case NORTH: {
                    if (current_y == 0+ total_turns){
                        end = true;
                    }
                    current_y -= 1;
                    break;
                }
            }
        }

    }
    public static void main (String[] args){
        
        int[][] matrix = new int[5][5];
        for (int i = 1; i <= 5; i ++){
            for (int j = 1; j <= 5; j++){
                matrix[i-1][j-1] = (i-1)*5 + j;
                System.out.format("%d ", matrix[i-1][j-1]);
            }
            System.out.println();
        }
        spiral(matrix,4,4);
    }
} 