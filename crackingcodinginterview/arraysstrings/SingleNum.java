package crackingcodinginterview.arraysstrings;

public class SingleNum {
    public static int[] singleNumber(int[] nums) {
        int xor=0;
        for(int n:nums){
            xor=xor^n;
        }
        int lowbit=xor&(-xor);
        int[] res=new int[2];
        for(int num:nums){
            if((num&lowbit) == 0)
                res[0]=res[0]^num;
            else
                res[1]=res[1]^num;
        }
        System.out.println(res[0]+"  "+res[1]);
        return res;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,1,5,2};
        singleNumber(nums);
    }
}
