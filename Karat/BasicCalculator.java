package Karat;

// https://leetcode.com/problems/basic-calculator/

import java.util.Stack;

/*

Given a string s representing a valid expression, implement a basic calculator to evaluate it,
and return the result of the evaluation.

s = " 2-1 + 2 " = 3
s = "(1+(4+5+2)-3)+(6+8)" = 23


*/
public class BasicCalculator {

    public static int calculate(String s) {
        // Only + and / operation
        // 4 + 5 = 9 -> here we will get + first than 5 . So we dont have really two variables to add.
        // So we need to think in different way. Like adding every variable to result and while adding based
        // on Sign ( + or -) take care

        int sign = 1; // first its Operation;
        int num = 0;
        int res = 0;
        Stack<Integer> stack = new Stack<>();

        // Maintain Sign in Stack compare . Multiply the num based on stack peek and current operation
        stack.push(sign);
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num= num*10 + ch-'0';
            }
            else if(ch == '+' || ch=='-'){
                res+=num*sign;
                sign = stack.peek() * (ch== '+'?1:-1);
                num = 0;
            }else if(ch == ')'){
                stack.pop();
            }else if(ch =='('){
                stack.push(sign);
            }
        }
        // for last value
        res +=num*sign;
        return res;
    }

    public static void main(String[] args) {

        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
