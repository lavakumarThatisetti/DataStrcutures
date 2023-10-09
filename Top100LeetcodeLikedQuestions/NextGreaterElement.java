package Top100LeetcodeLikedQuestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NextGreaterElement {
    public static int nextGreaterElement(int num) {
        // Deque<Integer> arr = new LinkedList<>();
        if(num>Integer.MAX_VALUE) return -1;
        int[] nums = Integer.toString(num).chars().map(c -> c-'0').toArray();
        int n = nums.length;
        int i=0;
        for(i=n-1;i>0;i--){
            if(nums[i]>nums[i-1]) break;
        }
        if(i==0) return -1;
        int rE = nums[i-1], minIndex=i;

        for(int j=i+1;j<n;j++){
            if(nums[j]>rE && nums[j]<nums[minIndex]){
                minIndex = j;
            }
        }
        int temp = nums[minIndex];
        nums[minIndex] =  nums[i-1];
        nums[i-1] = temp;
        Arrays.sort(nums,i,n);

        long  ans = 0;
        for (int number : nums) {
            ans = 10*ans + number;
            if(ans<0) return -1;
        }
        if(ans > Integer.MAX_VALUE) return -1;
        return (int)ans;
    }
    public static void main(String[] args) {
        System.out.println(nextGreaterElement(149876));
    }
}
