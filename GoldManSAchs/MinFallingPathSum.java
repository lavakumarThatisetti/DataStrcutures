package GoldManSAchs;

public class MinFallingPathSum {
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int res =0;
        for(int i=0;i<n;i++){
            res = Math.min(res,matrix[0][i]);
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                if(j>0 && j<n-1){
                    matrix[i][j] += Math.min(matrix[i-1][j-1],Math.min(matrix[i-1][j],matrix[i-1][j+1]));
                }
                else if(j>0){
                    matrix[i][j] += Math.min(matrix[i-1][j],matrix[i-1][j-1]);
                }
                else if(j<n-1){
                    matrix[i][j] += Math.min(matrix[i-1][j],matrix[i-1][j+1]);
                }
                res = Math.min(res,matrix[i][j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {};
        System.out.println(minFallingPathSum(matrix));
    }
}
