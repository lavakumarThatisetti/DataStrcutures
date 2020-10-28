package leetcodedynamicProgramming;

public class CuttingRod {
    private int cuttingRodMaxValue(int[] profit,int len){
        int n=profit.length;
        int dp[][]=new int[n+1][len+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<len+1;j++){
                if(j<i){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],profit[i-1]+dp[i][j-i]);
                }
            }
        }
        return dp[n][len];
    }

    private int cuttingRodMaxValue1(int[] profit,int n){
            int val[] = new int[n+1];
            val[0] = 0;
            // Build the table val[] in bottom up manner and return
            // the last entry from the table
            for (int i = 1; i<=n; i++)
            {
                int max_val = Integer.MIN_VALUE;
                for (int j = 0; j < i; j++)
                    max_val = Math.max(max_val,
                            profit[j] + val[i-j-1]);
                val[i] = max_val;
            }

            return val[n];
    }
    public int maxValue1(int price[]){
        int max[] = new int[price.length+1];
        for(int i=1; i <= price.length; i++){
            max[i] = price[i-1];
        }
        for(int i=1 ; i <= price.length; i++){
            for(int j=1; j < i ; j++){
                max[i] = Math.max(max[i], max[i-j] + max[j]);
            }
        }
        return max[price.length];
    }
    public static void main(String[] args) {
            CuttingRod cr =new CuttingRod();
            int[] price = {2,5,7,8,10};
            int r = cr.cuttingRodMaxValue(price,5);
            System.out.println(r);
            r = cr.cuttingRodMaxValue1(price,5);
            System.out.println(r);
            System.out.println(cr.maxValue1(price));
    }
}
