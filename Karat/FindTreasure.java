package Karat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// shortest path to find treasure
/*
In board3, 1 represents diamonds, give the starting point and the ending point,
and ask if there is a route that does not go back, which can go from the starting point to the ending point,
and take all the diamonds, and give all the shortest paths

board3 = [
    [  1,  0,  0, 0, 0 ],
    [  0, -1, -1, 0, 0 ],
    [  0, -1,  0, 1, 0 ],
    [ -1,  0,  0, 0, 0 ],
    [  0,  1, -1, 0, 0 ],
    [  0,  0,  0, 0, 0 ],
]


treasure(board3, (5, 0), (0, 4)) -> None

treasure(board3, (5, 2), (2, 0)) ->
  [(5, 2), (5, 1), (4, 1), (3, 1), (3, 2), (2, 2), (2, 3), (1, 3), (0, 3), (0, 2), (0, 1), (0, 0), (1, 0), (2, 0)]
  Or
  [(5, 2), (5, 1), (4, 1), (3, 1), (3, 2), (3, 3), (2, 3), (1, 3), (0, 3), (0, 2), (0, 1), (0, 0), (1, 0), (2, 0)]

treasure(board3, (0, 0), (4, 1)) ->
  [(0, 0), (0, 1), (0, 2), (0, 3), (1, 3), (2, 3), (2, 2), (3, 2), (3, 1), (4, 1)]
  Or
  [(0, 0), (0, 1), (0, 2), (0, 3), (1, 3), (2, 3), (3, 3), (3, 2), (3, 1), (4, 1)]

 */
public class FindTreasure {

    public static List<List<int[]>> findTreasure(int[][] board, int[] startPt, int[] endPt){

        // Find the total Number Treasure;
        int numTreasures = 0;
        for (int[] ints : board) {
            for (int j = 0; j < board[0].length; j++) {
                if (ints[j] == 1) numTreasures++;
            }
        }
        List<List<int[]>> paths = new ArrayList<>();
        dfs(board, startPt[0], startPt[1], numTreasures,new ArrayList<>(),endPt, paths);

        if(paths.size() == 0){
            return new ArrayList<>();
        }

        int minPaths = paths.get(0).size();
        for (List<int[]> ints : paths) {
            minPaths = Math.min(minPaths, ints.size());
        }
        int finalMinPaths = minPaths;
        return paths.stream().filter((path) -> path.size() == finalMinPaths).collect(Collectors.toList());
    }

    public static void dfs(int[][] board, int i, int j , int remTreasure, List<int[]> path, int[] endPt,
                           List<List<int[]>> paths){
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == -1 || board[i][j] == 2) {
            return;
        }

        path.add(new int[]{i,j});

        int temp = board[i][j];

        if(temp == 1){
            remTreasure--;
        }
        if(i == endPt[0] && j==endPt[1] && remTreasure==0){
            paths.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            board[i][j] = temp;
            return;
        }
        board[i][j] = 2;
        dfs(board,i,j-1,remTreasure, path,endPt,paths);
        dfs(board,i+1,j,remTreasure, path,endPt,paths);
        dfs(board,i-1,j,remTreasure, path,endPt,paths);
        dfs(board,i,j+1,remTreasure, path,endPt,paths);

        board[i][j]= temp;
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        int[][] board = {
                {1, 0, 0, 0, 0},
                {0, -1, -1, 0, 0},
                {0, -1, 0, 1, 0},
                {-1, 0, 0, 0, 0},
                {0, 1, -1, 0, 0},
                {0, 0, 0, 0, 0},
        };

        System.out.println(findTreasure(board, new int[]{5,0},new int[]{0,4}));

        List<List<int[]>> paths = findTreasure(board, new int[]{5, 2}, new int[]{2, 0});

        for(List<int[]> path:paths){
            for(int[] cord: path)
                System.out.print("("+cord[0]+","+cord[1]+")");
            System.out.println();
        }
        paths = findTreasure(board, new int[]{0,0},new int[]{4,1});

        for(List<int[]> path:paths){
            for(int[] cord: path)
                System.out.print("("+cord[0]+","+cord[1]+")");
            System.out.println();
        }

    }
}
