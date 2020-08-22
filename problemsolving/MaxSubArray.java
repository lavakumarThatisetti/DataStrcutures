package problemsolving;

public class MaxSubArray {
    //Divide and Conquer
    private static int maxSubArr(int[] arr,int l,int mid,int h){
        int leftMax=0;
        int sum=0;
        for(int i=mid;i>=l;i--){
            sum=sum+arr[i];
            if(sum>leftMax)
                leftMax=sum;
        }

        sum=0;
        int rightMax=0;
        for(int i=mid+1;i<h;i++){
            sum=sum+arr[i];
            if(sum>rightMax)
                rightMax=sum;
        }
        return Math.max(leftMax,Math.max(rightMax,leftMax+rightMax));
    }
    private static int divideArray(int[] arr,int l,int h){
        if(l==h){
            return arr[l];
        }else if(l<h){
            int mid=(l+h)/2;
            divideArray(arr,l,mid);
            divideArray(arr,mid+1,h);
            return Math.max(divideArray(arr,l,mid),Math.max( divideArray(arr,mid+1,h),maxSubArr(arr,l,mid,h)));
        }
        return 0;
    }

    //dynamic Prgramming
    private static int maxSubArrDP(int[] arr){
        if(arr[0]==1){
            return arr[0];
        }else {
            int maxSoFar = 0, currMax = arr[0];
            for (int i = 1; i < arr.length; i++) {
                currMax=Math.max(arr[i],currMax+arr[i]);
                maxSoFar=Math.max(maxSoFar,currMax);
            }
            return maxSoFar;
        }
    }

    public static void main(String[] args) {

        int[] arr={4,7,-1,-9,-14,22,33,-44,1,5,4,7,-1,-9,-14,22,33,-44,1,5,4,7,-1,-9,-14,22,33,-44,1,5,4,7,-1,-9,-14,22,33,-44,1,5,4,7,-1,-9,-14,22,33,-44,1,5,4,7,-1,-9,-14,22,33,-44,1,5,4,7,-1,-9,-14,22,33,-44,1,5,4,7,-1,-9,-14,22,33,-44,1,5};
        long start=System.currentTimeMillis();
        //call divide and conquer
        System.out.println(divideArray(arr,0,arr.length-1));
        long end=System.currentTimeMillis();
        System.out.println("Latency "+(end-start));

        start=System.currentTimeMillis();
        //Call Dynamic Programming
        System.out.println(maxSubArrDP(arr));
        end=System.currentTimeMillis();
        System.out.println("Latency "+(end-start));

    }
}
