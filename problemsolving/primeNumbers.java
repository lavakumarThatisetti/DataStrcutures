package problemsolving;

public class primeNumbers {
    public static void main(String[] args) {
        int n=500;
        for(int i=100;i<n;i++){
            if(i%2==0 && i!=2)
                continue;
            else if(i%3==0 && i!=3)
                continue;
            else if(i%5==0 && i!=5)
                continue;
            else if(i%7==0 && i!=7)
                continue;
            else System.out.print(i+" ");
        }
    }
}
