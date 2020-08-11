package crackingcodinginterview.arraysstrings;

public class PowFunction {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        double temp;
        temp = myPow(x, n/2);
        if(n%2==0){
            return temp*temp;
        }else{
            if(n>0){
                return x*temp*temp;
            }else{
                return (temp*temp)/x;
            }
        }
    }

    public static void main(String[] args) {

    }
}
