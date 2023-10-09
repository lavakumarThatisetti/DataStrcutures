package GoldManSAchs;

public class MyAtoi {
    public static int myAtoi(String s) {
        int sign = 1;
        int i=0;
        int res=0;
        if (s.length() == 0) return 0;
        while(i<s.length() && s.charAt(i)==' '){
            i++;
        }
        if(i < s.length() && (s.charAt(i)=='-' || s.charAt(i)=='+')){
            sign = (s.charAt(i++) == '-') ? -1 : 1;
        }
        while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){
            if(res > Integer.MAX_VALUE/10 || res == Integer.MAX_VALUE/10 &&
                    s.charAt(i) - '0' > Integer.MAX_VALUE % 10){
                return (sign==1)? Integer.MAX_VALUE: Integer.MIN_VALUE;
            }
            res = res*10 + (s.charAt(i++)-'0');
        }
        return res*sign;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("+-12"));
    }
}
