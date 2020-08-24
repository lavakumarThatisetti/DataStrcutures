package dynamicProgramming_leetcode;

import java.util.Scanner;

public class MinCostClimbingStairs_746 {

    //private static int minCostDP(int[] )
    private static int minCost(int[] cost) {
       /* int step1 = 0;
        int step2 = 0;
        for (int i = cost.length-1; i >=0; i--) {
           int currentStep=cost[i]+Math.min(step1,step2);
           step1=step2;
           step2=currentStep;
        } */

        int step1=cost[0];
        int step2=cost[1];
        for(int i=2;i<cost.length;i++){
            int currentStep=cost[i]+Math.min(step1,step2);
            step1=step2;
            step2=currentStep;
        }
        return Math.min(step1, step2);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] cost = new int[n];
        for (int i = 0; i < n; i++)
            cost[i] = scan.nextInt();
        System.out.println("Min Cost ? " + minCost(cost));
    }
}
