package Karat;

/*
there is an image filled with 0s and 1s. There is at most one rectangle in this image filled with 0s,
find the rectangle.
Output could be the coordinates of top-left and bottom-right elements of the rectangle,
or top-left element, width and height.

Given a rectangle represented by a 0-1 2-d array and assume it contains one rectangle of all 0, return the upper left corner and lower right corner.
Example:
[[1,1,1,1,1],
 [1,0,0,1,1],
 [1,0,0,1,1],
 [1,1,1,1,1]], you should return [[[1,1],[2,2]]]


 */
public class FindARectangle {

    public static void findRectangle(int[][] board){

        int[] rectangleStarPair = new int[0], rectangleEndPair = new int[0];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j] == 0){
                    rectangleStarPair = new int[]{i,j};
                    int height = 1, width =1;
                    // To Check Down till it encounters 1
                    while(i+height < board.length && board[i+height][j] == 0){
                        height++;
                    }
                    // To Check Right till it encounters 1
                    while(j+width<board.length && board[i][j+width] == 0){
                        width++;
                    }

                    // We can calculate diagonal from i,j = i+height-1, j+width-1

                    for(int h=0;h<height;h++){
                        for(int w=0;w<width;w++){
                            board[i+h][j+w] = 1;
                        }
                    }

                    rectangleEndPair = new int[]{i+height-1, j+width-1};
                    break;
                }
                if(rectangleStarPair.length ==2) break;
            }
        }
        System.out.println(rectangleStarPair[0]+", "+rectangleStarPair[1]);
        System.out.println(rectangleEndPair[0]+", "+rectangleEndPair[1]);
    }


    public static void main(String[] args) {
        int[][] board ={{1,1,1,1,1},
                {1,0,0,1,1},
                {1,0,0,1,1},
                {1,1,1,1,1}};
        findRectangle(board);
    }
}
