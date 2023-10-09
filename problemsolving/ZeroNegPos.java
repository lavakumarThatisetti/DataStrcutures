package problemsolving;

public class ZeroNegPos {
    public static void main(String[] args) {
        int[] arr = {1,2,3,0,0,1,-1,-2,-3,0,0,0,3,-2,10,0,-5,0,0,-10,2};
        int i=0,j=arr.length-1;
        int k=0;
        while(i<=j){
            if(arr[i]<0){
                i++;
            }
            else if(arr[i]==0){
                swap(arr,k,i);
                k++;
                i++;
            }
            else if(arr[i]>0){
                swap(arr,i,j);
                j--;
            }
        }
        for(i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
