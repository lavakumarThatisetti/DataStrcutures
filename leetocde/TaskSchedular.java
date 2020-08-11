package leetocde;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class TaskSchedular {

    public static int leastInterval(char[] tasks, int n) {
            int[] hash=new int[26];
            for(char c:tasks) {
                hash[c-'A']++;
            }
            Arrays.sort(hash);
            int max_slots=hash[25]-1;
            int idle_slots=max_slots*n;
            for(int i=24;i>=0;i--){
            idle_slots-=Math.min(hash[i],idle_slots);
        }
        return idle_slots>0?idle_slots+tasks.length:tasks.length;
    }
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','A','A','A','B','B','C','D','E','F','G'};
        int n = 2;
        System.out.println(leastInterval(tasks,n));
    }
}


/*
set=
a=6
b=1
c=1
d=1
e=1
f=1
g=1
 */