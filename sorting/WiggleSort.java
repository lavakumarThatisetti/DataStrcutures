package sorting;

public class WiggleSort {
    private static int kthSmallest(int[] arr,int left,int right,int k){
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
    private static int index(int i, int len){
        return (1+2*i)%(len | 1);
    }
    private static void wiggle(int[] nums){
        //arr[0] <= arr[1] >= arr[2] <= arr[3]....
        //Find Median
        int len=nums.length;
        int median=kthSmallest(nums,0,len-1,len/2);
        int start=0, i=0, end = nums.length-1;
        while(i<=end){
            if(nums[index(i,len)]>median){
                swap(nums, index(start++,len),index(i++,len));
            } else if(nums[index(i,len)]<median){
                swap(nums, index(i,len),index(end--,len));
            }else{
                i++;
            }
        }
    }
    private static void wave(int[] arr){
        //arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >= …..
        for(int i=0;i<arr.length-1;i++){
            if((i%2==0)==(arr[i]<arr[i+1])){
                swap(arr,i,i+1);
            }
        }
    }
    private static void swap(int[] arr,int i,int j){
        int temp =arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    private static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr={1,2,2,1,2,1,1,1,1,2,2,2};
        wiggle(arr);
        printArray(arr);
        arr= new int[]{10, 90, 49, 2, 1, 5, 23};
        wave(arr);
        printArray(arr);
    }
}
