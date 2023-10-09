package problemsolving;

public class OptimalGameStrategy {
    private static int optimalStrategyOfGame(int[] arr,int n){
        int dp[][] =new int[n][n];
        int x=0,y=0,z=0;
        for(int gap=0;gap<n;gap++){
            for(int i=0,j=gap;j<n;++i,++j){
                x = ((i+2)<=j)? dp[i+2][j]:0;
                y = ((i+1)<=(j-1)) ?dp[i+1][j-1]:0;
                z= (i<=j-2)?dp[i][j-2]:0;
                dp[i][j]=Math.max(arr[i]+Math.min(x,y),arr[j]+Math.min(y,z));
            }
        }
        return dp[0][n-1];
    }
    public static void main(String[] args) {
        int arr1[] = { 8, 15, 3, 7 };
        int n = arr1.length;
        System.out.println(optimalStrategyOfGame(arr1, n));
    }
}
