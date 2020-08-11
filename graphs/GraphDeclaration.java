package graphs;

import java.util.LinkedList;
import java.util.Scanner;

public class GraphDeclaration {

    LinkedList<LinkedList<Integer>> adjList;
    int N;

    GraphDeclaration(int n){
        N=n;
        adjList=new LinkedList<LinkedList<Integer>>();
        for(int i=0;i<N;i++){
            adjList.add(new LinkedList<Integer>());
        }
    }

    void addEdge(int u,int v){
        adjList.get(u).add(v);
    }
    void printGraph(){
        for(int i=0;i<N;i++){
            System.out.print(i+" ");
           for(int j=0;j<adjList.get(i).size();j++){
               System.out.print(" "+adjList.get(i).get(j));
           }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphDeclaration graphDeclaration=new GraphDeclaration(4);
        Scanner scan=new Scanner(System.in);
        int noOfEdges=scan.nextInt();
        for(int i=0;i<noOfEdges;i++){
            int u=scan.nextInt();
            int v=scan.nextInt();
            graphDeclaration.addEdge(u,v);
        }
        graphDeclaration.printGraph();

    }
}
