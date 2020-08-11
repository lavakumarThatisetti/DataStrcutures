package crackingcodinginterview.arraysstrings;

import java.util.Scanner;

public class PlaindromePermuattion {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String str=scan.nextLine();
        str=str.toLowerCase();
        int[] count=new int[256];
        System.out.println(checkPerm(str,count));
    }
    static boolean checkPerm(String str,int[] count){
        for(int i=0;i<str.length();i++){
            count[str.charAt(i)]++;
        }
        int odd=0;
        for(int i=0;i<256;i++){
            if(count[i]%2!=0){
                odd++;
            }
            if(odd>1){
                return false;
            }
        }
        return true;
    }
}
