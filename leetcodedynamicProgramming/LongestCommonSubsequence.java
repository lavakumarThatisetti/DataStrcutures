package leetcodedynamicProgramming;

public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        int l1=text1.length()+1;
        int l2=text2.length()+1;
        int dp[][]=new int[l1+1][l2+1];
        for(int i=0;i<l1;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<l2;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<l1;i++){
            for(int j=1;j<l2;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[l1-1][l2-1];

    }
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("bsbininm","jmjkbkjkv"));
    }
}
