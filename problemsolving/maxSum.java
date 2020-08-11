package problemsolving;

import java.util.*;
import java.util.Map.*;

public class maxSum {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        while(t>0){
            int N=scan.nextInt();
            int K=scan.nextInt();
            Integer A[]=new Integer[N];
            for(int i=0;i<N;i++){
                A[i]=scan.nextInt();
            }
            int indexPairs[][]=new int[K][2];
            ArrayList<Integer> indexes=new ArrayList<>();
            for(int i=0;i<K;i++){
                for(int j=0;j<2;j++){
                    indexPairs[i][j]=scan.nextInt()-1;
                }
            }
            int sum1=sumArray(A,indexPairs,K);
            Arrays.sort(A, Collections.reverseOrder());
            for(int i=0;i<K;i++){
                indexes.add(indexPairs[i][0]);
                indexes.add(indexPairs[i][1]);
               for(int j=indexPairs[i][0]+1;j<indexPairs[i][1];j++){
                   indexes.add(j);
               }
            }
            Map<Integer,Integer> freq=new HashMap<>();
            for(Integer index:indexes){
                Integer count=freq.get(index);
                if(count==null){
                    count=0;
                }
                freq.put(index,count+1);
            }
            Integer[] reArr=new Integer[freq.size()];
            int inc=0;
            List<Entry<Integer,Integer>> sortedmap= entriesSortedByValues(freq);
            ListIterator<Entry<Integer, Integer>> entryListIterator = sortedmap.listIterator();
            while (entryListIterator.hasNext()){
                Entry<Integer, Integer> next = entryListIterator.next();
                reArr[next.getKey()]=A[inc];
                inc++;
            }
            int sum2=sumArray(reArr,indexPairs,K);
            System.out.println(Math.abs(sum2-sum1));
            t--;
        }
    }
    public static int sumArray(Integer[] arr, int[][] indexPairs,int k){
        int sum=0;
        for(int i=0;i<k;i++){
            if(indexPairs[i][0]==indexPairs[i][1]){
                sum=sum+arr[indexPairs[i][0]];
            }else{
                for(int j=indexPairs[i][0];j<=indexPairs[i][1];j++){
                    sum=sum+arr[j];
                }
            }
        }
        return sum;
    }
    static <K,V extends Comparable<? super V>> List<Entry<K, V>> entriesSortedByValues(Map<K,V> map) {

        List<Entry<K,V>> sortedEntries = new ArrayList<>(map.entrySet());

        Collections.sort(sortedEntries,
                new Comparator<Entry<K,V>>() {
                    @Override
                    public int compare(Entry<K,V> e1, Entry<K,V> e2) {
                        return e2.getValue().compareTo(e1.getValue());
                    }
                }
        );

        return sortedEntries;
    }
}
