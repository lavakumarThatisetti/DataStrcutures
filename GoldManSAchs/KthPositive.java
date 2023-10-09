package GoldManSAchs;

import java.util.HashMap;

public class KthPositive {
    public static int findKthPositive(int[] arr, int k) {
        int max=Integer.MIN_VALUE;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            max = Math.max(max,arr[i]);
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        int count = 0,i=1;
        for(i=1;i<max;i++){
            if(map.get(i)==null){
                count++;
            }
            if(count==k)
                return i;
        }
        while(count<k){
            i++;
            count++;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,8};
        System.out.println(findKthPositive(arr,2));
    }
}
