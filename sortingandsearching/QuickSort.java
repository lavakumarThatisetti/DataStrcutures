package sortingandsearching;

public class QuickSort {

    public static void quick(int arr[],int left,int right){
        if(left<right){
            int pIndex=partition(arr,left,right);
            quick(arr,left,pIndex-1);
            quick(arr,pIndex+1,right);
        }
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
    private static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int[] arr={10,5,2,6,11,4,3,1,2,3,4,96666555,6,6,9,11,1111111,19,4,15,2};
        long start=System.currentTimeMillis();
        quick(arr,0,arr.length-1);
        printArray(arr);
        long end=System.currentTimeMillis();
        System.out.println("Latency "+(end-start));
    }
}
