package leetcodedynamicProgramming;

public class MatrixMultiplicationCost {
    public int findCost(int arr[]){
        int n=arr.length;
        int[][] dp=new int[n][n];
        for(int l=2;l<n;l++){
            for(int i=0;i<n-l;i++){
                int j=i+l;
                dp[i][j]=Integer.MAX_VALUE;
                for (int k=i+1;k<j;k++){
                    int val=dp[i][k]+dp[k][j]+arr[i]*arr[k]*arr[j];
                    if(val<dp[i][j]){
                        dp[i][j]=val;
                    }
                }
            }
        }
        return dp[0][n-1];
    }
    public static void main(String args[]){
        MatrixMultiplicationCost mmc = new MatrixMultiplicationCost();
        int arr[] = {2,3,6,4,5};
        int cost = mmc.findCost(arr);
        System.out.print(cost);
    }
}
