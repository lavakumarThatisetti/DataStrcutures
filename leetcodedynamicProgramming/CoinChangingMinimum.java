package leetcodedynamicProgramming;

import java.util.Arrays;
import java.util.Map;

public class CoinChangingMinimum {

    private int coinChangingMinimum(int[] arr,int total){
        int[][] dp=new int[arr.length+1][total+1];
        for(int i=0;i<arr.length+1;i++){
            dp[i][0]=0;
        }
        for(int i=1;i<total+1;i++){
            dp[0][i]=i;
        }
        int ans=Integer.MAX_VALUE;
        for(int i=1;i<arr.length+1;i++){
            for(int j=1;j<total+1;j++){
                if(j<arr[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]= Math.min(dp[i][j-arr[i-1]]+1,dp[i-1][j]);
                }
            }
            if(dp[i][total]<ans)
                ans=dp[i][total];
        }
        return ans;
    }
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(coins[j]<=i){
                    dp[i]= Math.min(dp[i-coins[j]]+1,dp[i]);
                }
            }
        }
        return dp[amount]>amount ?-1:dp[amount];
    }
    public static void main(String[] args) {
        CoinChangingMinimum cc = new CoinChangingMinimum();
        int arr[] = {1,2,5};
        System.out.println(cc.coinChangingMinimum(arr,11));
        System.out.println(cc.coinChange(arr,11));
    }
}

