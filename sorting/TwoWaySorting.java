package sorting;

public class TwoWaySorting {
    private static void twoWayMerge(int[] a,int[] b){
        int[] arr=new int[a.length+b.length];
        int alen=a.length-1;
        int blen=b.length-1;
        int k1=0,i1=0,j1=0,i2=alen,j2=blen;
        int k2=arr.length-1;
        while(i1<=alen/2 && j1<=blen/2 && i2>=alen/2 && j2>=blen/2){
            if(a[i1]<b[j1]){
                arr[k1]=a[i1++];
            }else{
                arr[k1]=b[j1++];
            }
            if(a[i2]>b[j2]){
                arr[k2]=a[i2--];
            }else{
                arr[k2]=b[j2--];
            }
            k1++;
            k2--;
        }
//        while(i<a.length){
//            arr[k]=a[i];
//            k++;
//            i++;
//        }
//        while(j<b.length){
//            arr[k]=b[j];
//            k++;
//            j++;
//        }
        for(int arrVal:arr){
            System.out.print(arrVal+" ");
        }
    }
    public static void main(String[] args) {
        int[] a={1,3,5,7,9};
        int[] b={2,4,6,8,10};
        twoWayMerge(a,b);
    }
}
