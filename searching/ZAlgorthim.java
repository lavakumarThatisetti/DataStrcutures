package searching;

public class ZAlgorthim {
    private static boolean zAlgo(String str,String ptn){
        String concat = ptn + "$" + str;
        int l = concat.length();
        int[] Z = new int[l];
        int left = 0, right = 0;
        for(int i = 1; i < l; i++) {
            if(i>right) {
                left = right = i;
                while (right<l && concat.charAt(right-left) == concat.charAt(right)) {
                    right++;
                }
                Z[i]=right-left;
                if(Z[i]==ptn.length()){  //Can return here no need to calculate all Z indexes
                    System.out.println("Pattern found at index " + (i - ptn.length() - 1));
                    return true;
                }
                right--;
            }else{
                int k=i-left;
                if(Z[k] < right - i + 1)
                    Z[i] = Z[k];
                else {
                    left = i;
                    while (right<l && concat.charAt(right - left) == concat.charAt(right)) {
                        right++;
                    }
                    Z[i]=right-left;
                    right--;
                }
            }
        }
        for(int i = 0; i < l; ++i){
            if(Z[i] == ptn.length()){   //Here after calculating all Z then checking for string length
                System.out.println("Pattern found at index " + (i - ptn.length() - 1));
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String s="ababeefa";
        String p="beefa";
        System.out.println(zAlgo(s,p));
    }
}
