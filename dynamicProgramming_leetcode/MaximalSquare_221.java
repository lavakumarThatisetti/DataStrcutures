package dynamicProgramming_leetcode;

public class MaximalSquare_221 {
    public static int  maximalSquare(int[][] matrix) {
        int m = matrix.length;
        if (m<=0) return 0;
        int n = matrix[0].length;
        if (n<=0) return 0;
        int max=0;
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(matrix[i-1][j-1]==1){
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                    max=Math.max(max,dp[i][j]);
                }
            }
        }
        return max*max;
    }

    public static void main(String[] args) {
        int[][] mat={{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
        System.out.println(maximalSquare(mat));
    }
}
