package GFG;

public class MaximumSubArrayBoundary {
    public static int numSubarrayBoundedMax(int[] A, int L, int R) {
        int res=0;
        int count=0;
        int start=0,end=0;
        //sliding window approach
        for(end=0;end<A.length;end++)
        {
            if(A[end]>=L&&A[end]<=R)
            {
                count=end-start+1;  //store the current length
                res=res+end-start+1;
            }
            else if(A[end]<L)
            {
                res=res+count;     // smaller found then the max can exist from previous                                            //numbers,so smaller one can make subarrays with previous ans.
            }
            else
            {
                count=0;  //if larger found then, the MAX is out of given range L to R
                start=end+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numSubarrayBoundedMax(new int[]{2, 0, 11, 3, 0},1,10));
    }
}
