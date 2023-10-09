package leetocde;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ParsingABooleanExpression {
    public boolean parseBoolExpr(String exp) {

        Stack<Character> stack  = new Stack<>();

        for(int i=0;i<exp.length();i++){
            char c = exp.charAt(i);
            if(c == ')'){
                Set<Character> set = new HashSet<>();
                while(stack.peek()!='('){
                    set.add(stack.pop());
                }
                stack.pop(); // poping out '('

                char operator = stack.pop(); // pop Operator

                if(operator == '&'){
                    stack.push(set.contains('f') ? 'f' : 't');
                }else if(operator == '|'){
                    stack.push(set.contains('t') ? 't' : 'f');
                }else if(operator == '!'){
                    stack.push(set.contains('f') ? 't' : 'f');
                }

            }
            else if(c!=',') {
                stack.push(c);
            }
        }
        return stack.pop() == 't';
    }

    public static void main(String[] args) {
        ParsingABooleanExpression parsingABooleanExpression = new ParsingABooleanExpression();
        parsingABooleanExpression.parseBoolExpr("!(f)");
    }
}
