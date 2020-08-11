package crackingcodinginterview.arraysstrings;

import java.util.*;

public class CompressString {
    public static void main(String[] args) {
        StringBuilder stringBuilder=new StringBuilder();
        Scanner scan=new Scanner(System.in);
        String str=scan.next();
        int []index=new int[128];
        LinkedHashSet<Character> lhs = new LinkedHashSet<>();
        for(int i=0;i<str.length();i++){
            index[str.charAt(i)]++;
            lhs.add(str.charAt(i));
        }
        for(Character ch:lhs){
            stringBuilder.append(ch);
            stringBuilder.append(index[ch]);
        }
        if(stringBuilder.toString().length()<str.length())
            System.out.println(stringBuilder.toString());
        else
            System.out.println(str);
    }
}
