package dynamicProgramming_leetcode;

import java.util.Scanner;

public class MaxSubArray_53 {
    private static int maxSubArray(int[] nums) {
        int max_so_far=nums[0],currMax=nums[0];
        for(int i=1;i<nums.length;i++){
            currMax=Math.max(nums[i],currMax+nums[i]);
            max_so_far=Math.max(max_so_far,currMax);
        }
        return max_so_far;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = scan.nextInt();
        System.out.println("Min SubArray ? " + maxSubArray(array));
    }
}
