package GoldManSAchs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        Stack<int[]>  stack = new Stack<>();
        stack.push(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] top = stack.peek();

            if(top[1]<intervals[i][0]){
                stack.push(intervals[i]);
            }else{
                int[] value = {top[0],Math.max(top[1],intervals[i][1])};
                stack.pop();
                stack.push(value);
            }
        }
        int[][] ans = new int[stack.size()][2];
        int i=stack.size()-1;
        while(!stack.empty()){
            ans[i] = stack.pop();
            i--;
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
