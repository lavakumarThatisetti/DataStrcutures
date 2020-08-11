package problemsolving;
import java.util.*;
    public class DFS
    {
        int V;
        LinkedList<Integer> adjList[];
        HashMap<Integer,String> map=new HashMap<>();
        DFS(int v)
        {
            V = v;
            adjList = new LinkedList[v];
            for (int i=0; i<v; ++i)
            {
                adjList[i] = new LinkedList();  //it will create empty list for every node
            }
        }
        void addEdgesToGraph(int v, int u)
        {
            adjList[v].add(u);//here it will add vertex to adjacency list of another vertex so that edge can be added to graph.
        }
        // depth first traversal is used by depth first search. it will traverse one strong component completely
        void DFTraversal(int v,int visited[])
        {
            visited[v] = 1;
            System.out.print(v + " "+map.get(v));
            Iterator<Integer> i = adjList[v].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (visited[n]==0)
                    DFTraversal(n, visited);
            }
        }

        //depth first search will call depth fist traversal on disconnected components. it will keep track of visited[] array.
        void DFSearch(int v)
        {

            int visited[] = new int[V];

            DFTraversal(v, visited);
            for (int i=1;i<V;i++)
            {
                if(visited[i]==0)
                {
                    DFTraversal(i, visited);
                }
            }
        }
        void insertMap(){
            map.put(1,"Bangalore");
            map.put(2,"Hyderabad");
            map.put(3,"Mumbai");
            map.put(4,"Delhi");
            map.put(5,"chennai");
            map.put(6,"Kerala");
        }

        public static void main(String args[])
        {
            DFS obj = new DFS(7);

            obj.addEdgesToGraph(1,2);
            obj.addEdgesToGraph(1,5);
            obj.addEdgesToGraph(2,3);
            obj.addEdgesToGraph(2,4);
            obj.addEdgesToGraph(5,6);
            obj.insertMap();


            obj.DFSearch(1);
        }
    }

