package Top100LeetcodeLikedQuestions;

import java.util.*;

public class findAnagrams_438 {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result=new ArrayList<>();
        int lenS=s.length();
        int lenP=p.length();
        if (s == null || s.length() == 0 || s.length() < p.length() || s.equals(p))
            return result;
        int index1[]=new int[26];
        int index2[]=new int[26];
        for(int i=0;i<p.length();i++){
            index1[s.charAt(i)-'a']++;
            index2[p.charAt(i)-'a']++;
        }
        for(int i=0;i<=lenS-lenP;i++){
            if(Arrays.equals(index1,index2)){
                result.add(i);
            }
            index1[s.charAt(i)-'a']--;
            if(i+lenP<lenS) index1[s.charAt(lenP+i)-'a']++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd","abc"));
    }
}
