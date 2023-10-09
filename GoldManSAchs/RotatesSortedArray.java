package GoldManSAchs;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class RotatesSortedArray {
    public static int search(int[] nums, int target) {
        int l=0,h=nums.length-1;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(target==nums[mid])
                return mid;
            else if(nums[l]<=nums[mid]){
                if(target<nums[mid] && nums[l]<=target){
                    h = mid-1;
                }else{
                    l=mid+1;
                }

            }else{
                if(target < nums[l]  && target > nums[mid]){
                    l=mid+1;
                }else{
                    h=mid-1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums= {5,1,3};
        System.out.println(search(nums,3));
    }
}
