package Karat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/*
Return to idle time period

Similar to merge interval, the only difference is the output,
output the idle time period,

after the merge, just output the empty space between the two, pay attention to add 0 - the first start time

input : intervals = [[1,3],[2,6],[8,10],[15,18]]

mergeIntervals = [[1,6],[8,10],[15,18]]

gaps
output: [[0,1],[6,8],[10,15]]

 */
public class IdleTimePeriod {


    public static List<int[]> IdleTime(int[][] intervals){
        int[][] mergeIntervals = merge(intervals);

        List<int[]> result = new ArrayList<>();
        int start = 0;
        for (int[] mergeInterval : mergeIntervals) {
            result.add(new int[]{start, mergeInterval[0]});
            start = mergeInterval[1];
        }
        return result;
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        Stack<int[]> stack = new Stack<>();

        for (int[] interval : intervals) {

            if (!stack.isEmpty() && stack.peek()[1] >= interval[0]) {
                int[] pop = stack.pop();
                stack.push(new int[]{pop[0], Math.max(pop[1], interval[1])});
            } else {
                stack.push(interval);
            }
        }

        int n = stack.size();
        int[][]  res = new int[n][2];
        for(int i = n-1;i>=0;i--){
            res[i] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {
                new int[]{1, 3},new int[]{2, 6},new int[]{8, 10},new int[]{15, 18}
        };
        System.out.println(IdleTime(intervals));
    }
}
