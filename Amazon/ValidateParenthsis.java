package Amazon;

import java.util.HashMap;
import java.util.Stack;

public class ValidateParenthsis {

    public static boolean isValid(String s) {
        HashMap<Character,Character> map=new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
            }
            else{
                char c =stack.pop();
                if (c != map.get(s.charAt(i))) {
                    return false;
                }
            }
        }
        if(stack.empty()) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("[{[]})"));
    }

}
