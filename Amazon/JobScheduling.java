package Amazon;

import java.util.Arrays;
import java.util.TreeMap;

public class JobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int[][] jobs = new int[startTime.length][3];
        for (int i=0;i<startTime.length;i++){
            jobs[i] = new int[]{startTime[i],endTime[i],profit[i]};
        }

        Arrays.sort(jobs, (a,b)->a[1]-b[1]);

        TreeMap<Integer,Integer> map = new TreeMap<>();
        map.put(0,0);
        for(int[] job:jobs){
            int cur = map.floorEntry(job[0]).getValue() + job[2];
            if(cur > map.lastEntry().getValue()){
                map.put(job[1], cur);
            }
        }
        return map.lastEntry().getValue();
    }

    public static void main(String[] args) {

        int[] startTime = {1,2,3,4,6};
        int[] endTime = {3,5,10,6,9};
        int[] profit = {20,20,100,70,60};

        JobScheduling jobScheduling = new JobScheduling();
        System.out.println(jobScheduling.jobScheduling(startTime,endTime,profit));
    }
}
