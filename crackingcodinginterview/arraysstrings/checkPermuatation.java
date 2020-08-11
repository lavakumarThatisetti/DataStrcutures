package crackingcodinginterview.arraysstrings;

import java.util.Scanner;

public class checkPermuatation {
    public static void main(String[] args) {
        int[] count=new int[256];
        Scanner scanner=new Scanner(System.in);
        String str1= scanner.next();
        String str2= scanner.next();
        for(int i=0;i<str1.length();i++){
            int val1=str1.charAt(i);
            int val2=str2.charAt(i);
            count[val1]++;
            count[val2]--;
        }
        System.out.println(checkPerm(count));
    }
    private static boolean checkPerm(int[] count){
        for(int i=0;i<256;i++){
            if(count[i]>0) return false;
        }
        return true;
    }
}
