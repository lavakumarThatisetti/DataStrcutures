package problemsolving;

import java.util.Scanner;

public class GreatOddDivisiors {

    static double square(double n)
    {
        return n * n;
    }
    static double sum(double n)
    {
        if (n == 0)
            return 0;
        if (n % 2 == 1)
        {
            return square((n + 1) / 2) + sum(n / 2);
        }
        else
        {
            return square(n / 2) + sum(n / 2);
        }
    }
    static double oddDivSum(double a, double b)
    {
        return sum(b) - sum(a - 1);
    }
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t>0){
            double sum=0;
            double N=s.nextDouble();
            double M=s.nextDouble();
            sum=oddDivSum(0,N);

            System.out.println(sum%M);
            t--;
        }
    }
}
