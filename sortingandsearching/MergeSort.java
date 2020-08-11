package sortingandsearching;

public class MergeSort {

    private static void mergeSort(int[] arr,int start,int end){
        if(start<end){
            int mid=(end+start)/2;
            mergeSort(arr,start,mid);
            mergeSort(arr,mid+1,end);
            merge(arr,start,mid,end);
        }
    }
    private static void merge(int arr[],int start,int mid,int end){

        int n1=mid-start+1;
        int n2=end-mid;

        int[] L=new int[n1];
        int[] R=new int[n2];
        for(int i=0;i<n1;i++){
            L[i]=arr[start+i];
        }
        for(int j=0;j<n2;j++){
            R[j]=arr[mid+1+j];
        }
        int i=0,j=0,k=start;
        while(i<n1&&j<n2){
            if(L[i]<=R[j]){
                arr[k]=L[i];
                i++;
            }else{
                arr[k]=R[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k]=L[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k]=R[j];
            j++;
            k++;
        }
    }

    private static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int[] arr={10,5,2,6,11,4,3,1,2,3,4,96666555,6,6,9,11,1111111,19,4,15,2};
        long start=System.currentTimeMillis();
        mergeSort(arr,0,arr.length-1);
        printArray(arr);
        long end=System.currentTimeMillis();
        System.out.println("Latency "+(end-start));
    }
}

