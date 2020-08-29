package Top100LeetcodeLikedQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permuatations {
    public static List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if (nums.length ==0)
            return ans;
        ans.add(new ArrayList<>());
        for (int i = 0; i< nums.length; ++i){
            int n=ans.size();
            for (int j = 0; j<n; ++j){
                List<Integer> l = ans.poll();
                for (int k=0;k<=l.size();k++){
                    List<Integer> new_l = new ArrayList<>(l);
                    new_l.add(k,nums[i]);
                    ans.add(new_l);
               }
            }
        }
        return ans;
    }
    private static List<List<Integer>> permuteUnique(int[] nums) {
        //Unique
        LinkedList<List<Integer>> r = new LinkedList<>();
        r.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int n = r.size();
            for (int j = 0; j<n; j++) {
                List<Integer> list = r.poll();
                for (int k = 0; k <= list.size(); k++) {
                    if (k > 0 && list.get(k - 1) == nums[i])
                        break;
                    ArrayList<Integer> t = new ArrayList<>(list);
                    t.add(k, nums[i]);
                    r.add(t);
                }
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3};
        permute(arr);
        int[] arr1={1,1,2};
        permuteUnique(arr1);
    }
}
