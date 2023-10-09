package Karat;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

/*

Access multiple times within an hour

Give list of [name, time], time is string format: '1300' // 1pm

return: list of names and the times where their swipe badges within one hour.
if there are multiple intervals that satisfy the condition, return any one of them.
Constraint : timings should greater than or equal to 3
name1: time1, time2, time3...
name2: time1, time2, time3, time4, time5...
example:
input: [['James', '1300'], ['Martha', '1600'], ['Martha', '1620'], ['Martha', '1530']]
output: {
'Martha': ['1530' '1600', '1620']
}

 */
public class FrequentAccess {

    public static Map<String, List<Integer>> frequentAccess(String[][] records){
        int len = records.length;
        Map<String, TreeSet<Integer>> map= new HashMap<>();
        for(String[] record :records){
            if(!map.containsKey(record[0]))
                map.put(record[0], new TreeSet<>());
            int time = Integer.parseInt(record[1]);
            map.get(record[0]).add(time);
        }

        Map<String, List<Integer>> ans = new HashMap<>();
        for(Map.Entry<String, TreeSet<Integer>> entry: map.entrySet()){
            String name = entry.getKey();
            Deque<Integer> dq = new ArrayDeque<>();
            for(int time: entry.getValue()){
                dq.offer(time);
                if(!dq.isEmpty() && dq.peekLast() - dq.peek() > 100){
                    dq.poll();
                }
            }
            if(dq.size()>=3)
                ans.put(name, new ArrayList<>(dq));
        }
        return ans;
    }

    public static void main(String[] args) {
        String[][] records = {
                {"James", "1300"},
                {"Martha", "1600"},
                {"Martha", "1620"},
                {"Martha", "1629"},
                {"Martha", "1530"},
                {"Martha", "1719"},
                {"Martha", "1700"},
        };
        System.out.println(frequentAccess(records));
    }
}
