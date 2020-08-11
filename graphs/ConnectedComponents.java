package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class ConnectedComponents {
    LinkedList<Integer> adjList[];
    int size;
    boolean visited[];
    int count;
    int componets[];

    ConnectedComponents(int n){
        count=0;
        size=n;
        visited=new boolean[size];
        adjList=new LinkedList[size];
        componets=new int[size];
        for(int i=0;i<n;i++)
            adjList[i]=new LinkedList<>();
    }
    private void addEdge(int u,int v){
        adjList[u].add(v);
    }

    private void dfs(int node){
        visited[node]=true;
        componets[node]=count;
        System.out.print(node+" ");
        ListIterator<Integer> listIterator=adjList[node].listIterator();
        while(listIterator.hasNext()){
            int n=listIterator.next();
            if(!visited[n])
                dfs(n);
        }
    }
    
    private void connected(){

        for(int i=1;i<size;i++){
            if(!visited[i]) {
                count++;
                dfs(i);
            }
        }
        System.out.println("number of components: "+count);
        for(int i=1;i<componets.length;i++){
            System.out.print(componets[i]+" ");
        }
    }
    public static void main(String[] args) {
        ConnectedComponents graph=new ConnectedComponents(6);
        graph.addEdge(1,2);
        graph.addEdge(2,4);
        graph.addEdge(3,5);
        graph.connected();
    }
}
