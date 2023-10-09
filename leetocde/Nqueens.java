package leetocde;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Nqueens {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        backTrack(board,0,ans);
        return ans;
    }
    public void backTrack(char[][] board, int Q,List<List<String>> ans){
        if(Q==board.length){
            List<String> res = new LinkedList<>();
            for (char[] ints : board) {
                String s = new String(ints);
                res.add(s);
            }
            ans.add(res);
            return;
        }
        for(int i=0;i<board.length;i++){
            if(isSafePlace(board,i,Q)){
                board[i][Q] = 'Q';
                backTrack(board,Q+1,ans);
                board[i][Q] = '.';
            }
        }
    }

    public boolean isSafePlace(char[][] board, int r, int c){

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < c; j++) {
                if(board[i][j] == 'Q' && (r + j == c + i || r + c == i + j || r == i))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Nqueens nqueens = new Nqueens();
        nqueens.solveNQueens(4);
    }
}
