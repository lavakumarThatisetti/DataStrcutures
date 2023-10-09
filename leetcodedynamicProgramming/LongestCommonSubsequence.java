package leetcodedynamicProgramming;

public class LongestCommonSubsequence {
    public static int longestCommonSubsequenceDP(String text1, String text2) {
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

    static Integer[][] dp;
    public static int longestCommonSubsequenceBT(String text1, String text2) {

        dp = new Integer[text1.length()][text2.length()];
        return backTrackLCS(text1,text2,0,0);
    }

    public static int backTrackLCS(String s, String t, int i,int j){

        if(i==s.length() || j==t.length()) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j] =  1 + backTrackLCS(s,t,i+1,j+1);
        }else{
            return dp[i][j] = Math.max(
                    backTrackLCS(s,t, i+1, j),
                    backTrackLCS(s,t, i, j+1)
            );
        }
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequenceDP("ezupkr","ubmrapg"));
        System.out.println(longestCommonSubsequenceBT("ezupkr","ubmrapg"));
    }
}
