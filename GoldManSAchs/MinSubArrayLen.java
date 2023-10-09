package GoldManSAchs;

public class MinSubArrayLen {
    public static int minSubArrayLen(int target, int[] nums) {
        int s=0,sum=0,ans=nums.length+1;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            while(sum>=target){
                ans = Math.min(i - s + 1, ans);
                sum = sum-nums[s++];
            }

        }
        return ans==nums.length+1?0:ans;
    }
    public static void main(String[] args) {
       int[] arr = {1,2,3,4,5};
       int target = 15;
        System.out.println(minSubArrayLen(target,arr));
    }
}
