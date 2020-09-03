package Top100LeetcodeLikedQuestions;

import java.util.Map;
import java.util.Stack;

public class RemoveGreaterKCharacters {
    static class Entity{
        char character;
        int frequency;
        Entity(char character,int frequency){
            this.character=character;
            this.frequency=frequency;
        }
    }
    private static String removeKchar(String str,int n,int k){
        Stack<Entity> stack=new Stack<>();
        for(int i=0;i<n;i++){
            char x=str.charAt(i);
            if(stack.size()>0 && stack.peek().character==x){
                Entity entity=new Entity(x,stack.peek().frequency+1);
                stack.pop();
                stack.push(entity);
            }else {
                Entity entity = new Entity(x, 1);
                stack.push(entity);
            }
        }
        StringBuilder res=new StringBuilder();
        while (stack.size()>0){
            int freq=stack.peek().frequency;
            if(freq<k){
                for(int i=0;i<freq;i++)
                    res.append(stack.peek().character);
            }
            stack.pop();
        }
        return res.reverse().toString();
    }
    public static void main(String[] args) {
        String s="abbcccdeaffff";
        System.out.println(removeKchar(s,s.length(),3));
    }
}
