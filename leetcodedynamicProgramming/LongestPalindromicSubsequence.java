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
     public static int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
    public static void main(String args[]){
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        String str = "bbbab";
        int r2 = lps.calculateLPS(str.toCharArray());
        System.out.print(r2);
        System.out.println(longestPalindromeSubseq(str));
    }
}
