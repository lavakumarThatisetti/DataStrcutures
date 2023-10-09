package Karat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class AlertKeyMoreThanThree {

    public static List<String> alertNames(String[] keyName, String[] keyTime) {
        int len = keyName.length;
        Map<String, TreeSet<Integer>> map= new HashMap<>();
        for(int i=0;i<len;i++){
            if(!map.containsKey(keyName[i]))
                map.put(keyName[i], new TreeSet<>());
            int time = Integer.parseInt(
                    keyTime[i].substring(0,2)+keyTime[i].substring(3)
            );
            map.get(keyName[i]).add(time);
        }
        TreeSet<String> names = new TreeSet<>();
        for(Map.Entry<String, TreeSet<Integer>> entry: map.entrySet()){
            String name = entry.getKey();
            List<Integer> timings = new ArrayList<>(entry.getValue());
            if(timings.size()>=3){
                for(int i=2;i<timings.size();i++) {
                    if (timings.get(i) - timings.get(i-2) <= 100) {
                        names.add(name);
                        break;
                    }
                }
            }
        }
        return new ArrayList<>(names);
    }
    public static void main(String[] args) {

        String[] keyName = {"alice","alice","alice","bob","bob","bob","bob"};
        String[] keyTime = {"12:01","12:00","18:00","21:00","21:20","21:30","23:00"};

        System.out.println(alertNames(keyName,keyTime));
    }
}
