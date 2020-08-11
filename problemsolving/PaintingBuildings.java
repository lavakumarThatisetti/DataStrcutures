package problemsolving;

import java.util.*;

public class PaintingBuildings {
    static ArrayList<ArrayList<Integer>> valuesList=new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        while(t>0){
            int N=scan.nextInt();
            int M=scan.nextInt();
            int K=scan.nextInt();
            int build[]=new int[N];
            for(int i=0;i<N;i++){
                build[i]=scan.nextInt();
            }
            int cost[][]=new int[N][M];
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    cost[i][j]=scan.nextInt();
                }
            }
            int tot= findMinCost(build,cost,K,M);
            System.out.println(tot);
            t--;
        }
    }
    private static int findMinCost(int [] build,int[][] cost,int K,int M){
        //Find sub Array--> minimum cost
        int min=Integer.MAX_VALUE;
        HashMap<Integer,Integer> map=new HashMap<>();
        ArrayList<Integer> indexList=new ArrayList<>();
        if(K==1){
            int val=0;
            for(int i=0;i<build.length;i++) {
                if (build[i] != 0) {
                    val = build[i];
                    break;
                }
            }
            for(int i=0;i<build.length;i++){
                if(val!=build[i] && build[i]!=0){
                    return -1;
                }
                else if(build[i]==0){
                    indexList.add(i);
                }

            }
            int s=0;
            for(int i=0;i<indexList.size();i++){
                    s=s+cost[indexList.get(i)][val-1];
            }
            return s;
        }
        for(int i=0;i<build.length;i++) {
            if(build[i]==0){
                indexList.add(i);
            }
        }
        int[] newM=new int[M];
        for(int i=0;i<M;i++){
            newM[i]=i+1;
        }
        returnValueArray(indexList,build,newM);
        for(int i=0;i<PaintingBuildings.valuesList.size();i++){
            ArrayList<Integer> list=PaintingBuildings.valuesList.get(i);
            int[] value=new int[build.length];
            int z=0;
            for(int k=0;k<build.length;k++){
                if(indexList.get(z)!=null && k==indexList.get(z)){
                    value[k]=list.get(z);
                    z++;
                }
                else
                    value[k]=build[k];
               // System.out.print(value[k]+" ");
            }

            if(checkK(value,K)) {
                int sum=minInArray(indexList,value,cost);
                if (sum < min){
                    for(int l=0;l<value.length;l++)
                         System.out.print(value[l]);
                    System.out.println();
                    min = sum;
                }

            }
        }

        if(min==Integer.MAX_VALUE){
            return -1;
        }else{
            return min;
        }
    }
    static void allLexicographicRecurArray(int[] arr,int[] data,int index, int last)
    {
        int length = arr.length;
        for (int i = 0; i < length; i++)
        {
            if(index<arr.length)
                data[index] = arr[i];
            if (index == last) {
                ArrayList<Integer> list=new ArrayList<>();
                for (int j = 0; j < data.length; j++){
                  //  System.out.print(data[j] + " ");
                    list.add(data[j]);
                }
                //System.out.println();
                PaintingBuildings.valuesList.add(list);
            }
            else
                allLexicographicRecurArray(arr,data,index+1,last);
        }
    }
        static void combinationUtil(int arr[], int data[], int start,
                                    int end, int index, int r)
        {
            if (index == r)
            {
                ArrayList<Integer> list=new ArrayList<>();
                for (int j=0; j<r; j++) {
                    //System.out.print(data[j] + " ");
                    list.add(data[j]);
                }
                //System.out.println();
                PaintingBuildings.valuesList.add(list);
                int[] temp=new int[r];
                allLexicographicRecurArray(data, temp, 0, data.length - 1);
                return;
            }
            for (int i=start; i<=end && end-i+1 >= r-index; i++)
            {
                data[index] = arr[i];
                combinationUtil(arr, data, i+1, end, index+1, r);
            }
        }

    private static void returnValueArray(ArrayList<Integer> index,int[] build,int[] newM){
            int[] data=new int[index.size()];
            combinationUtil(newM,data,0,newM.length-1,0,index.size());
    }
    private static int minInArray(ArrayList<Integer> indexList,int[] value, int[][] cost){
        int sum=0;
        for(int i=0;i<indexList.size();i++){
            sum=sum+cost[indexList.get(i)][value[i]-1];
        }
        return sum;
    }
    private static boolean checkK(int[] build,int k){
        int count=0;
        for(int i=0;i<build.length-1;i++){
            if(build[i]!=build[i+1]){
                count++;
            }
        }
        if(count+1==k){
            return true;
        }
        return false;
    }
}
