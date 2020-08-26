package leetcodedynamicProgramming;

import java.util.Scanner;
import java.util.Stack;

public class MinimumCostTreeFromLeafValues_1130 {
    public static int mctFromLeafValues(int[] arr) {
        Stack<Integer> stack=new Stack<>();
        stack.push(Integer.MAX_VALUE);
        int res=0;
        for(int num:arr){
            while(stack.peek()<=num){
                int mid=stack.pop();
                res+=mid*Math.min(stack.peek(),num);
            }
            stack.push(num);
        }
        while(stack.size()>2){
            res+=stack.pop()*stack.peek();
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = scan.nextInt();
        System.out.println(mctFromLeafValues(array));
    }
}
