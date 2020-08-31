package Top100LeetcodeLikedQuestions;

public class UniqueBinarySearchTrees_96 {
    public static int numTrees(int n) {
        int[] bst=new int[n+1];
        bst[0]=bst[1]=1;
        for(int i=2;i<n+1;i++){
            for(int j=1;j<=i;j++){
                bst[i]+=(bst[j-1]*bst[i-j]);
            }
        }
        return bst[n];
    }
    public static int aplusb(int a, int b) {
        // write your code here
        while(b!=0){
            int carry=a&b;
            a=a^b;
            b=carry<<1;
        }
        return a;
    }
    public static void main(String[] args) {
        System.out.println(numTrees(5));
        System.out.println(aplusb(4,5));
    }
}
