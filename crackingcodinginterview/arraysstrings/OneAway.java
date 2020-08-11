package crackingcodinginterview.arraysstrings;

import java.util.Scanner;

public class OneAway {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String str1=scan.next();
        String str2=scan.next();

        System.out.println(isOneAway(str1,str2));

    }
    private static boolean isOneAway(String str1,String str2){
        int m=str1.length();
        int n=str2.length();
        if(Math.abs(m-n)>1) return false;
        int i=0,j=0,count=0;
        while(i<m && j<n){
            if(str1.charAt(i)!=str2.charAt(j)){
                if(count==1)
                    return false;
                if(m>n)
                    i++;
                else if(m<n)
                    j++;
                else{
                    i++;
                    j++;
                }
                count++;
            }else{
                i++;
                j++;
            }
        }
        if(i<m || j<m)
            count++;
        return count==1;
    }
}
