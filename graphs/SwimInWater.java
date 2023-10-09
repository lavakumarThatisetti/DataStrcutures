package graphs;

import java.util.PriorityQueue;

public class SwimInWater { class Node {
    private int r;
    private int c;
    private int weight;

    Node(int _r, int _c, int _w) {
        r = r;
        c = -c;
        weight = _w;
    }
    int getR() {return r;}
    int getC() { return c; }
    int getWeight() { return weight; }

}

    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};

    public int swimInWater(int[][] grid) {


        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b)->a.getWeight()-b.getWeight()); // MinHeap
        boolean[][] vistited = new boolean[m][n];

        pq.add(new Node(grid[0][0],0,0));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int r = node.getR();
            int c = node.getC();
            if(r==m-1 && c==n-1) return node.getWeight();
            vistited[r][c] = true;
            for(int k =0;k<4;k++){
                int nextR = dx[k] + r;
                int nextC = dy[k] + c;
                if(nextR >=0 && nextC >=0 && nextR<=m-1 && nextC==n-1 && !vistited[nextR][nextC]) {
                    pq.add(new Node(Math.max(grid[r][c], grid[nextR][nextC]),nextR,nextC));
                }
            }
        }
        return 0;
    }
}
