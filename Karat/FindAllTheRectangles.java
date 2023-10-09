package Karat;

import java.util.ArrayList;
import java.util.List;

/*
for the same image, it is filled with 0s and 1s.
It may have multiple rectangles filled with 0s. The rectangles are separated by 1s. Find all the rectangles.

Followup, what if there are multiple rectangles that are made of 0, return all.
Example:
[[1,1,1,1,1],
[1,0,0,1,1],
[1,0,0,1,1],
[1,1,1,1,0]], you should return [[[1,1],[2,2]],[[3,4],[3,4]]]

 */
public class FindAllTheRectangles {
    public static void findAllRectangles(int[][] board){

        List<int[]> res = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 0){
                    res.add(new int[]{i,j});
                    int height = 1, width =1;
                    // To Check Down till it encounters 1
                    while(i+height < board.length && board[i+height][j] == 0){
                        height++;
                    }
                    // To Check Right till it encounters 1
                    while(j+width<board[0].length && board[i][j+width] == 0){
                        width++;
                    }

                    // We can calculate diagonal from i,j = i+height-1, j+width-1

                    for(int h=0;h<height;h++){
                        for(int w=0;w<width;w++){
                            board[i+h][j+w] = 1;
                        }
                    }

                    res.add(new int[]{i+height-1, j+width-1});
                }
            }
        }
        for(int[] pair: res){
            System.out.println(pair[0]+", "+pair[1]);
        }
    }


    public static void main(String[] args) {
        int[][] board ={{1,1,1,1,1},
                {1,0,0,1,1},
                {1,0,0,1,1},
                {1,1,1,1,0}};
        findAllRectangles(board);
    }
}
