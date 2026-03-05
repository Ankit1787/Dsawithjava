package Graph.Traversal;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph{
        private int vertices;
        private LinkedList<Integer>[] adjList;

        Graph(int v){
            this.vertices=v;
            this.adjList = new LinkedList[v];
            for(int i=0;i<v;i++){
                adjList[i]=new LinkedList<>();
            }


        }
        public  int getVertices(){
            return this.vertices;
        }
        public LinkedList<Integer>getAdList(int vertex){
            return this.adjList[vertex];
        }
        void addEdge(int src,int dest){
            adjList[src].add(dest);

        }
        void breadthFirstSearch(int start){
            boolean [] visited = new boolean[vertices];

            Queue<Integer> queue = new LinkedList<>();
            visited[start] =true;
            queue.add(start);
            while(!queue.isEmpty()){
                int curr = queue.poll();
                System.out.print(curr);
                for(int neighbor:adjList[curr]){
                    if(!visited[neighbor]){
                        visited[neighbor]=true;
                        queue.add(neighbor);
                    }
                }

            }

        }




    public static void main(String[] args) {
        Graph g = new Graph(6);

        // Adding edges
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);
        System.out.println(Arrays.toString(g.adjList));

        // Perform BFS from vertex 0
        g.breadthFirstSearch(0);
    }
}

