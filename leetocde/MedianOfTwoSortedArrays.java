package leetocde;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return MedianSameSize(nums1,nums2);

    }
    private double MedianSameSize(int[] arr1,int[] arr2){
        // to handle Run time Errros for Empty array cases
        // arr1 = [2] ,  arr2 = [0]
        if(arr1.length>arr2.length){
            return MedianSameSize(arr2,arr1);
        }
        int x=arr1.length;
        int y=arr2.length;
        int low=0;
        int high=x;
        while(low<=high){
            int px=(low+high)/2;
            int py=(x+y+1)/2-px;

            int maxLeftX=(px==0)?Integer.MIN_VALUE:arr1[px-1];  // L1
            int minRightX=(px==x)?Integer.MAX_VALUE:arr1[px];   // R1
            int maxLeftY=(py==0)?Integer.MIN_VALUE:arr2[py-1];  // L2
            int minRightY=(py==y)?Integer.MAX_VALUE:arr2[py];   // R2

            if(maxLeftX<=minRightY && minRightX<=minRightY){
                if((x+y)%2==0)
                    return ((double)Math.max(maxLeftX,maxLeftY)+Math.min(minRightX,minRightY))/2;
                else
                    return Math.max(maxLeftX,maxLeftY);
            }else if(maxLeftX>minRightY){
                high=px-1;
            }else{
                low=px+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays m = new MedianOfTwoSortedArrays();
        System.out.println(m.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
    }
}
