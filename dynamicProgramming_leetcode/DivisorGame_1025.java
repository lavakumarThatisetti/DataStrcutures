package dynamicProgramming_leetcode;

import java.util.Scanner;

public class DivisorGame_1025 {
    private static boolean divierGame(int n,Boolean[] cache){

        if(n<=1) return false;  //Base Condition for Dynamic programming

        if(cache[n]!=null) return cache[n];
        for(int i=1;i<=n/2;i++){
            if(n%i==0){
                if(!divierGame((n-i),cache)){
                    cache[n]=true;
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        Boolean cache[]=new Boolean[n+1];
        System.out.println("Win ? "+divierGame(n,cache));

    }
}
