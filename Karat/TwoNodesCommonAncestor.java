package Karat;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
  1        3
/  \        \
4    5        6
                \
                  7
 */
public class TwoNodesCommonAncestor {

    public static boolean hasCommonAncestor(int[][] edges, int x, int y){
        Map<Integer, Integer> parentMap = new HashMap<>();

        for(int[] edge: edges){
            parentMap.put(edge[1], edge[0]);
            parentMap.put(edge[0], parentMap.getOrDefault(edge[0],-1));
        }

        Set<Integer> xParents = new HashSet<>();
        xParents.add(x);
        while (parentMap.get(x)!=null){
            x = parentMap.get(x);
            xParents.add(x);
        }
        while (parentMap.get(y)!=null){
            if(xParents.contains(y)) return true;
            y = parentMap.get(y);
        }

        return false;
    }


    public static void main(String[] args) {
        int[][] edges = {{1,4}, {1,5}, {3,6}, {6, 7}};
        System.out.println(hasCommonAncestor(edges,4,5));
    }
}
