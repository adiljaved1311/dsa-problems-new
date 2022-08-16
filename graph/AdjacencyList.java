package graph;

import java.util.ArrayList;

public class AdjacencyList {
    public static void main(String[] args) {
        int v = 5;
        int e = 10;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=v; i++){
            adj.add(new ArrayList<Integer>());
        }
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int source, int dest){
        adj.get(source).add(dest);
        adj.get(dest).add(source);
    }
}
