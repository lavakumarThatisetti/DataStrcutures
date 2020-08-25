package dynamicProgramming_leetcode;

import java.util.Scanner;

public class ClimbingStairs_70 {
    private static int climbingStairs(int n){
        if(n==1) return 1;
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        //1<=n<=45
        int n=scan.nextInt();
        System.out.println(climbingStairs(n));

    }
}
