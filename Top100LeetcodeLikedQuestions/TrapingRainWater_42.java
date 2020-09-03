package Top100LeetcodeLikedQuestions;

public class TrapingRainWater_42 {
    public static int trap(int[] height) {
        //Two pointers
        int sum=0;
        if (height == null || height.length == 0) {
            return 0;
        }
        int l=0,r=height.length-1;
        int leftMax=Integer.MIN_VALUE;
        int rightMax=Integer.MIN_VALUE;
        while(l<=r){
            leftMax=Math.max(leftMax,height[l]);
            rightMax=Math.max(rightMax,height[r]);
            if(leftMax<rightMax){
                sum+=(leftMax-height[l]);
                l++;
            }else{
                sum+=(rightMax-height[r]);
                r--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(arr));
    }
}
