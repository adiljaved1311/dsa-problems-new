package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BFSCheck {
    private LinkedList<Integer> adj[]; //Adjacency Lists
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(0, Arrays.asList(1,2,3));
        adj.add(1, Arrays.asList(2,1,4));
        adj.add(2, Arrays.asList(4,2));
        adj.add(2, Arrays.asList(5));
        int v = 6;
        int e = 8;
        int pred[] = new int[v+1];
        int dist[] = new int[v+1];
        boolean isReached = bfs(adj, 1, 6, v, pred, dist);
    }
    public static boolean bfs(List<List<Integer>> adj, int src, int dest, int v, int pred[], int dist[]){
        //Initialize a Queue
        LinkedList<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[v];
        for(int i=0; i<v; i++){
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }
        visited[src] = true;
        dist[src] = 0;
        queue.add(src);

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int i=1;i<adj.get(cur).size(); i++){
                int neighbour = adj.get(cur).get(i);
                if(visited[neighbour] == false){
                    visited[neighbour] = true;
                    dist[neighbour] = dist[cur]+1;
                    pred[neighbour] = cur;
                    queue.add(neighbour);

                    if(neighbour == dest)
                        return true;
                }
            }
        }
        return false;
    }
}
