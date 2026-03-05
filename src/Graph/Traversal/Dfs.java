package Graph.Traversal;

import java.util.LinkedList;

 class Dfs extends Graph {

    Dfs(int v) {
        super(v);
    }
    private  void dfsTraversal(int start){
        boolean[] visited = new boolean[getVertices()];
        dfsUtil(start, visited);
        System.out.println();


    }
    private void dfsUtil(int vertex,boolean [] visited){
        visited[vertex]=true;
        System.out.print(vertex+" ");
        for(int neighbor:getAdList(vertex)){
           if(!visited[neighbor]){
               dfsUtil(neighbor,visited);
           }
        }
    }

    public static void main(String[] args) {
        Dfs graph = new Dfs(6);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(2,4);
        graph.addEdge(3,5);
        graph.addEdge(4,5);
        graph.breadthFirstSearch(0);
        System.out.println("DFS: ");

        graph.dfsTraversal(0);


    }
}
