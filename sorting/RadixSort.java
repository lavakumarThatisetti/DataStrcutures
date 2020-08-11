package sorting;

import java.util.Arrays;

public class RadixSort {

    private static void countSort(int[] arr,int mod){
        int max=(arr[0]/mod)%10;
        for(int i=1;i<arr.length;i++) {
            int val = (arr[i] / mod) % 10;
            if (val > max) {
                max = val;
            }
        }
        int[] count=new int[max+1];
        for(int val:arr){
            count[(val/mod)%10]++;
        }
        for(int i=1;i<max+1;i++){
            count[i]=count[i]+count[i-1];
        }
        int[] output=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            output[--count[(arr[i]/mod)%10]]=arr[i];
        }
        System.arraycopy(output,0,arr,0,arr.length);
    }
    private static void radixSort(int[] arr){

        int maxNum= Arrays.stream(arr).max().getAsInt();
        for(int mod=1;maxNum/mod>0;mod=mod*10){
            countSort(arr,mod);
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        int[] arr={10,5,2,6,11,4,3,1,2,3,4,96666555,6,6,9,11,1111111,19,4,15,2};
        System.out.println("RadixSort");
        radixSort(arr);
        long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
