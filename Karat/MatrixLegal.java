package Karat;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/

An n x n matrix is valid if every row and every column contains all the integers from 1 to n (inclusive).

Given an n x n integer matrix matrix, return true if the matrix is valid. Otherwise, return false.

Input: matrix = [[1,2,3],[3,1,2],[2,3,1]]
Output: true

 */
public class MatrixLegal {

    public static boolean checkValid(int[][] matrix) {

        int  n = matrix.length;
        for(int i=0;i<n;i++){
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();
            for(int j=0;j<n;j++){
                if(!row.add(matrix[i][j]) || !col.add(matrix[j][i]) )
                    return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{3,1,2},{2,3,1}};
        System.out.println(checkValid(arr));
    }
}
