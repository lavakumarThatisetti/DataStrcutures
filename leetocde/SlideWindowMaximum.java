package leetocde;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlideWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>(); // stores indices
        int[] res=  new int[n-k+1];

        for(int i=0;i<n;i++){

            // Remove indices that are outer bound
            while(dq.size()>0 && dq.peekFirst() <= i-k ) {
                dq.pollFirst();
            }


            // remove indices whose corresponding values are less than nums[i] No use in que
            while(dq.size() >0 && nums[dq.peekLast()] < nums[i])
                dq.pollLast();

            // add nums[i]
            dq.offerLast(i);

            if(dq.size()>0 && i>=k -1){
                res[i-k+1] = nums[dq.peekFirst()];
            }

        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
