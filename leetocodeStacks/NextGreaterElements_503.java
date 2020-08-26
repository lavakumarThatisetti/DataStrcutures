package leetocodeStacks;

import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElements_503 {

    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        int len=nums.length;
        int[] res=new int[nums.length];
        for(int i=len*2-1;i>=0;i--){
            while(!stack.empty() && stack.peek()<=nums[i%len]) stack.pop();
            if(i<len) res[i]=(stack.empty()?-1:stack.peek());
            stack.push(nums[i%len]);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = scan.nextInt();
        int res[]=nextGreaterElements(array);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}
