package crackingcodinginterview.arraysstrings;

import java.util.Scanner;

public class StringRotation {
    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);
        String s1=scan.next();
        String s2=scan.next();
        if(isSubstring(s1,s2)){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }
    private static boolean isSubstring(String s1,String s2){
        return (s1.length()==s2.length())&&((s1+s1).contains(s2));
    }
}
