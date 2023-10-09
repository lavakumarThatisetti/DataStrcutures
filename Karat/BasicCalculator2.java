package Karat;

// https://leetcode.com/problems/basic-calculator/

import java.util.Stack;

/*

Given a string s representing a valid expression, implement a basic calculator to evaluate it,
and return the result of the evaluation.

Input: s = " 3+5 / 2 "
Output: 5


Constraints:

1 <= s.length <= 3 * 105
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 231 - 1].
The answer is guaranteed to fit in a 32-bit integer.


*/
public class BasicCalculator2 {

    public static int calculate(String s) {

        /*
          Optimizing stack to constant space we want only one value that is topValue in stack basically we
          called as lastNumber. So when we encounter * or / we can do lastNumber * currentNumber and the res becomes
          lastNumber
         */
        int currentNumber = 0;
        int res = 0;
        int lastNumber = 0;
        char operation = '+';
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                currentNumber= currentNumber*10 + ch-'0';
            }
            if(!Character.isDigit(ch) && !Character.isWhitespace(ch) || i == s.length()-1){
                if(operation == '+'){
                    res+=lastNumber;
                    lastNumber = currentNumber;
                }else if(operation == '-'){
                    res-=lastNumber;
                    lastNumber = -currentNumber;
                }else if(operation == '*'){
                    lastNumber = lastNumber*currentNumber;
                }else if(operation == '/'){
                    lastNumber = lastNumber/currentNumber;
                }
                operation = ch;
                currentNumber = 0;
            }
        }
        res+=lastNumber;
        return res;
    }


    public static int calculateWithStack(String s) {
        // Operations: +, - , *, /
        // * and / has higher precedence
        /*
        " 3+5 / 2 " = 3 + 2 = 5 // First we did 5/2 then added
         */
        int num = 0;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        char operation = '+';
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num= num*10 + ch-'0';
            }
            if(!Character.isDigit(ch) && !Character.isWhitespace(ch) || i == s.length()-1){
                if(operation == '+'){
                    stack.push(num);
                }else if(operation == '-'){
                    stack.push(-num);
                }else if(operation == '*'){
                    stack.push(stack.pop()*num);
                }else if(operation == '/'){
                    stack.push(stack.pop()/num);
                }
                operation = ch;
                num = 0;
            }
        }

        while (!stack.isEmpty())
            res+=stack.pop();

        return res;
    }

    public static void main(String[] args) {

        System.out.println(calculateWithStack(" 3+5 / 2 "));
        System.out.println(calculate(" 3+5 / 2 "));
    }
}
