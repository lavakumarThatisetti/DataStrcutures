package Top100LeetcodeLikedQuestions;

import java.util.*;

public class QueueReconstruction_406 {
    private static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0]!=o2[0]?o2[0]-o1[0]:o1[1]-o2[1]);
        System.out.println(people);
        List<int[]> res = new LinkedList<>();
        for(int[] cur : people){
            res.add(cur[1],cur);
        }
        return res.toArray(new int[people.length][]);
    }
    public static void main(String[] args) {

        int[][] people ={{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        reconstructQueue(people);
    }
}
