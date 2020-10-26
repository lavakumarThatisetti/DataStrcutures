package leetcodedynamicProgramming;

public class SubsetSumProblem {
    private boolean partition(int[] arr){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        sum=sum/2;
        if(sum%2!=0) return false;
        boolean dp[][]=new boolean[arr.length+1][sum+1];

        for(int i=0;i<arr.length+1;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<=arr.length;i++){
            for(int j=1;j<=sum;j++){
                if((j<arr[i-1]) || dp[i-1][j]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j-arr[i-1]];
                }
            }
        }
        return dp[arr.length][sum];
    }
    private boolean subsetSum(int[] arr,int sum){
        boolean dp[][]=new boolean[arr.length+1][sum+1];

        for(int i=0;i<arr.length+1;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<=arr.length;i++){
            for(int j=1;j<=sum;j++){
                if((j<arr[i-1]) || dp[i-1][j]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j-arr[i-1]];
                }
            }
        }
        return dp[arr.length][sum];
    }
    public static void main(String[] args) {
        SubsetSumProblem ss = new SubsetSumProblem();
        int arr[] = {1, 3, 5, 5, 2, 1, 1, 6};
        System.out.println(ss.partition(arr));

        int arr1[] = {2, 3, 7, 8};
        System.out.print(ss.subsetSum(arr1, 11));
    }
}
