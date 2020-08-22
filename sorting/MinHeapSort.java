package sorting;

public class MinHeapSort {

    private int heapSize;
    private int N;
    private int[] arr;

    private MinHeapSort(int n){
        N=n;
        heapSize=0;
        arr=new int[n];
    }
    private int parent(int i){
        return (i-1)/2;
    }
    private int left(int i){
        return 2*i+1;
    }
    private int right(int i){
        return 2*i+2;
    }
    private void insertKey(int val){
        if(heapSize==N){
            System.out.println("OverFlow");
            return;
        }
        heapSize++;
        int i=heapSize-1;
        arr[i]=val;
        while(i!=0 && arr[parent(i)]>arr[i]){
            swap(i,parent(i));
            i=parent(i);
        }
    }
    private int extractMin(){
        if(heapSize<0){
            return Integer.MAX_VALUE;
        }
        if(heapSize==1){
            heapSize--;
            return arr[0];
        }
        int root=arr[0];
        arr[0]=arr[heapSize-1];
        heapSize--;
        minHeapify(0);
        return root;
    }
    private void decreeaseKey(int i,int val){
        arr[i]=val;
        while(i!=0 && arr[parent(i)]>arr[i]){
            swap(i,parent(i));
            i=parent(i);
        }
    }
    private void minHeapify(int i){
        int l=left(i);
        int r=right(i);
        int small=i;
        if(l<heapSize && arr[l]<arr[i])
            small=l;
        if(r<heapSize && arr[r]<arr[small])
            small=r;
        if(small!=i){
            swap(i,small);
            minHeapify(small);
        }
    }
    private void deleteKey(int i){
        decreeaseKey(i,Integer.MIN_VALUE);
        extractMin();
    }
    private void swap(int i,int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
    private void sort()
    {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(n, i);
        for (int i=n-1; i>0; i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(i,0);
        }
    }
    private void heapify(int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2*i + 1; // left = 2*i + 1
        int r = 2*i + 2; // right = 2*i + 2
        if (l < n && arr[l] > arr[largest])
            largest = l;
        if (r < n && arr[r] > arr[largest])
            largest = r;
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(n, largest);
        }
    }
    private void printArr(){
        for(int i=0;i<N;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        int[] array={10,5,2,6,11,4,3,1,2,3,4,5,6,6,1,111111,55,2222222,77,9,11,22,33,44,55,66};;
        MinHeapSort hs=new MinHeapSort(array.length);
        for(int i=0;i<array.length;i++){
            hs.insertKey(array[i]);
        }
        hs.printArr();
        hs.sort();
        hs.printArr();
        long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
