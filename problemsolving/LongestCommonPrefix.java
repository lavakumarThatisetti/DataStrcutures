package problemsolving;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs){

        int minLen=Integer.MAX_VALUE;
        for(String str:strs){
            minLen=Math.min(minLen,str.length());
        }
        int low=1;
        int high=minLen;
        while(low<=high) {
            int mid = (low + high) / 2;
            if (isCommonPrefix(strs,mid))
                low = mid + 1;
            else
                high = mid - 1;
        }
        return strs[0].substring(0,(low+high)/2);
    }
    public static boolean isCommonPrefix(String[] strs,int len){
        String str=strs[0].substring(0,len);
        for(int i=1;i<strs.length;i++)
            if(!strs[i].startsWith(str)){
                return false;
            }
        return true;
    }
    public static void main(String[] args) {
        String[] strs={"lower","low","flow"};
        System.out.println(longestCommonPrefix(strs));
    }
}