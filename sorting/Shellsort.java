package sorting;

public class Shellsort {
    private static void shellSort(int[] arr){
        int n=arr.length;
        for(int gap=n/2;gap>0;gap=gap/2){
            for(int i=gap;i<n;i++){
                for(int j=i-gap;j>=0;j=j-gap){
                    if(arr[j]>arr[j+gap]){
                        int t=arr[j];
                        arr[j]=arr[j+gap];
                        arr[j+gap]=t;
                    }else{
                        break;
                    }
                }
            }
        }
    }
    private static void printArray(int[] arr){
        for(int a:arr){
            System.out.print(a+" ");
        }
    }
    public static void main(String[] args) {
        int[] arr={10,5,2,6,11,4,3,1,2,3,4,96666555,6,6,9,11,1111111,19,4,15,2};
        long start=System.currentTimeMillis();
        shellSort(arr);
        printArray(arr);
        long end=System.currentTimeMillis();
        System.out.println("Latency "+(end-start));
    }
}
