package Karat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
The input is int[][] input, input[0] is the parent of input[1],
such as {{1,4}, {1,5}, {2,5}, {3,6}, {6, 7}} will form the graph above

The first question is a node with only 0 parents and only 1 parent

  1    2    3
/  \  /      \
4    5        6
                \
                  7

 Ans :  InDegree = 0 ( O parent)
         InDegree = 1 (1 parent)

 */
public class ZeroOrOneParentNode {

    public static List<List<Integer>> findZeroOrOneParentNode(int[][] edges){

        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        lists.add(new ArrayList<>());

        Map<Integer, Integer> map = new HashMap<>();
        for(int[] edge: edges){
            map.put(edge[1], map.getOrDefault(edge[1],0)+1);
            map.put(edge[0], map.getOrDefault(edge[0], 0));
        }
        for (Integer node : map.keySet()) {
            if(map.get(node)==0){
                lists.get(0).add(node);
            }else if(map.get(node)==1){
                lists.get(1).add(node);
            }
        }

        return lists;
    }

    public static void main(String[] args) {
        int[][] edges = {{1,4}, {1,5}, {2,5}, {3,6}, {6, 7}};
        System.out.println(findZeroOrOneParentNode(edges));
    }
}
