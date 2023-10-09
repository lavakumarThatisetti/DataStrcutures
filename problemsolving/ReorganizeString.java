package problemsolving;

public class ReorganizeString {
    public static String reorganizeString(String s) {
        int[] index = new int[26];
        for(int i=0;i<s.length();i++){
            index[s.charAt(i)-'a']++;
        }
        int max = 0, letter = 0;
        for (int i = 0; i < index.length; i++) {
            if (index[i] > max) {
                max = index[i];
                letter = i;
            }
        }
        if (max > (s.length() + 1) / 2) {
            return "";
        }
        char[] res = new char[s.length()];
        int idx = 0;
        while (index[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            index[letter]--;
        }
        for (int i = 0; i < index.length; i++) {
            while (index[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                index[i]--;
            }
        }
        return String.valueOf(res);
    }
    public static void main(String[] args) {
        System.out.println(reorganizeString("aabbbbbccccccaaaaaavvvvvvfyygugb"));
    }
}
