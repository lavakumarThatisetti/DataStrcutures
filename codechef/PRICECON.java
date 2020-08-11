package codechef;

/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class PRICECON
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            int t=scan.nextInt();
            while(t>0) {
                int N = scan.nextInt();
                int K = scan.nextInt();
                int arr[] = new int[N];
                long sum = 0;
                long ceilSum=0;
                for (int i = 0; i < N; i++) {
                    arr[i]=scan.nextInt();
                    sum +=arr[i];
                    if(arr[i]>K){
                        ceilSum+=K;
                    }else{
                        ceilSum+=arr[i];
                    }
                }
                System.out.println(sum-ceilSum);
                t--;
            }
        }
        scan.close();
    }
}
