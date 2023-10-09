package Amazon;

import java.util.*;

public class SortFrequency {
    private static String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Map.Entry<Character, Integer> > list = new LinkedList<>(map.entrySet());
        list.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));
        StringBuilder stringBuilder=new StringBuilder();
        for(Map.Entry<Character, Integer> submap:list){
            for(int i=0;i<submap.getValue();i++){
                stringBuilder.append(submap.getKey());
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
}
