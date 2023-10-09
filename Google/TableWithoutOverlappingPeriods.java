package Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

class Table {
    String name;
    int startTime;
    int endTime;

    public Table(String name, int startTime, int endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
class Result {
    Set<String> names;
    int startTime;
    int endTime;

    public Result(Set<String> names, int startTime, int endTime) {
        this.names = names;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Result{" +
                "names=" + names +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
public class TableWithoutOverlappingPeriods {
    public static List<Result> tableWithoutOverLap(List<Table> tables){
        List<Result> results = new ArrayList<>();
        TreeMap<Integer,String> treeMap = new TreeMap<>();
        for(Table table: tables){
            treeMap.put(table.startTime, table.name);
            treeMap.put(table.endTime, table.name);
        }
        HashSet<String> set = new HashSet<>();
        boolean skipFirst = true;
        int prevStartTime = 0;
        for(Map.Entry<Integer, String> resultMap: treeMap.entrySet()){
            int time = resultMap.getKey();
            if(set.contains(resultMap.getValue())){
                results.add(new Result(new HashSet<>(set), prevStartTime, time));
                set.remove(resultMap.getValue());
            } else {
                if (!skipFirst)
                    results.add(new Result(new HashSet<>(set), prevStartTime, time));
                set.add(resultMap.getValue());
                skipFirst = false;
            }
            prevStartTime = resultMap.getKey();
        }
        return results.stream().filter(result -> !result.names.isEmpty()).collect(Collectors.toList());
    }


    public static void main(String[] args) {
//    Abby 1 10
//    Ben 5 7
//    Carla 6 12
//    David 15, 17
        System.out.println(tableWithoutOverLap(
                Arrays.asList(new Table("Abby" ,1, 10),
                        new Table("Ben" ,5, 7),
                        new Table("Carla" ,6, 12),
                        new Table("David" ,15, 17))
        ));
    }
}
