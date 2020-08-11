package graphs;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class BFS_DFS {
    LinkedList<Integer> adjList[];
    int N;
    boolean visited[];

    BFS_DFS(int n){
        N=n;
        adjList=new LinkedList[N];
        for(int i=0;i<N;i++){
            adjList[i]=new LinkedList<Integer>();
    }
        visited=new boolean[n];
    }

    void addEdge(int u,int v){
        adjList[u].add(v);
    }
    void printGraph(){
        for(int i=0;i<N;i++){
            System.out.print(i+" ");
            for(int j=0;j<adjList[i].size();j++){
                System.out.print(" "+adjList[i].get(j));
            }
            System.out.println();
        }
    }
    void BFS(int u){
        visited[u]=true;
        LinkedList<Integer> queue=new LinkedList<>();
        queue.add(u);
        while(queue.size()!=0){
            int first=queue.poll();
            System.out.print(first+" ");
            ListIterator<Integer> iterator = adjList[first].listIterator();
            while(iterator.hasNext()){
                int i=iterator.next();
                if(!visited[i]){
                    visited[i]=true ;
                    queue.add(i);
                }
            }
        }
        System.out.println();
    }
    void DFS(int u,boolean[] visited){
        visited[u]=true;
        System.out.print(u+" ");
        ListIterator<Integer> iterator=adjList[u].listIterator();
        while(iterator.hasNext()){
            int i=iterator.next();
            if(!visited[i]){
                DFS(i,visited);
            }
        }
    }

    public static void main(String[] args) {
        BFS_DFS bfsDFS =new BFS_DFS(4);
        Scanner scan=new Scanner(System.in);
        int noOfEdges=scan.nextInt();
        for(int i=0;i<noOfEdges;i++){
            int u=scan.nextInt();
            int v=scan.nextInt();
            bfsDFS.addEdge(u,v);
        }
        bfsDFS.printGraph();
        System.out.println("********BFS_DFS**********");
        bfsDFS.BFS(2);
        boolean vist[]=new boolean[4];
        System.out.println("********BFS_DFS**********");
        bfsDFS.DFS(2,vist);

    }
}
