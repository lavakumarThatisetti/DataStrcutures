package Top100LeetcodeLikedQuestions;

import java.util.HashMap;

public class fractionToDecimal_166 {
    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res=new StringBuilder();
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        res.append(num/den);
        long rem=num%den;
        if(rem==0)
            return res.toString();
        res.append(".");

        HashMap<Long, Integer> hashMap = new HashMap<Long, Integer>();
        while (!hashMap.containsKey(rem)) {
            hashMap.put(rem, res.length());
            res.append(10 * rem / den);
            rem = 10 * rem % den;
        }
        int index = hashMap.get(rem);
        res.insert(index, "(");
        res.append(")");
        return res.toString().replace("(0)", "");
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(23,67));
    }
}
