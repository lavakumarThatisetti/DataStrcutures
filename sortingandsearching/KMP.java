package sortingandsearching;

import java.util.HashMap;

public class KMP {

    private static boolean KMPPattern(String s,String p){
        int[] index=new int[p.length()];
        HashMap<Character,Integer> hashMap=new HashMap<>();
        for(int i=0;i<p.length();i++){
            if(hashMap.containsKey(p.charAt(i))){
                int val=hashMap.get(p.charAt(i))+1;
                hashMap.put(p.charAt(i),val);
                index[i]=val;
            }else {
                hashMap.put(p.charAt(i),0);
                index[i]=0;
            }
        }
        int n=s.length();
        int m=p.length();
        int j=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)==p.charAt(j)){
                j++;
            }else{
                if(j!=0) {
                    j = index[j - 1];
                    i=i-1;
                }
            }
            if(j==m) {
                System.out.println("Index starting "+(n-j)+" Ending "+(n-1));
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String s="abcdabsssssssseefabeef";
        String p="absssssssseef";
        System.out.println(KMPPattern(s,p));
    }
}
