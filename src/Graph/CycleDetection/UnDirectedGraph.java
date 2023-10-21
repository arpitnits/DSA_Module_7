package Graph.CycleDetection;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class UnDirectedGraph {


    private boolean isCyclicDFS(List<List<Integer>> adj, int i, boolean[] vis, int parent) {

        vis[i] = true;
        for(int node : adj.get(i)) {
            if(!vis[node]) {
                if(isCyclicDFS(adj, node, vis, i))
                    return true;
            } else if (node!=parent) {
                return true;
            }
        }
        return false;
    }
    public boolean detectCycleDFS(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];

        for(int i=0;i<V;i++) {
            if(!vis[i]) {
                if(isCyclicDFS(adj, i, vis, -1))
                    return true;
            }
        }
        return false;
    }


    static class Pair {
        int node;
        int parent;

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    private boolean isCyclicBFS(int i, List<List<Integer>> adj, boolean[] vis) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(i, -1));
        vis[i] = true;

        while(!q.isEmpty()) {
            Pair curr = q.remove();

            //check for all neighbours
            for(int neighbour : adj.get(curr.node)) {
                if(!vis[neighbour]) {
                    vis[neighbour] = true;
                    q.add(new Pair(neighbour, curr.node));
                } else if(neighbour!= curr.parent) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean detectCycleBFS(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];

        for(int i=0;i<V;i++) {
            if(!vis[i])
                if(isCyclicBFS(i, adj, vis))
                    return true;
        }

        return false;
    }
}
