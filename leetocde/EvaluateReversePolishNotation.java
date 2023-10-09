package leetocde;

import java.util.Objects;
import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for (String token : tokens) {

            if (Objects.equals(token, "+")) {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(num1 + num2));
            } else if (Objects.equals(token, "*")) {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(num1 * num2));

            } else if (Objects.equals(token, "/")) {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(num1 / num2));

            } else if (Objects.equals(token, "-")) {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(num1 - num2));

            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
