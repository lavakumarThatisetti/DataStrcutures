package Karat;

// Find all 0 areas you can go to
// Given a 2D matrix, -1 represents walls and 0 represents roads.
// Ask if a starting point coordinate is 0, whether all 0s can be reached.
public class FindLegalMoves {

    public static boolean findLegalMoves(int[][] matrix, int x, int y){

        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];

        dfs(matrix,x,y,visited);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && matrix[i][j] ==0 ) return false;
            }
        }
        return true;
    }

    public static void dfs(int[][] matrix, int i , int j, boolean[][] visited){
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == -1 || visited[i][j]) {
            return;
        }

        visited[i][j] = true;
        dfs(matrix,i+1,j,visited);
        dfs(matrix,i-1,j,visited);
        dfs(matrix,i,j+1,visited);
        dfs(matrix,i,j-1,visited);
    }


    public static void main(String[] args) {

        /*
         0 -1  0
         0  0  0
        -1  0 -1
         */
        int[][] matrix = {{0,-1,0}, {0,0,0},{-1,0,-1}};
        System.out.println(findLegalMoves(matrix,1,2));

         /*
         0 -1  0
         0  0  0
        -1  0 -1
        -1 -1 -1
         0  0  0
         */
        matrix = new int[][]{{0,-1,0}, {0,0,0},{-1,0,-1},{-1,-1,-1},{0,0,0}};
        System.out.println(findLegalMoves(matrix,3,3));
    }
}
