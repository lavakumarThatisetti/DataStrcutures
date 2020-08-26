package leetcodedynamicProgramming;

import java.util.Scanner;

public class CountingBits_338 {
    private static int[] countingBits(int num){
        int dp[]=new int[num+1];
        dp[0]=0;
        for(int i=1;i<num+1;i++){
            if(i%2==0){
                dp[i]=dp[i/2];
            }else{
                dp[i]=1+dp[i-1];
            }
        }
        return dp;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr=countingBits(n);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
