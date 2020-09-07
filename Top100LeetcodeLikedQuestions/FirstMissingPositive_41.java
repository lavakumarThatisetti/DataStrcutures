package Top100LeetcodeLikedQuestions;

public class FirstMissingPositive_41 {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num > n) {
                continue;
            }
            num--;
            if (nums[num] > 0) {
                nums[num] = -1 * nums[num];
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        int[] nums={3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }
}
