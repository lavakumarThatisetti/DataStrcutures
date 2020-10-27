package leetcodedynamicProgramming;

public class OptimalTreeSearch {
    public int minCost(int input[], int freq[]){
        int n=input.length;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=freq[i];
        }
        for(int l=2;l<=n;l++){
            for(int i=0;i<=n-l;i++){
                int j=i+l-1;
                int sum=getSum(freq,i,j);
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i+1;k<=j;k++){
                    int val=sum+ (k-1<i?0:dp[i][k-1]+ k+1>j?0:dp[k+1][j]);
                    if(val<dp[i][j])
                        dp[i][j]=val;
                }
            }

        }

        return dp[0][n-1];
    }
    private int getSum(int freq[], int i, int j){
        int sum = 0;
        for(int x = i; x <= j; x++){
            sum += freq[x];
        }
        return sum;
    }
    public static void main(String args[]){
        int input[] = {10,12,20,35,46};
        int freq[] = {34,8,50,21,16};
        OptimalTreeSearch ots = new OptimalTreeSearch();
        System.out.println(ots.minCost(input, freq));
        //System.out.println(ots.minCostRec(input, freq));
    }
}
