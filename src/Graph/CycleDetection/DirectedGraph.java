package Graph.CycleDetection;

import java.util.List;

public class DirectedGraph {

    private boolean isCyclicDFS(List<List<Integer>> adj, int i, boolean[] vis, boolean[] rec) {

        if(rec[i])
            return true;
        if(vis[i])
            return false;

        vis[i] = true; rec[i] = true;
        for(int neighbour : adj.get(i)) {
            if(isCyclicDFS(adj, neighbour, vis, rec))
                return true;
        }
        rec[i] = false;
        return false;
    }
    public boolean detectCycleDFS(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean[] rec = new boolean[V];

        for(int i=0;i<V;i++) {
            if(isCyclicDFS(adj, i, vis, rec))
                return true;

        }
        return false;
    }

    public boolean detectCycleBFS(int V, List<List<Integer>> adj) {
        //if topological possible then no cycle
        //otherwise cycle

        return false;
    }
}
