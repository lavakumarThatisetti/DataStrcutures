package problemsolving;

public class FibanociCache {

    public static void allFib(int n){
        long[] memo=new long[n+1];
        for(int i=0;i<n;i++){
            System.out.println(fibNum(i,memo));
        }

    }
    public static long fibNum(int n,long[] memo){
        if(n<=0) return 0;
        else if (n==1) return  1;
        else if(memo[n]>0) return memo[n];
        memo[n]=fibNum(n-1,memo)+fibNum(n-2,memo);

        return memo[n];
    }
    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        allFib(50);
        long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
