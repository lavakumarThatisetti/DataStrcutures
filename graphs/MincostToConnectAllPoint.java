package graphs;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MincostToConnectAllPoint {
    class Node {
        int v;
        int w;
        Node() {}
        public Node(int v,int w){
            this.v = v;
            this.w = w;
        }
        public int getV() {return v;}
        public int getW() {return w;}

    }
    public int minCostConnectPoints(int[][] points) {
        List<List<Node>> edges = new ArrayList<>();
        int n = points.length;
        for(int i=0;i<n;i++){
            edges.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                edges.get(i).add(new Node(j,manathanDistance(points,i,j)));
            }
        }


        // find MST
        int[] key = new int[n];
        boolean[] mst = new boolean[n];
        for(int i=0;i<n;i++){
            key[i] = Integer.MAX_VALUE;
            mst[i] = false;
        }


        key[0] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<Node>(n,(node1,node2)->node1.getW() - node2.getW());
        pq.add(new Node(key[0], 0));
        int ans = 0;
        while(!pq.isEmpty()){
            int u = pq.poll().getV();
            mst[u] = true;
            for(Node it:edges.get(u)){
                if(!mst[it.getV()] && it.getW() < key[it.getV()]){
                    key[it.getV()] = it.getW();
                    pq.add(new Node(it.getV(),it.getW()));
                }
            }
            ans +=key[u];
        }
        return ans;

    }

    public int manathanDistance(int[][] points, int i, int j){
        int[] x = points[i];
        int[] y = points[j];

        return Math.abs(x[0]-y[1]) + Math.abs(y[0]-y[1]);

    }
}