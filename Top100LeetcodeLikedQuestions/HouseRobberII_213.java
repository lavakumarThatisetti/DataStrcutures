package Top100LeetcodeLikedQuestions;

public class HouseRobberII_213 {
    private static int rob(int[] nums) {
        int n=nums.length;
        return Math.max(robHelp(nums,0,n-2),robHelp(nums,1,n-1));
    }
    private static int robHelp(int[] nums,int lo,int hi){
        int include = 0, exclude = 0;
        for (int j = lo; j <= hi; j++) {
            int first = include, second = exclude;
            include = second + nums[j];
            exclude = Math.max(second, first);
        }
        return Math.max(include, exclude);
    }

    public static void main(String[] args) {
        int[] r={10,6,2,12,13,14,15,2,1,2,1,22,23,100,1,1,1,2,4,5,6,7,3,33,44,55};
        System.out.println(rob(r));
    }
}
