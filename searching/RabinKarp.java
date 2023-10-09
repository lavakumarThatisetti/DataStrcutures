package searching;

public class RabinKarp {
    private static int getMax(String p){
        int max=0;
        for(int i=0;i<p.length();i++){
            if((p.charAt(i)-'a'+1)>max){
                max=p.charAt(i)-'a'+1;
            }
        }
        return max;
    }
    private static double hashFunc(String p,int max){
        double hash=0;

        for(int i=p.length()-1;i>=0;i--){
            hash=hash+Math.pow(max,p.charAt(i)-'a'+1);
        }
        return hash;
    }
    public static boolean rabinKarp(String s,String p){
        double hashVal=hashFunc(p,getMax(p));
        int n=s.length();
        int m=p.length();
        for(int i=0;i<n-m;i++){
            String sub=s.substring(i,m+i);
            if(hashFunc(sub,getMax(p))==hashVal && sub.equals(p)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String s="ababeef";
        String p="abe";
        System.out.println(rabinKarp(s,p));
    }
}
