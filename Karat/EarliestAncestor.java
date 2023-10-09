package Karat;

/*
Suppose we have some input data describing a graph of relationships between parents and children over
multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique positive integer identifier.

For example, in this diagram, the earliest ancestor of 6 is 14, and the earliest ancestor of 15 is 2.

         14
         |
  2      4
  |    / | \
  3   5  8  9
 / \ / \     \
15  6   7    11

Write a function that, for a given individual in our dataset, returns their earliest known ancestor -- the one at the farthest distance from the input individual. If there is more than one ancestor tied for "earliest", return any one of them. If the input individual has no parents, the function should return null (or -1).

Sample input and output:

parentChildPairs3_1 = [
    (2, 3), (3, 15), (3, 6), (5, 6), (5, 7),
    (4, 5), (4, 8), (4, 9), (9, 11), (14, 4),
]

findEarliestAncestor(parentChildPairs3_1, 8) => 14
findEarliestAncestor(parentChildPairs3_1, 7) => 14
findEarliestAncestor(parentChildPairs3_1, 6) => 14
findEarliestAncestor(parentChildPairs3_1, 15) => 2
findEarliestAncestor(parentChildPairs3_1, 14) => null or -1
findEarliestAncestor(parentChildPairs3_1, 11) => 14

Additional example:

  14
  |
  2      4    1
  |    / | \ /
  3   5  8  9
 / \ / \     \
15  6   7    11

parentChildPairs3_2 = [
    (2, 3), (3, 15), (3, 6), (5, 6), (5, 7),
    (4, 5), (4, 8), (4, 9), (9, 11), (14, 2), (1, 9)
]

findEarliestAncestor(parentChildPairs3_2, 8) => 4
findEarliestAncestor(parentChildPairs3_2, 7) => 4
findEarliestAncestor(parentChildPairs3_2, 6) => 14
findEarliestAncestor(parentChildPairs3_2, 15) => 14
findEarliestAncestor(parentChildPairs3_2, 14) => null or -1
findEarliestAncestor(parentChildPairs3_2, 11) => 4 or 1

n: number of pairs in the input


*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class EarliestAncestor {
    public static int findEarliestAncestor(int[][] edges, int child){
        Map<Integer, List<Integer>> parentMap = new HashMap<>();

        for(int[] edge: edges){
            if(!parentMap.containsKey(edge[1])){
               parentMap.put(edge[1], new ArrayList<>());
            }
            parentMap.get(edge[1]).add(edge[0]);
        }

        int firstChild = child;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(child);
        while (!queue.isEmpty()){
            child = queue.poll();
            if(parentMap.get(child)!=null){
                for(Integer parent:parentMap.get(child)){
                    queue.add(parent);
                }
            }
        }
        return firstChild == child ?-1: child;
    }


    public static void main(String[] args) {
        int[][] edges = {{2, 3}, {3, 15}, {3, 6}, {5, 6}, {5, 7},
                {4, 5}, {4, 8}, {4, 9}, {9, 11}, {14, 2}, {1, 9}};
        System.out.println(findEarliestAncestor(edges, 8)); //=> 4
        System.out.println(findEarliestAncestor(edges, 7)); //  => 4
        System.out.println(findEarliestAncestor(edges, 6)); // => 14
        System.out.println(findEarliestAncestor(edges, 15)); // => 14
        System.out.println(findEarliestAncestor(edges, 14)); //  => null or -1
        System.out.println(findEarliestAncestor(edges, 11)); // => 4 or 1
    }
}
