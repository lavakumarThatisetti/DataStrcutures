package GoldManSAchs;

public class ClimbStairs {
    public static int climbStairs(int n) {
        if(n==1) return 1;
        int first = 1;
        int second = 2;
        int third = 0;
        for(int i=3;i<=n;i++){
            third = first + second;
            second = third;
            first= second;
        }
        return third;
    }
    public static void main(String[] args) {
        System.out.println(climbStairs(44));
    }
}
