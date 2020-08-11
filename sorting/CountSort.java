package sorting;

import java.util.Arrays;
import java.util.Collections;

public class CountSort {
    private static void countsortPoistiveNumbers(Integer[] arr){
        int max=Collections.max(Arrays.asList(arr));

        int[] countArr=new int[max+1];
        for(int i=0;i<arr.length;i++){
            countArr[arr[i]]++;
        }
        for(int i=1;i<max+1;i++){
            countArr[i]=countArr[i]+countArr[i-1];
        }
        int[] output=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            output[--countArr[arr[i]]]=arr[i];
        }

        for(int i=0;i<arr.length;i++){
            System.out.print(output[i]+" ");
        }
        System.out.println();
    }
    private static void countSortNegativPositive(Integer[] arr){
        int min=Collections.min(Arrays.asList(arr));
        int max=Collections.max(Arrays.asList(arr));
        int range=max-min+1;
        int[] countArr=new int[range];
        for(int i=0;i<arr.length;i++){
            countArr[arr[i]-min]++;
        }
        for(int i=1;i<range;i++){
            countArr[i]=countArr[i]+countArr[i-1];
        }
        int[] output=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            output[--countArr[arr[i]-min]]=arr[i];
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(output[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        Integer[] arr={10,5,2,6,11,4,3,1,2,3,4,96666555,6,6,9,11,1111111,19,4,15,2};
        System.out.println("Only Positive Sorted Array");
        countsortPoistiveNumbers(arr);
        long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);
        System.out.println("Both Neg and Pos Sorted Array");
        Integer[] arr2={-10,5,2,6,11,4,3,1,-2,3,4,5,6,6,-9,-11,1,-19,4,-15,2};
        countSortNegativPositive(arr2);
    }
}
