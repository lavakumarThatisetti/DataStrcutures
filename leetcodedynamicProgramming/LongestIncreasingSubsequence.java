package leetcodedynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    private int longestIncresingSubSequence(int[] arr){
        int dp[]=new int[arr.length];
        int n=arr.length;
        for(int i=0;i<n;i++){
            dp[i]=1;
        }
        int i=1,j=0;
        while(i<n){
            if(arr[j]<arr[i]) {
                if (dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
                j++;
            }else {
                if(j+1>=i){
                    j=0;
                    i++;
                }else
                  j++;
            }
        }
        return dp[n-1];
    }
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int arr[] = {3,4,-1,0,6,2,3};
        System.out.println(lis.longestIncresingSubSequence(arr));
        System.out.println(lis.lengthOfLIS(arr));
    }
}
