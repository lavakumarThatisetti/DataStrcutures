package leetcodedynamicProgramming;

public class RegexMatching {
    public boolean matchRegex(char[] text, char[] pattern) {
        boolean[][] dp = new boolean[text.length+1][pattern.length+1];
        dp[0][0]=true;
        for(int i=1;i<dp[0].length;i++){
            if(pattern[i-1]=='*')
                dp[0][i]=dp[0][i-2];
        }
        for(int i=1;i<text.length+1;i++){
            for(int j=1;j<pattern.length+1;j++){
                if(text[i-1]==pattern[j-1] || pattern[j-1]=='.')
                    dp[i][j]=dp[i-1][j-1];
                else if(pattern[j-1]=='*'){
                    dp[i][j]=dp[i][j-2];
                    if(pattern[j-1]=='.' || text[i-1]==pattern[j-2]){
                        dp[i][j]=dp[i][j]||dp[i-1][j];
                    }
                }else{
                    dp[i][j]=false;
                }
            }
        }
        return dp[text.length][pattern.length];
    }
    public static void main(String args[]){
        RegexMatching rm = new RegexMatching();
//        System.out.println(rm.matchRegexRecursive("Tushar".toCharArray(),"Tushar".toCharArray()));
//        System.out.println(rm.matchRegexRecursive("Tusha".toCharArray(),"Tushar*a*b*".toCharArray()));
//        System.out.println(rm.matchRegexRecursive("".toCharArray(),"a*b*".toCharArray()));
//        System.out.println(rm.matchRegexRecursive("abbbbccc".toCharArray(),"a*ab*bbbbc*".toCharArray()));
//        System.out.println(rm.matchRegexRecursive("abbbbccc".toCharArray(),"aa*bbb*bbbc*".toCharArray()));
//        System.out.println(rm.matchRegexRecursive("abbbbccc".toCharArray(),".*bcc".toCharArray()));
//        System.out.println(rm.matchRegexRecursive("abbbbccc".toCharArray(),".*bcc*".toCharArray()));
//        System.out.println(rm.matchRegexRecursive("abbbbccc".toCharArray(),".*bcc*".toCharArray()));
//        System.out.println(rm.matchRegexRecursive("aaa".toCharArray(),"ab*a*c*a".toCharArray()));

        System.out.println(rm.matchRegex("xaabyc".toCharArray(), "xa*b.c".toCharArray()));
    }
}
