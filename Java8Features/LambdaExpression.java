package Java8Features;

import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Lambda Expressions  For functional Programming
 * Its an anonymous functions NameLess
 * without return type
 * without modifiers
 * -> is the symbol for lambda
 * Curly Braces are not required if expression has one line
 */

/**
 * Functional Interface
 * Runnable  ==> run()
 * Comparable ==> compareTo()
 * Comparator ==> compare()
 * ActionListener ==> actionPerformed
 * Callable ==> call
 * All these contains only one method
 * A interface which contains single abstract function such interfaces are call
 * functional interfaces
 * to invoke lambda expression Compulsory Functional Interface required
 */

public class LambdaExpression {
    // Function
    private static Function<Integer,Integer> square = i->i*i;
    // Predicate
    private static Predicate<Integer> evenCheck = i->i%2==0;


    public static void main(String[] args) {
        System.out.println(square.apply(5));
        System.out.println(evenCheck.test(5));

        //() -> System.out.println("Hello");
        //(a,b)-> System.out.println((a+b);
        // (n) -> n*n;  or {return n*n;}
        // n->n*n;
        // Length of string
        // s -> s.length();

    }
}
