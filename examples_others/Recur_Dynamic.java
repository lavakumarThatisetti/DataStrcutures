package examples_others;


import java.util.HashMap;

public class Recur_Dynamic {
    HashMap<Integer,Integer> cache = new HashMap<>();
    public int findQuadracci_naive(int n) {
        if(cache.get(n)!=null) return cache.get(n);
        if(n==0) return 0;
        if(n==1 || n==2 || n==3) return 1;
        cache.put(n,
        findQuadracci_naive(n-4) + findQuadracci_naive(n-3) + findQuadracci_naive(n-2)
                + findQuadracci_naive(n-1));
        return cache.get(n);
    }
    public int findQuadracci_dynamic_programming(int n) {
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        dp[3]=1;
        for(int i=4;i<=n;i++){
            dp[i] = dp[i-4] + dp[i-3] + dp[i-2] + dp[i-1];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Recur_Dynamic recur_dynamic = new Recur_Dynamic();
        System.out.println(recur_dynamic.findQuadracci_naive(100));
        System.out.println(recur_dynamic.findQuadracci_dynamic_programming(100));
    }
}
