package dynamicProgramming_leetcode;

import java.util.Scanner;

public class RangeSumQueryImmutable_303 {
    private int[] data;
    private RangeSumQueryImmutable_303(int[] nums) {
        data=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            data[i+1]=data[i]+nums[i];
        }
    }
    private int sumRange(int i, int j) {
        return data[j+1]-data[i];
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = scan.nextInt();
        RangeSumQueryImmutable_303 obj=new RangeSumQueryImmutable_303(nums);
        System.out.println(obj.sumRange(2,5));
    }
}
