package GFG;

public class ReplaceZeroToFIVE {
        static  int convertfive(int num) {
            if (num == 0) return 5;
            char[] str = String.valueOf(num).toCharArray();
            for (int i = 0; i < str.length; i++) {
                if (str[i] == '0') {
                    str[i]='5';
                }
            }
            return Integer.parseInt(String.valueOf(str));
        }

    public static void main(String[] args) {
        System.out.println(convertfive(1005));
    }
}
