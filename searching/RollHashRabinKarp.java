package searching;

public class RollHashRabinKarp {
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

        int max=getMax(p);
        double hashVal=hashFunc(p,max);
        System.out.println("HashVal ="+hashVal);
        int n=s.length();
        int m=p.length();
        double hashStr=hashFunc(s.substring(0,m),getMax(p));
        for(int i=0;i<=n-m;i++){
            String sub=s.substring(i,m+i);
            if(hashStr==hashVal && sub.equals(p)){
                return true;
            }else{
                if(i+m<n)
                 hashStr=Math.pow(max,s.charAt(i+m)-'a'+1)+hashStr-Math.pow(max,s.charAt(i)-'a'+1);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String s="ababeefa";
        String p="beefa";
        System.out.println(rabinKarp(s,p));
    }
}
