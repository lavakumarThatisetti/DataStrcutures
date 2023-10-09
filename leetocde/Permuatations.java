package leetocde;

import java.util.ArrayList;
import java.util.List;

public class Permuatations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        ans.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++){
            List<List<Integer>> tempAns=new ArrayList();
            for(int j=0;j<=i;j++){
                for(List<Integer> l:ans){
                    List<Integer> inList=new ArrayList<>(l);
                    inList.add(j,nums[i]);
                    tempAns.add(inList);
                }
            }
            ans=tempAns;
        }
        return ans;
    }

    public static void main(String[] args) {
        permute(new int[]{1,2,3});
    }
}
