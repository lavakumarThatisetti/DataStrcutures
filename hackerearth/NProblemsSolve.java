package hackerearth;

import java.util.Scanner;

public class NProblemsSolve {
    static int checkNoOfProblemsCanSolve(int nOfProblems,int timeTakenToReach){
        int baseTime = 360;
        int count = 0;
        if(timeTakenToReach>=baseTime)
            return 0;
        else{
            int leftTime = baseTime - timeTakenToReach;
            for(int i=1;i<=nOfProblems;i++){
                leftTime = leftTime-3*i;
                if(leftTime<0){
                    return count;
                }
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            int nOfProblems = scan.nextInt();
            int timeTakenToReach = scan.nextInt();
            System.out.println(checkNoOfProblemsCanSolve(nOfProblems,timeTakenToReach));
            t--;
        }
    }
}
