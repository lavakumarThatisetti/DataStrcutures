package searching;

public class FindMedian {
    private static float MedianSameSize(int[] arr1,int[] arr2,int startA, int startB,int endA,int endB){
        if(endA-startA==1){
            return (float) ((Math.max(arr1[startA],arr2[startB])+Math.min(arr1[endA],arr2[endB]))/2.0);
        }
        int m1=median(arr1,startA,endA);
        int m2=median(arr2,startB,endB);
        if(m1==m2){
            return m1;
        }
        else if(m1<m2){
            return MedianSameSize(arr1,arr2,(endA+startA+1)/2,startB,endA,(endB+startB+1)/2);
        }else{
            return MedianSameSize(arr1,arr2,startA,(endB+startB+1)/2,(endA+startA+1)/2,endB);
        }
    }
    private static int median(int[] arr,int start,int end){
        int n=end-start+1;
        if(n%2==0){
            return arr[start+(n/2)]+arr[start+(n/2-1)]/2;
        }else
            return arr[start+n/2];
    }
    public static void main(String[] args) {
        int[] arr1={1,2};
        int[] arr2={6,10};
        System.out.println(MedianSameSize(arr1,arr2,0,0,arr1.length-1,arr2.length-1));
    }
}
