package searching;

import java.util.Random;

public class KthElement {
    private static int kthSmallest(int[] arr,int l,int r,int k){
        Random rand = new Random(0);
        while(l<=r) {
            int pivotIndex = rand.nextInt(r - l + 1) + l;
            int pos = partition(arr, l, r,pivotIndex);
            if (pos == k-1)
               return arr[pos];
            else if (pos< k-1)
               l=pos+1;
            else
               r=pos-1;
       }
       return Integer.MAX_VALUE;
    }
    private static int kthLargest(int[] arr,int l,int r,int k){
        Random rand = new Random(0);
        while(l<=r) {
            int pivotIndex = rand.nextInt(r - l + 1) + l;
            int pos = partition(arr, l, r,pivotIndex);
            if (pos == arr.length-k)
                return arr[pos];
            else if (pos < arr.length-k)
                l=pos+1;
            else
                r=pos-1;
        }
        return Integer.MAX_VALUE;
    }
    private static int partition(int[] arr,int left,int right,int pivotIndex){
        int pivot=arr[pivotIndex];
        int lessItemIndex=left;
        int temp=arr[pivotIndex];
        arr[pivotIndex]=arr[right];
        arr[right]=temp;
        for(int i=left;i<right;i++){
            if(arr[i]<pivot){
                temp=arr[lessItemIndex];
                arr[lessItemIndex]=arr[i];
                arr[i]=temp;
                lessItemIndex++;
            }
        }
        temp=arr[lessItemIndex];
        arr[lessItemIndex]=arr[right];
        arr[right]=temp;
        return lessItemIndex;
    }
    public static void main(String[] args) {
        int[] arr={2,3,4,1,6,7};
        long start=System.currentTimeMillis();
        int k=3;
        System.out.println(kthSmallest(arr,0,arr.length-1,k));
        System.out.println(kthLargest(arr,0,arr.length-1,k));
        long end=System.currentTimeMillis();
        System.out.println("Latency "+(end-start));
    }
}
