package GFG;

public class JumpGame {
    static int minJumps(int arr[])
    {
        if (arr.length <= 1)
            return 0;
        if (arr[0] == 0)
            return -1;
        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;
        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1)
                return jump;
            maxReach = Math.max(maxReach, i + arr[i]);
            step--;
            if (step == 0) {
                jump++;
                if (i >= maxReach)
                    return -1;
                step = maxReach - i;
            }
        }

        return -1;
    }
    static boolean jumpGame(int[] arr){
        int reachable  =0;
        for(int i=0;i<arr.length;i++){
            if(reachable<i) return false;
            reachable = Math.max(reachable, i + arr[i]);
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr={1, 1, 2, 5, 2, 1, 0, 0, 5, 7};
        System.out.println(jumpGame(arr));
        System.out.println(minJumps(arr));
    }
}
