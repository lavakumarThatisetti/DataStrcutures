package Top100LeetcodeLikedQuestions;

public class CountNumberofNiceSubarrays {
    public static int numberOfSubarrays(int[] nums, int k) {
        int j,i=0,res=0,count=0;
        for(j=0;j<nums.length;j++){
            if(nums[j]%2==1) {
                k--;
                count=0;
            }
            while(k==0){
                k += nums[i++] & 1;
                ++count;
            }
            res += count;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2}, 2));
    }
}
