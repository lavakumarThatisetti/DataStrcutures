package graphs;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class SSSP {
    LinkedList<Integer> adjList[];
    int distanceList[];
    int N;
    boolean visited[];

    SSSP(int n){
        N=n;
        adjList=new LinkedList[N];
        distanceList=new int[N];
        for(int i=0;i<N;i++){
            adjList[i]=new LinkedList<>();
        }
        visited=new boolean[n];
    }

    void addEdge(int u,int v){
        adjList[u].add(v);
    }

    void printGraph(){
//        for(int i=0;i<N;i++){
//            System.out.print(i+" ");
//            for(int j=0;j<adjList[i].size();j++){
//                System.out.print(" "+adjList[i].get(j));
//            }
//            System.out.println();
//        }
        System.out.println("disctance");
        for(int i=0;i<N;i++){
                System.out.print(" "+distanceList[i]);
        }

    }
    void BFS(int u,int dest){
        visited[u]=true;
        distanceList[u]=0;
        LinkedList<Integer> queue=new LinkedList<>();
        queue.add(u);
        while(queue.size()!=0){
            int first=queue.poll();
            System.out.print(first+" ");
            ListIterator<Integer> iterator = adjList[first].listIterator();
            while(iterator.hasNext()){
                int i=iterator.next();
                if(!visited[i]){
                    visited[i]=true;
                    distanceList[i]=distanceList[first]+1;
                    queue.add(i);
                }
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        SSSP sssp =new SSSP(7);
        Scanner scan=new Scanner(System.in);
        int noOfEdges=scan.nextInt();
        for(int i=0;i<noOfEdges;i++){
            int u=scan.nextInt();
            int v=scan.nextInt();
            sssp.addEdge(u,v);
        }
        System.out.println("BFS");
        sssp.BFS(0,6);
        sssp.printGraph();
    }
}
