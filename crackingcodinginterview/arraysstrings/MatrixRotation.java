package crackingcodinginterview.arraysstrings;

public class MatrixRotation {
    public static void main(String[] args) {
        int matrix[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        int cycles=matrix[0].length/2;
        int n=matrix[0].length;
        System.out.println("****MATRIX*****");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        //Rotate 90 degress
        for(int i=0;i<cycles;i++){
            for(int j=i;j<n-i-1;j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[n-j-1][i];
                matrix[n-j-1][i]=t;
            }
        }
        System.out.println("AFTER 90 degree rotation");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

    }
}
