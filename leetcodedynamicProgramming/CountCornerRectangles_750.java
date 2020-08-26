package leetcodedynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class CountCornerRectangles_750 {
    private static int countCornerRectangles(int[][] grid) {
     if(grid==null || grid.length<2 || grid[0]==null) return 0;
     int count=0;
     Map<String, Integer> map = new HashMap<>();
     int m = grid.length;
     int n = grid[0].length;

     for(int i=0;i<m;i++){
         for(int j=i+1;j<m;j++){
             for(int c=0;c<n;c++){
                 if(grid[i][c]==1 && grid[j][c]==1){
                     String key=i+"#"+j;
                     if(map.containsKey(key)){
                         int val=map.get(key);
                         count+=val;
                         map.put(key,val+1);
                     }else {
                         map.put(key,1);
                     }
                 }
             }
         }
     }
     return count;
    }
    public static void main(String[] args) {
        //int[][] mat={{1, 0, 0, 1, 0},{0, 0, 1, 0, 1},{0, 0, 0, 1, 0},{1, 0, 1, 0, 1}};
        int[][] mat={{1, 1, 1},{1, 1, 1},{1,1,1}};
        System.out.println(countCornerRectangles(mat));
    }
}
