package leetocde;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game24 {
    private static final double DIFF_TOLERANT = 0.1;

    public boolean judgePoint24(int[] nums) {
        List<Double> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add((double)num);
        }
        return judgePoint24(numList);
    }
    private boolean judgePoint24(List<Double> nums) {

        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) <= DIFF_TOLERANT;
        }

        for(int i=0;i<nums.size();i++){
            for(int j=0;j<i;j++){
                double a = nums.get(i), b = nums.get(j);

                // possible results by adding operator between a and b
                List<Double> vals = new ArrayList<>(Arrays.asList(a + b, a - b, b - a, a * b, a / b, b / a));

                List<Double> copyNums = new ArrayList<>(nums); // deep copy of nums
                // There is no problem in left shift when remove done two times
                // as we have above for loop condition j<i  [ first we are removing i which is always greater than j
                // Which means j index won't be impacted
                copyNums.remove(i);
                copyNums.remove(j);
                for (double val : vals) {
                    copyNums.add(val);
                    if (judgePoint24(copyNums)) {
                        return true;
                    }
                    copyNums.remove(copyNums.size()-1);
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        Game24 game24 = new Game24();
        System.out.println(game24.judgePoint24(new int[]{4,1,8,7}));
    }
}
