package leetcodedynamicProgramming;

public class LongestIncreasingPath {
    Integer[][] memo;
    public int longestIncreasingPath(int[][] matrix) {
        int ans = Integer.MIN_VALUE;
        memo = new Integer[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                ans =  Math.max(ans, dfs(matrix,i,j, Integer.MIN_VALUE));
            }
        }
        return ans;
    }
    public int dfs(int[][] matrix, int i, int j, int val){
        if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length) return 0;

        if(matrix[i][j] <= val) return 0;

        if(memo[i][j]!=null) return memo[i][j];

        int left = 1+dfs(matrix,i,j-1,matrix[i][j]);
        int up = 1+dfs(matrix,i-1,j,matrix[i][j]);
        int right = 1+dfs(matrix,i,j+1,matrix[i][j]);
        int down = 1+ dfs(matrix,i+1,j,matrix[i][j]);
        memo[i][j] = Math.max(left,Math.max(right, Math.max(up,down)));
        return  memo[i][j];
    }

    public static void main(String[] args) {
        LongestIncreasingPath l = new LongestIncreasingPath();
        System.out.println(l.longestIncreasingPath(new int[][] {{9,9,4},{6,6,8},{2,1,1}}));
    }
}
