package Karat;

import java.util.ArrayList;
import java.util.List;

/*
the image has random shapes filled with 0s, separated by 1s.
Find all the shapes. Each shape is represented by coordinates of all the elements inside.

Example:
[[1,1,1,1,1],
[1,0,0,1,1],
[1,0,1,1,1],
[1,1,1,1,0]]

 */
public class FindMultipleShapes {

    public static void  findAllShapes(int[][] board){
        List<int[]> shapes = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]== 0){
                    dfs(board,shapes,i,j);
                }
            }
        }
        for(int[] pair: shapes){
            System.out.println(pair[0]+", "+pair[1]);
        }
    }

    public static void dfs(int[][] board, List<int[]> shapes, int i , int j){

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 1) {
            return;
        }

        board[i][j] = 1;
        shapes.add(new int[]{i,j});

        dfs(board,shapes,i+1,j+1);
        dfs(board,shapes,i+1,j-1);
        dfs(board,shapes,i-1,j+1);
        dfs(board,shapes,i-1,j-1);

    }


    public static void main(String[] args) {
        int[][] board ={{1,1,1,1,1},
                {1,0,0,1,1},
                {1,0,0,1,1},
                {1,1,1,1,0}};
        findAllShapes(board);
    }
}
