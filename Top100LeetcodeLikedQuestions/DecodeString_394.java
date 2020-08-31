package Top100LeetcodeLikedQuestions;

import java.util.Iterator;
import java.util.Stack;

public class DecodeString_394 {
    public static String decodeString(String s) {
            if(s==null || s.length()==0) return "";
            Stack<Integer> counts = new Stack<>();
            Stack<StringBuilder> values = new Stack<>();
            values.push(new StringBuilder());
            int num = 0;
            for(int i=0;i<s.length();i++){
                char ch = s.charAt(i);
                if(ch>='0' && ch<='9'){
                    num = num*10+ (ch-'0');
                } else if(ch=='['){
                    values.push(new StringBuilder());
                    counts.push(num);
                    num = 0; //reset for next nums
                } else if(ch==']'){
                    String toAppend = values.pop().toString();
                    int count = counts.pop();
                    StringBuilder nsb = new StringBuilder();
                    for(int j=0;j<count;j++){
                        nsb.append(toAppend);
                    }
                    values.push(values.pop().append(nsb.toString()));
                }else{
                    values.peek().append(ch);
                }
            }
            return values.pop().toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }
}
