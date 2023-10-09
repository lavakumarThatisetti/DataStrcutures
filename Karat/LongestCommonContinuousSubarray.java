package Karat;

/*
User1: ["hi", "bye", "hello", "leetcode", "start", "end"]
User2: ["hi", "stop", "leetcode", "start", "end", "bye"]

Output: ["leetcode", "start", "end"]

 */


import java.util.Arrays;
import java.util.List;

public class LongestCommonContinuousSubarray {

    public static List<String> longestCommonContinuousSubArray(String[] a, String[] b){

        int aLen = a.length;
        int bLen = b.length;
        int[][] dp = new int[aLen+1][bLen+1];

        int maxLength = 0;
        int endIndex = 0;
        for(int i=1;i<=aLen;i++){
            for(int j=1;j<=bLen;j++){
                if(a[i-1].equals(b[j-1])){
                    dp[i][j] = dp[i-1][j-1]+1;
                    if(dp[i][j] > maxLength){
                        endIndex = i;
                        maxLength = dp[i][j];
                    }
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return Arrays.asList(a).subList(endIndex-maxLength, endIndex);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonContinuousSubArray(
                new String[]{"hi", "bye", "hello", "leetcode", "start", "end"},
                new String[]{"hi", "stop", "leetcode", "start", "end", "bye"}));
    }
}
