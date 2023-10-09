package graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    class Node {
        private int v;
        private int weight;

        Node(int _v, int _w) { v = _v; weight = _w; }
        int getV() { return v; }
        int getWeight() { return weight; }

    }
    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<Node>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for (int[] time : times) {
            adj.get(time[0]).add(new Node(time[1], time[2]));
        }


        PriorityQueue<Node> pq = new PriorityQueue<>((a, b)->a.getWeight()-b.getWeight()); // MinHeap

        int[] dist = new int[n];
        for(int i=0;i<n;i++){
            dist[i] = Integer.MAX_VALUE;
        }

        pq.add(new Node(0,k));
        int mindst = 0;
        int nodesVisit =0;
        while(!pq.isEmpty()){
            Node topElement = pq.poll();
            int weight = topElement.getWeight();
            int v = topElement.getV();
            mindst+=weight;
            nodesVisit++;
            for(Node it :adj.get(v)){
                if(dist[v] + weight < dist[it.getV()]){
                    dist[it.getV()] = dist[v] + weight;
                    pq.add(new Node(dist[it.getV()] ,it.getV()));
                }
            }
        }
        return nodesVisit == n ? mindst:-1;
    }
}
