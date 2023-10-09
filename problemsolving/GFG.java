package problemsolving;

import java.util.Arrays;

class GFG
{
    static void allLexicographicRecurArray(int[] arr,int[] data,int index, int last)
    {
        for (int j : arr) {
            if (index < arr.length)
                data[index] = j;
            if (index == last) {
                for (int datum : data) System.out.print(datum + " ");
                System.out.println();
            } else
                allLexicographicRecurArray(arr, data, index + 1, last);
        }
    }
    static void combinationUtil(int arr[], int data[], int start,
                                int end, int index, int r)
    {
        if (index == r)
        {
            for (int j=0; j<r; j++)
                System.out.print(data[j]+" ");
            System.out.println();
            int[] temp=new int[r];
            allLexicographicRecurArray(data, temp, 0, data.length - 1);
            System.out.println();
            return;
        }
        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1, r);
        }
    }

    public static void main(String[] args)
    {
        int arr[]={1,2};
        int r=2;
        int[] data=new int[r];
        combinationUtil(arr,data,0,arr.length-1,0,r);
    }
}
