package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class BucketSort {

    private static void sortBucket(int[] arr,int mod,List<List<Integer>> buckets){
        for(int val:arr){
            buckets.get((val/mod)%10).add(val);
        }
        int i=0;
        ListIterator<List<Integer>> listListIterator = buckets.listIterator();
        while(listListIterator.hasNext()){
            List<Integer> indexList=listListIterator.next();
            for(Integer index:indexList){
                arr[i]=index;
                i++;
            }
        }
    }
    private static void bucketSort(int[] arr){
        int maxNum= Arrays.stream(arr).max().getAsInt();
        for(int mod=1;maxNum/mod>0;mod=mod*10){
            int max=getMax(arr,mod);
            List<List<Integer>> buckets = new ArrayList<>(max+1);
            for(int i=0;i<max+1;i++) {
                buckets.add(new ArrayList<>());
            }
            sortBucket(arr,mod,buckets);
        }
    }
    private static int getMax(int[] arr,int mod){
        int max=(arr[0]/mod)%10;
        for(int i=1;i<arr.length;i++) {
            int val = (arr[i] / mod) % 10;
            if (val > max) {
                max = val;
            }
        }
        return max;
    }
    private static void printArray(int[] arr){
        for(int a:arr){
            System.out.print(a+" ");
        }
    }
    public static void main(String[] args) {
        int[] arr={10,5,2,6,11,4,3,1,2,3,4,96666555,6,6,9,11,1111111,19,4,15,2};
        long start=System.currentTimeMillis();
        bucketSort(arr);
        printArray(arr);
        long end=System.currentTimeMillis();
        System.out.println("Latency "+(end-start));
    }
}
