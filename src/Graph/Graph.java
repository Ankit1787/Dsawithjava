package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {

    public static void main(String[] args) {
        int v=3;
        int [][] mat = new int[v][v];
        List <List<Integer>> list = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            list.add(new ArrayList<>());
        }
        addEdges(mat,0,1);
        addEdges(mat,0,2);
        addEdges(mat,1,2);
        addEdge(list,0,1);
        addEdge(list,0,2);
        addEdge(list,1,2);
        System.out.println(Arrays.deepToString(mat));
        System.out.println(list);
    }
   public static void addEdges(int [][] mat,int i,int j){
        mat[i][j]=1;
        mat[j][i]=1;

    }
    public static void addEdge(List <List<Integer> >list,int i,int j){
        list.get(i).add(j+1);
        list.get(j).add(i+1);


    }
}
