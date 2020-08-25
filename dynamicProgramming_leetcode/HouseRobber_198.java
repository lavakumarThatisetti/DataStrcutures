package dynamicProgramming_leetcode;

import java.util.Scanner;

public class HouseRobber_198 {
    public static int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int []dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            int sHouse=dp[i-2]+nums[i];
            int uHouse=dp[i-1];
            dp[i]=Math.max(sHouse,uHouse);
        }
        return dp[nums.length-1];
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = scan.nextInt();
        System.out.println("Min SubArray ? " + rob(array));
    }
}
