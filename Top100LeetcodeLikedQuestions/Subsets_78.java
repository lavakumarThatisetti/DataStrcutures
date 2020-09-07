package Top100LeetcodeLikedQuestions;

import java.util.*;
public class Subsets_78 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results=new LinkedList<>();
        if(nums==null || nums.length==0){
            return results;
        }
        Arrays.sort(nums);
        List<Integer> subset=new ArrayList<>();
        toFindAllSubsets(nums,results,subset,0);

        return results;
    }
    private static void toFindAllSubsets(int[] nums, List<List<Integer>> results, List<Integer> subset, int startIndex){
        results.add(new ArrayList<>(subset));

        for(int i=startIndex;i<nums.length;i++){
            subset.add(nums[i]);
            toFindAllSubsets(nums,results,subset,i+1);
            subset.remove(subset.size()-1);
        }
    }
    public static List<List<Integer>> itrSubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if(nums == null || nums.length == 0){
            return result;
        }
        int s = 0;
        for(int n:nums){
            s = result.size();
            for(int i = 0;i<s;i++){
                List<Integer> set = new ArrayList<>(result.get(i));
                set.add(n);
                result.add(set);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num={1,2,3};
        System.out.println(subsets(num));
        System.out.println(itrSubsets(num));
    }
}
