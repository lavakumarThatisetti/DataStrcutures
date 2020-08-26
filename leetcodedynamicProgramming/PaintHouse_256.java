package leetcodedynamicProgramming;

import java.util.Scanner;

public class PaintHouse_256 {

    private static int paintHouse(int[][] cost){
        if(cost==null || cost.length==0) return 0;

        for(int i=1;i<cost.length;i++){
            cost[i][0]+=Math.min(cost[i-1][1],cost[i-1][2]);
            cost[i][1]+=Math.min(cost[i-1][0],cost[i-1][2]);
            cost[i][2]+=Math.min(cost[i-1][0],cost[i-1][1]);
        }
        int len=cost.length-1;
        return Math.min(cost[len][0],Math.min(cost[len][1],cost[len][2]));
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int[][] cost=new int[n][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++)
               cost[i][j]=scan.nextInt();
        }
        System.out.println("Minimum cost "+paintHouse(cost));

    }
}
