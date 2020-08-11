package problemsolving;

public class RomanToInteger {
    public static int romanToInteger(String roman){
        int res=0;
        //IX, IV ()?yes:no (1,3999)
        //if any continous more than 3 I's in incoming strinh we need to throw error substring IIII
        for(int i=roman.length()-1;i>=0;i--){
            switch (roman.charAt(i)){
                case 'I': res+=(res>=5?-1:1);
                         break;
                case 'V': res+=5;
                         break;
                case 'X': res+=10*(res>=50?-1:1);
                         break;
                case 'L':res+=50;
                         break;
                case 'C':res+=100*(res>=500?-1:1);
                         break;
                case 'D':res+=500;
                          break;
                case 'M': res+=1000; //res=res+1000
                         break;
                default: break;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(romanToInteger("IIII"));
    }
}
