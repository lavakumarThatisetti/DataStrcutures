package crackingcodinginterview.arraysstrings;

import java.util.Scanner;

public class MimumWindowSubstrin {
    public static String minWindow(String s, String t) {
        int[] index=new int[128];
        for(int i=0;i<t.length();i++){
            index[t.charAt(i)]++;
        }
        int rem=t.length();
        int left=0,right=0,minStart=0,minLen=Integer.MAX_VALUE;
        while(right<s.length()){
            if(--index[s.charAt(right++)]>=0) rem--;
            while(rem==0){
                if(right-left<minLen){
                    minLen=right-left;
                    minStart=left;
                }
                if(++index[s.charAt(left++)]>0) rem++;
            }
        }
        return minLen< Integer.MAX_VALUE ?s.substring(minStart,minStart+minLen):"";
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String s=scan.next();
        String t=scan.next();
        System.out.println(minWindow(s,t));
    }
}
