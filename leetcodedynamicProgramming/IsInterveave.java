package leetcodedynamicProgramming;

public class IsInterveave {
    Boolean dp[][];
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        dp = new Boolean[s1.length()][s2.length()];
        return backtrack(s1,0,s2,0,s3,0);
    }

    public boolean backtrack(String s1,int i, String s2,int j, String s3, int k){
        if(i==s1.length()){
            return s2.substring(j).equals(s3.substring(k));
        }
        if(j==s2.length()){
            return s1.substring(i).equals(s3.substring(k));
        }

        if(dp[i][j]!=null) return dp[i][j];

        boolean ans = s3.charAt(k) == s1.charAt(i) && backtrack(s1, i + 1, s2, j, s3, k + 1)
                || s3.charAt(k) == s2.charAt(j) && backtrack(s1, i, s2, j + 1, s3, k + 1);
        dp[i][j] = ans;
        return ans;
    }

    // time Limit Excced
    public boolean backtrack(String s1,int i, String s2,int j, String s3, int k, String res){
        if(s3.equals(res) && k==s3.length() && i==s1.length() && j==s2.length()) return true;
        if(k>=s3.length()) return false;

        boolean ans = false;
        if(i<s1.length())
            ans |= backtrack(s1, i + 1, s2, j, s3, k + 1, res + s1.charAt(i));
        if(j<s2.length())
            ans |= backtrack(s1, i, s2, j + 1, s3, k + 1, res + s2.charAt(j));
        return ans;
    }

    public static void main(String[] args) {
        IsInterveave isInterveave = new IsInterveave();
        System.out.println(isInterveave.isInterleave("aabcc","dbbca","aadbbcbcac"));
    }
}
