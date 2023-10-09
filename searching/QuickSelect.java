package searching;

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

    public static void main(String[] args) {
        int[] arr={1,23,12,9,30,2,50};
        int k=3;
        long start = System.currentTimeMillis();
        System.out.println(kthSmallest(arr,0,arr.length-1,k-1));
        System.out.println(kthSmallestIterative(arr,0,arr.length-1,k-1));
        long end=System.currentTimeMillis();
        System.out.println("Latency "+(end-start));
    }
}
