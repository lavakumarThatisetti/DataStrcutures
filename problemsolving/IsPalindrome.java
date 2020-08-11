package problemsolving;

public class IsPalindrome {
    public static boolean isPalindrome(int num){
        int temp=num;
        if(num<0 || num%10==0) return false;
        int val=0;
        while (num!=0){
            val=val*10+num%10;
            num=num/10;
        }
        return temp==val;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
    }
}
