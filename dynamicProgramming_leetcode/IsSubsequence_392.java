package dynamicProgramming_leetcode;

import java.util.Scanner;

public class IsSubsequence_392 {
    private static boolean isSubSequence(String s,String t){
        int slen=s.length();
        int tlen=t.length();
        if(slen==0) return true;
        int j=0;
        for(int i=0;i<tlen;i++){
            if(j<slen && t.charAt(i)==s.charAt(j)){
                j++;
            }
        }
        return j==slen;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        String t = scan.next();
        System.out.println("is SubSequence ? " + isSubSequence(s,t));
    }
}
