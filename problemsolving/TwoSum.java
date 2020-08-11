package problemsolving;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int num[],int target){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<num.length;i++){
            int rem=target-num[i];
            if (map.containsKey(rem)) {
                return new int[]{map.get(rem),i};
            }
            map.put(num[i],i);
        }
        return new int[]{};
    }
    public static void main(String[] args) {
        int[] array=new int[]{2,5,6,8};
        int target=7;
        int[] result=twoSum(array,target);
        for(int i=0;i<result.length;i++)
            System.out.print(result[i]+" ");
    }
}
