package leetcodedynamicProgramming;

public class CoinChangingNOF {
    private int coinchange(int total,int[] arr){
        int[][] dp=new int[arr.length+1][total+1];
        for(int i=0;i<arr.length+1;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<arr.length+1;i++){
            for(int j=1;j<total+1;j++){
                if(j<arr[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-arr[i-1]];
                }
            }
        }
        return dp[arr.length][total];
    }
    public int numberOfSolutionsOnSpace(int total, int arr[]){
        int temp[] = new int[total+1];

        temp[0] = 1;
        for(int i=0; i < arr.length; i++){
            for(int j=1; j <= total ; j++){
                if(j >= arr[i]){
                    temp[j] += temp[j-arr[i]];
                }
            }
        }
        return temp[total];
    }
    public static void main(String[] args) {
        CoinChangingNOF cc = new CoinChangingNOF();
        int total = 5;
        int coins[] = {1,2,3};
        System.out.println(cc.coinchange(total, coins));
        System.out.println(cc.numberOfSolutionsOnSpace(total,coins));
    }
}
