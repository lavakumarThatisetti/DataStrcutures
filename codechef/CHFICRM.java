package codechef;

import java.util.Scanner;

public class CHFICRM {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()) {
            int t = scan.nextInt();
            while (t > 0) {
                int N = scan.nextInt();
                int arr[]=new int[N];
                for(int i=0;i<N;i++){
                    arr[i]=scan.nextInt();
                }
                if(arr[0]!=5){
                    System.out.println("NO");
                }else{
                    int flag=0;
                    int count=1;
                    int moneyLeft=arr[0];
                    for(int i=1;i<N;i++){
                        if(arr[i]==5)
                            moneyLeft+=arr[i];
                        else if(arr[i]==10){
                            if(moneyLeft>=5 && moneyLeft>=(arr[i]-5)){
                                moneyLeft=moneyLeft-5;
                                moneyLeft+=arr[i];
                            }else{
                                flag=1;
                                System.out.println("NO");
                                break;
                            }
                        }else if(arr[i]==15){
                            if(moneyLeft>=10 && moneyLeft>=(arr[i]-5)){
                                moneyLeft=moneyLeft-10;
                                moneyLeft+=arr[i];
                            }else{
                                flag=1;
                                System.out.println("NO");
                                break;
                            }
                        }else{
                            System.out.println("NO");
                        }
                    }
//                    for(int i=1;i<N;i++){
//                        if(moneyLeft-(arr[i]-5)>=0){
//                            count+=1;
//                            moneyLeft+=5;
//                        }else
//                            break;
//                    }
//                    if(count==N){
//                        System.out.println("YES");
//                    }else{
//                        System.out.println("NO");
//                    }
                    if(flag==0){
                        System.out.println("YES");
                    }
                }
                t--;
            }
        }
    }
}
