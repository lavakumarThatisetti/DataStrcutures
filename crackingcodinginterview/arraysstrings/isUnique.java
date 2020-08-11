package crackingcodinginterview.arraysstrings;

import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class isUnique {
    public static void main(String[] args) {
        boolean arr[]=new boolean[256];
        Scanner scan=new Scanner(System.in);
        String str=scan.next();
      //  System.out.println(is_Unique(str,arr));
        System.out.println(areChractersUnique(str));
    }
    private static boolean is_Unique(String str,boolean[] arr){
        for(int i=0;i<str.length();i++){
            int index=str.charAt(i);
            if(arr[index]){
                return false;
            }
            arr[index]=true;
        }
        return true;
    }
    boolean uniqueCharacters(String s)
    {
        return s.chars().filter(e-> Collections.frequency(s.chars().boxed().collect(Collectors.toList()), e) > 1).count() > 1 ? false: true;
    }
    static boolean areChractersUnique(String str)
    {
        int checker = 0;
        for (int i = 0; i < str.length(); ++i)
        {
            int val = (str.charAt(i)-'a'); //For only alphabets for all we need to remove -'a'
            // If bit corresponding to current
            // character is already set
            if ((checker & (1 << val)) > 0)
                return false;
            // set bit in checker
            checker |= (1 << val);
        }
        return true;
    }
}
