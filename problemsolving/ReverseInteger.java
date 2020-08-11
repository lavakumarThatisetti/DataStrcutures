package problemsolving;

public class ReverseInteger {
    public static int reverseInteger(int num){
        long val=0;
        while (num!=0){
            val=val*10+num%10;
            num=num/10;
        }
        if(val>Integer.MAX_VALUE || val<Integer.MIN_VALUE) return 0;
        return (int)val;
    }
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE+" "+Integer.MIN_VALUE);
        System.out.println(reverseInteger(214748360));
    }
}

