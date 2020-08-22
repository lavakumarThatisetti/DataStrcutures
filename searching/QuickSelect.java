package searching;

import java.util.Random;

public class QuickSelect {
    private static int kthSmallest(int[] arr,int left,int right,int k){
            int pIndex=partition(arr,left,right);
            if(k==pIndex)
                return arr[pIndex];
            else if(k<pIndex)
                return kthSmallest(arr,left,pIndex-1,k);
            else return kthSmallest(arr,pIndex+1,right,k);
    }
    private static int kthSmallestIterative(int[] arr,int left,int right,int k){
        while(left<=right){
            int pIndex=partition(arr,left,right);
            if(k==pIndex)
                return arr[pIndex];
            else if(k<pIndex)
                right=pIndex-1;
            else left=pIndex+1;
        }
        return -1;
    }
    private static int partition(int[] arr,int left,int right){

        int pivot=arr[right];
        int pIndex=left;
        for(int i=left;i<right;i++){
            if(arr[i]<pivot){
                int temp=arr[pIndex];
                arr[pIndex]=arr[i];
                arr[i]=temp;
                pIndex++;
            }
        }
        int temp=arr[pIndex];
        arr[pIndex]=arr[right];
        arr[right]=temp;
        return pIndex;
    }
    private static int Randpartition(int[] arr,int left,int right){

        Random rand=new Random();
        int index=rand.nextInt(right-left+1)+left;
        int temp=arr[index];
        arr[right]=arr[index];
        arr[index]=temp;
        return partition(arr,left,right);
    }
    public static void main(String[] args) {
        int[] arr={10, 4, 5, 8, 6, 11, 26};
        int k=3;
        long start=System.currentTimeMillis();
        System.out.println(kthSmallest(arr,0,arr.length-1,k-1));
        System.out.println(kthSmallestIterative(arr,0,arr.length-1,k-1));
        long end=System.currentTimeMillis();
        System.out.println("Latency "+(end-start));
    }
}
