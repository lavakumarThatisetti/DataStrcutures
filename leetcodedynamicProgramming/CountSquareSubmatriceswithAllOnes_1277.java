package leetcodedynamicProgramming;

public class CountSquareSubmatriceswithAllOnes_1277 {
    public static int  countSquares(int[][] mat) {
        int m = mat.length;
        if (m<=0) return 0;
        int n = mat[0].length;
        if (n<=0) return 0;
        int count=0;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i < m+1; i++) {
                for(int j=1;j<n+1;j++){
                    if(mat[i-1][j-1]==1) {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                        count += dp[i][j];
                    }
                }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] mat={{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        System.out.println(countSquares(mat));
    }
}
