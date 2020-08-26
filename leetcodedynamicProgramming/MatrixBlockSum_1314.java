package leetcodedynamicProgramming;

public class MatrixBlockSum_1314 {
    public static void  matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        int[][] pre = new int[m][n];
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += mat[i][j];
                pre[i][j] = sum;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int r1=Math.max(0,i-k);
                int r2=Math.min(m-1,i+k);
                int c1=Math.max(0,j-k);
                int c2=Math.min(n-1,j+k);
                for(int l=r1;l<=r2;l++){
                    ans[i][j]+=pre[l][c2];
                    if(c1!=0) ans[i][j]-=pre[l][c1-1];
                }
            }
        }
        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] mat={{1,2,3},{4,5,6},{7,8,9}};
        matrixBlockSum(mat,1);
    }
}
