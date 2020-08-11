package problemsolving;

import java.util.Arrays;
import java.util.Scanner;

public class RearrangeOptimalBay {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t=scan.nextInt();
        while(t>0){
            int N=scan.nextInt();
            long teamG[]=new long[N];
            long op[]=new long[N];
            for(int i=0;i<N;i++){
                teamG[i]=scan.nextLong();

            }
            for(int i=0;i<N;i++){
                op[i]=scan.nextLong();
            }
            Arrays.sort(teamG);
            Arrays.sort(op);
            long count=0;
            long minValue;
            long swap;
            for(int i=0;i<N;i++){
                long _op=op[i];
                if(_op<teamG[i]){
                    minValue=teamG[i]-_op;
                    int index=i;
                    for(int j=i+1;j<N;j++){
                        long smallGreat=teamG[j]-_op;
                        if(smallGreat<minValue && smallGreat>_op){
                            minValue=smallGreat;
                            index=j;
                        }
                    }
                    if(index!=i){
                        swap=teamG[i];
                        teamG[i]=teamG[index];
                        teamG[index]=swap;
                    }
                    count++;
                    teamG[i]=Long.MAX_VALUE;
                }
                else {
                    for(int j=i;j<N;j++){
                        if(teamG[j]>_op){
                            swap=teamG[i];
                            teamG[i]=teamG[j];
                            teamG[j]=swap;
                            count++;
                            teamG[i]=Long.MAX_VALUE;
                            break;
                        }
                    }
                }

            }
            System.out.println(count);
            t--;
        }

    }
}
