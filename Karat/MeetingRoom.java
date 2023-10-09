package Karat;

import java.util.Arrays;
import java.util.List;

/*
Similar to meeting rooms, the input is an int[][] meetings, int start, int end,
each number is time, 13:00 = "1300", 9:30 = "930", see the new meeting function cannot be scheduled to meetings
ex: {[1300, 1500], [930, 1200],[830, 845]}

new meeting[820, 830], return true;
[1450, 1500] return false;

Two Check Two Intervals Conflict

lets say (x1,y1) and (x2,y2)
When they are conflict

    case1    x1       y1
                 x2

    case2   x1      y1
                y2

    case3       x1  y1
             x2        y2
 */
public class MeetingRoom {

    public static boolean canSchedule(List<int[]> intervals, int[] newInterval) {

        for (int[] interval : intervals) {

            if (
                    (newInterval[0] >= interval[0] && newInterval[0] < interval[1]) ||
                    (newInterval[1] > interval[0] && newInterval[1] <= interval[1]) ||
                    (newInterval[0] < interval[0] && newInterval[1] > interval[1])
            ) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        List<int[]> intervals = Arrays.asList(
                new int[]{1300, 1500},new int[]{930, 1200},new int[]{830, 845});

        int[] newInterval = new int[]{820,830};
        System.out.println(canSchedule(intervals,newInterval));

        newInterval = new int[]{1450,1470};
        System.out.println(canSchedule(intervals,newInterval));

        newInterval = new int[]{1250,1500};
        System.out.println(canSchedule(intervals,newInterval));

        newInterval = new int[]{830,900};
        System.out.println(canSchedule(intervals,newInterval));

        newInterval = new int[]{910,940};
        System.out.println(canSchedule(intervals,newInterval));
    }
}
