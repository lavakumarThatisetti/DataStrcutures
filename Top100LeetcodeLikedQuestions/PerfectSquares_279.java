package Top100LeetcodeLikedQuestions;

public class PerfectSquares_279 {
    public static int numSquares(int n) {
        int[] record = new int[n+1];
        record[0]=0;
        for(int i=1;i<=n;i++){
            record[i] = i;
            for(int j=1;j*j<=i;j++){
                record[i] = Math.min(record[i-j*j]+1,record[i]);
            }
        }
        return record[n];
    }
    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}
