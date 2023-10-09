package leetocde;

public class LongPalindromeCount {
    public static int longestPalindrome(String s) {
        // HashMap<Character, Integer> count = new HashMap<>();
        int[] count = new int[128];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)]++;
        }
        int res=0;
        for(int i = 0; i<count.length; i++){
            if(count[i]==0) continue;
            if(count[i]!=0 && count[i]%2==0){
                res = res+count[i];
            }
            else if(count[i]!=0 && count[i]%2==1){
                res = res+count[i]-1;
            }
        }
        // for(int i=0;i<count.length;i++){
        //     if(count[i]!=0 && count[i]%2==1){
        //         return res+1;
        //     }
        // }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcccsdfgsasdfghnbvfffffffsddcdd"));
    }
}
