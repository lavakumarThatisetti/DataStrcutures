package leetcodedynamicProgramming;

public class LongestPalindromicSubsequence {
    private int calculateLPS(char[] arr){
        int n=arr.length;
        int[][] dp=new int[n][n];

        for(int i=0;i<n;i++){
            dp[i][i]=1;
        }
        for(int l=2;l<=n;l++){
            for(int i=0;i<=n-l;i++){
                int j=i+l-1;
                if(arr[i]==arr[j]){
                    dp[i][j]=(l==2) ? 2: 2+dp[i+1][j-1];
                }else {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }
        return dp[0][n-1];
    }
    public static void main(String args[]){
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        String str = "agbdba";
        int r2 = lps.calculateLPS(str.toCharArray());
        System.out.print(r2);
    }
}
