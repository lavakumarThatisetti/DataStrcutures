package sorting;

public class HeapSorting {
    private int heapSize;
    private int N;
    private int[] arr;

    private HeapSorting(int n){
        N=n;
        heapSize=0;
        arr=new int[n];
    }
    private int parent(int i) { return (i-1)/2;}
    private int left(int i){ return (2*i+1);}
    private int right(int i){return (2*i+2);}

    private void insertKey(int val){
        if(heapSize==N){
            System.out.println("OverFlow");
            return;
        }
        heapSize++;
        int i=heapSize-1;
        arr[i]=val;
        while(i!=0 && arr[parent(i)]<arr[i]){
            swap(parent(i),i);
            i=parent(i);
        }
    }
    private void deleteKey(){
        heapSize--;
        swap(0,heapSize);
        heapify(arr, heapSize, 0);
    }
    private void heapify(int[] arr,int n,int root){
        int maxIndex = root;
        int l = left(root);
        int r = right(root);
        if (l < n && arr[l] > arr[maxIndex])
            maxIndex = l;
        if (r < n && arr[r] > arr[maxIndex])
            maxIndex = r;
        if (maxIndex != root) {
            swap(root,maxIndex);
            heapify(arr, n, maxIndex);
        }
    }
    private void swap(int i,int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }

    private void printArray(){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] array={10,5,2,6,11,4,3,1,2,3,4,96666555,6,6,9,11,1111111,19,4,15,2};
        long start=System.currentTimeMillis();
        HeapSorting hs=new HeapSorting(array.length);
        for(int i=0;i<array.length;i++){
            hs.insertKey(array[i]);
        }
        hs.printArray();
        for(int i=0;i<array.length;i++){
            hs.deleteKey();
        }
        hs.printArray();
        long end=System.currentTimeMillis();
        System.out.println("Latency "+(end-start));
    }
}
