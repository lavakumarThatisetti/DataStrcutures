package GoldManSAchs;

public class StringCompression {
    public static int compress(char[] chars) {
        int n = chars.length;
        int unique =0;
        int ans =0;
        for(int i=0;i<n;i++){
            if(i+1==n || chars[i]!=chars[i+1]){
                chars[ans++]=chars[unique];
                for(char c:(""+(i-unique+1)).toCharArray()){
                    chars[ans++]=c;
                }
                unique = i+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        compress(new char[]{'a','a','b','b','c','c','c'});
    }
}
