package Karat;
/*
"""
A nonogram is a logic puzzle, similar to a crossword, in which the player is given a blank grid
and has to color it according to some instructions. Specifically, each cell can be either black or white,
which we will represent as 0 for black and 1 for white.

+------------+
| 1  1  1  1 |
| 0  1  1  1 |
| 0  1  0  0 |
| 1  1  0  1 |
| 0  0  1  1 |
+------------+

For each row and column, the instructions give the lengths of contiguous runs of black (0) cells.

For example, the instructions for one row of [ 2, 1 ] indicate that there must be a run of two black cells, followed later by another run of one black cell, and the rest of the row filled with white cells.

These are valid solutions: [ 1, 0, 0, 1, 0 ] and [ 0, 0, 1, 1, 0 ] and also [ 0, 0, 1, 0, 1 ]
This is not valid: [ 1, 0, 1, 0, 0 ] since the runs are not in the correct order.
This is not valid: [ 1, 0, 0, 0, 1 ] since the two runs of 0s are not separated by 1s.

Your job is to write a function to validate a possible solution against a set of instructions.
Given a 2D matrix representing a player's solution; and instructions for each row along with additional
instructions for each column; return True or False according to whether both sets of instructions match.

Example instructions #1

matrix1 = [[1,1,1,1],
           [0,1,1,1],
           [0,1,0,0],
           [1,1,0,1],
           [0,0,1,1]]
rows1_1    =  [], [1], [1,2], [1], [2]
columns1_1 =  [2,1], [1], [2], [1]
validateNonogram(matrix1, rows1_1, columns1_1) => True

Example solution matrix:
matrix1 ->
                                   row
                +------------+     instructions
                | 1  1  1  1 | <-- []
                | 0  1  1  1 | <-- [1]
                | 0  1  0  0 | <-- [1,2]
                | 1  1  0  1 | <-- [1]
                | 0  0  1  1 | <-- [2]
                +------------+
                  ^  ^  ^  ^
                  |  |  |  |
  column       [2,1] | [2] |
  instructions      [1]   [1]


Example instructions #2

(same matrix as above)
rows1_2    =  [], [], [1], [1], [1,1]
columns1_2 =  [2], [1], [2], [1]
validateNonogram(matrix1, rows1_2, columns1_2) => False

The second and third rows and the first column do not match their respective instructions.

Example instructions #3

matrix2 = [
[ 1, 1 ],
[ 0, 0 ],
[ 0, 0 ],
[ 1, 0 ]
]
rows2_1    = [], [2], [2], [1]
columns2_1 = [1, 1], [3]
validateNonogram(matrix2, rows2_1, columns2_1) => False

The black cells in the first column are not separated by white cells.

n: number of rows in the matrix
m: number of columns in the matrix
"""

matrix1 = [
    [1,1,1,1], # []
    [0,1,1,1], # [1] -> a single run of _1_ zero (i.e.: "0")
    [0,1,0,0], # [1, 2] -> first a run of _1_ zero, then a run of _2_ zeroes
    [1,1,0,1], # [1]
    [0,0,1,1], # [2]
]

# True
rows1_1 = [[],[1],[1,2],[1],[2]]
columns1_1 = [[2,1],[1],[2],[1]]
# False
rows1_2 = [[],[],[1],[1],[1,1]]
columns1_2 = [[2],[1],[2],[1]]

matrix2 = [
    [1,1],
    [0,0],
    [0,0],
    [1,0]
]
# False
rows2_1 = [[],[2],[2],[1]]
columns2_1 = [[1,1],[3]]
 */


import java.util.ArrayList;
import java.util.List;

public class NoNoGram {

    /*
                                      row
                +------------+     instructions
                | 1  1  1  1 | <-- []
                | 0  1  1  1 | <-- [1]
                | 0  1  0  0 | <-- [1,2]
                | 1  1  0  1 | <-- [1]
                | 0  0  1  1 | <-- [2]
                +------------+
                  ^  ^  ^  ^
                  |  |  |  |
  column       [2,1] | [2] |
  instructions      [1]   [1]
     */
    public static boolean validateNoNoGram(int[][] matrix,int[][] rows, int[][] cols ){
        return IsNoNoGramRowValid(matrix,rows) && IsNoNoGramColumnValid(matrix,cols);
    }

    public static boolean IsNoNoGramRowValid(int[][] matrix, int[][] rows){

        int n = matrix.length;
        int m =  matrix[0].length;
        for(int i=0;i<n;i++){
            List<Integer> currentRow = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                if(matrix[i][j]==1) continue;
                int count = 0;
                while (j<m && matrix[i][j] == 0){
                    count++;
                    j = j+1;
                }
                currentRow.add(count);
            }
            if(!compare(rows[i], currentRow)){
                return false;
            }
        }
        return true;
    }


    public static boolean IsNoNoGramColumnValid(int[][] matrix, int[][] cols){
        int n = matrix.length;
        int m =  matrix[0].length;
        for(int i=0;i<m;i++){
            List<Integer> currentCol = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if(matrix[j][i]==1) continue;
                int count = 0;
                while (j<n && matrix[j][i] == 0){
                    count++;
                    j = j+1;
                }
                currentCol.add(count);
            }
            if(!compare(cols[i], currentCol)){
                return false;
            }
        }
        return true;
    }

    public static boolean compare(int[] object1, List<Integer> object2){
        if(object1.length != object2.size()) return false;
        for(int i=0;i<object1.length;i++){
            if(object1[i] != object2.get(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        int[][] matrix = {{1,1,1,1},{0,1,1,1},{0,1,0,0},{1,1,0,1},{0,0,1,1}};
        int[][] rowInstructions = {{}, {1}, {1,2}, {1}, {2}};
        int[][] colInstructions = {{2,1}, {1}, {2}, {1}};

        System.out.println(validateNoNoGram(matrix, rowInstructions, colInstructions));

    }
}
