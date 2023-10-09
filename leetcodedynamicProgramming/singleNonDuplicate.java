package leetcodedynamicProgramming;

public class singleNonDuplicate {
    public static int singleNonDuplicate(int[] nums) {
        int low=0,high=nums.length/2;
        while(low<high){
            int median = (low+high)/2;
            if(nums[2*median]!=nums[2*median+1]) high=median;
            else low=median+1;
        }
        return nums[2*low];
    }
    public static void main(String[] args) {
        int[] a={1,1,2,3,3,4,4,5,5};
        System.out.println(singleNonDuplicate(a));
    }
}
