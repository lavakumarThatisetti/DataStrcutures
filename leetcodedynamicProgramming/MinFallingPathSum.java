package leetcodedynamicProgramming;

public class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n+2];

        for(int i=0;i<n+2;i++){
            dp[0][i] = Integer.MAX_VALUE;
        }
        for(int i=1;i<n+1;i++){
            dp[0][i] = matrix[0][i-1];
        }
        for(int i=0;i<m;i++){
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][n+1] = Integer.MAX_VALUE;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n+1;j++){
                dp[i][j] = matrix[i][j-1] + Math.min(
                        dp[i-1][j],
                        Math.min(dp[i-1][j-1],dp[i-1][j+1]));
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=1;i<=n+1;i++){
            ans = Math.min(ans,dp[m-1][i]);
        }
        return ans;

    }

    public static void main(String[] args) {
        MinFallingPathSum minFallingPathSum = new MinFallingPathSum();
        System.out.println(minFallingPathSum.minFallingPathSum(new int[][]{{2,1,3},{6,5,4},{7,8,9}}));

    }
}
