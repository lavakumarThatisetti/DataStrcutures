package crackingcodinginterview.arraysstrings;

public class ZeroMatrix {
    public static void main(String[] args) {
        int matrix[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 0, 11, 12 },
                { 13, 14, 15, 16 }
        };
        int n=matrix[0].length;
        System.out.println("****MATRIX*****");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        //Rotate 90 degress
        boolean flag=false;
        matrix=zeroM(matrix,n);
        System.out.println("AFTER 90 degree rotation");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

    }
    private static int[][] zeroM(int[][] matrix,int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
                if(matrix[i][j]==0){
                    System.out.println(i+"  "+j);
                    for(int k=0;k<n;k++){
                        matrix[i][k]=0;
                        matrix[k][j]=0;
                    }
                    return matrix;
                }
            }
        }
        return matrix;
    }
}
