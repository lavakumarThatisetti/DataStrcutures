package leetcodedynamicProgramming;

import java.util.Scanner;

public class BestTimetoBuyandSellStock_121 {
    private static int maxProfit(int[] prices) {
        int maxProfit=0;
        if(prices.length==0) return 0;
        int minPrice=prices[0];
        for(int i=1;i<prices.length;i++){
            //Buy Min Price
            if(prices[i]<minPrice){
                minPrice=prices[i];
            }else if((prices[i]-minPrice)>maxProfit){  //Sell the stock with max price
                maxProfit=prices[i]-minPrice;
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int[] prices=new int[n];
        for(int i=0;i<n;i++)
            prices[i]=scan.nextInt();
        System.out.println("Max Profit ? "+maxProfit(prices));

    }
}
