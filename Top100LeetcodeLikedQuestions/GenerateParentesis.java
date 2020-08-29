package Top100LeetcodeLikedQuestions;

import java.util.*;

public class GenerateParentesis {
    public static List<String> generateParenthesis(int n) {

        if(n==1) return new ArrayList<>(Arrays.asList("()"));
        Set<String> set=new HashSet<>();
        for(String str:generateParenthesis(n-1)){
            for(int i=0;i<str.length();i++){
                set.add(str.substring(0,i+1)+"()"+str.substring(i+1));
            }
        }
        List<String> ans=new ArrayList<>(set);
        return ans;
    }

    public static void main(String[] args) {
        generateParenthesis(3);
    }
}
