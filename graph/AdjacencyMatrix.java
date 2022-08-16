package graph;

public class AdjacencyMatrix {
    public static void main(String[] args) {
        int v = 5;
        int e = 10;
        int a[][] = new int[v+1][v+1];
    }

    // bi directional graph
    public static void addEdge(int source, int dest, int a[][]){
        a[source][dest] = 1;
        a[dest][source] = 1;
    }
}
