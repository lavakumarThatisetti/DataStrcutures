package GFG;

import java.util.regex.Matcher;

public class subsets {
    static void printSubsets(char[] set){
        int n =set.length;
        System.out.println(1<<n);
        for(int i = 0; i< Math.pow(2,n); i++){
            for(int j=0;j<n;j++){
                if((i &(1<<j))>0){
                    System.out.print(set[j]+" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        char set[] = {'a', 'b', 'c'};
        printSubsets(set);
    }
}
