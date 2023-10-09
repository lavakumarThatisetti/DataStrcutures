package leetcodedynamicProgramming;

public class CoinChange2 {
    Integer[][] dp;
    public int change(int amount, int[] coins) {
        dp = new Integer[coins.length][amount+1];
        return backTrack(coins,amount,0);
    }

    public int backTrack(int[] coins, int amount, int i){
        if(amount==0) return 1;
        if(amount<0) return 0;
        if(i>=coins.length) return 0;
        if(dp[i][amount]!=null) return dp[i][amount];

        dp[i][amount] =  backTrack(coins, amount - coins[i], i) + backTrack(coins, amount, i + 1);
        return dp[i][amount];
    }
    public static void main(String[] args) {
        CoinChange2 coinChange2 = new CoinChange2();
        System.out.println(coinChange2.change(5, new int[]{1,2,5}));
    }
}
