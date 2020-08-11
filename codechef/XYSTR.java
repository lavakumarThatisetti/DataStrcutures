package codechef;

import java.util.Scanner;

public class XYSTR {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            int t=scan.nextInt();
            while(t>0) {
                String s = scan.next();
                int arr[]=new int[s.length()];
                s=s.toLowerCase();
                int j=0;
                for(int i=0;i<s.length();i++){
                    if(s.charAt(i)=='x'){
                        arr[i]=1;
                    }
                }
                int count=0;
                int i=0;
                while(s.length()-1>i){
                    if(arr[i]==1 && arr[i+1]==0) {
                        count++;
                        i=i+2;
                    }
                    else if(arr[i]==0 && arr[i+1]==1){
                        count++;
                        i=i+2;
                    }
                    else i++;
                }
                System.out.print(count);
                t--;
            }
        }
        scan.close();
    }
}
