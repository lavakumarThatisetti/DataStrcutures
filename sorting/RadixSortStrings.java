package sorting;

public class RadixSortStrings {

    private static void countSort(String[] arr,int index){
        int[] count = new int[256];

        for(String val:arr){
            count[(val.charAt(index))]++;
        }
        for(int i=1;i<count.length;i++){
            count[i]=count[i]+count[i-1];
        }
        String[] output=new String[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            output[--count[(arr[i].charAt(index))]]=arr[i];
        }
        System.arraycopy(output,0,arr,0,arr.length);
    }
    private static void radixSort(String[] arr){

        int maxNum=0;
        for(String str:arr){
            maxNum= Math.max(str.length(), maxNum);
        }
        for(int index=maxNum-1;index>=0;index--){
            countSort(arr,index);
        }
        for (String s : arr) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        String[] arr={"COW", "DOG", "SEA", "RUG", "ROW", "MOB", "BOX", "TAB",
                "BAR", "EAR", "TAR", "DIG", "BIG", "TEA", "NOW", "FOX"};
        System.out.println("RadixSort");
        radixSort(arr);
        long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
