package GFG;

public class PatternMatching {

    public static int KMPSearch(String pat,String txt){
        int ans=0;
        int N= txt.length();
        int M= pat.length();

        int[] lps= new int[M];
        computeLPSArray(pat,M,lps);
        int i=0,j=0;
        int next=0;
        while(i<N-1){
            if(j<M-1 && txt.charAt(i)==pat.charAt(j)){
                i++;
                j++;
            }
            if(j==M-1){
                ans++;
                System.out.println("Found "+txt.substring(i-j,i+1));
                j=lps[j-1];
                if(lps[j]!=0)
                    i=++next;
                j=0;
            }else if(i<N-1 && txt.charAt(i)!=pat.charAt(j)){
                if(j!=0){
                    j=lps[j-1];
                }else{
                    i++;
                }
            }
        }

        return ans;
    }
    static void computeLPSArray(String pat,int M,int[] lps){

        int len=0;
        int i=1;
        lps[0]=0;
        while(i<M-1){
            if(pat.charAt(i)==pat.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }else{

                if(len!=0){
                    len=lps[len-1];
                }else{
                    lps[i]=len;
                    i++;
                }
            }
        }

    }

    public static void main(String[] args) {
        String txt = "geeksforgeeks";
        String pat = "eeks";
        int ans = new PatternMatching().KMPSearch(pat,txt);
        System.out.println(ans);
    }
}
