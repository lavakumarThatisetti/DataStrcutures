package crackingcodinginterview.arraysstrings;

import java.util.*;

public class TopKelements {
    public static int[] topKFrequent(int[] nums, int k) {
        // O(1) time
        if (k == nums.length) {
            return nums;
        }
        Map<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        Queue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(count::get));

        // 2. keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }

        // 3. build an output array
        // O(k log k) time
        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,3,1,1,1};
        int top[]=topKFrequent(arr,2);
       // Arrays.stream(top);
        for(int i=0;i<top.length;i++){
            System.out.print(top[i]+" ");
        }
    }
}
