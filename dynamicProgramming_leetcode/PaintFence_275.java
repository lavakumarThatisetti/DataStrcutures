package dynamicProgramming_leetcode;

import java.util.Scanner;

public class PaintFence_275 {
    private static long paintFence(int n,int k){
        if(n == 0)
            return 0;
        if(n == 1)
            return k;
        int same = k;
        int diff = k * (k-1);
        for(int i = 3; i <= n; i++) {
            int same1 = diff;
            int diff2 = (same + diff) * (k-1);
            same = same1;
            diff = diff2;
        }
        return (same + diff);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        System.out.println(paintFence(n,k));
    }
}
