package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GraphAlgorithms {

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[V];
        ArrayList<Integer> bfs = new ArrayList<>();

        q.add(0);
        vis[0] = true;


        while(!q.isEmpty()) {
            int currNode = q.remove();
            bfs.add(currNode);
            for(int node : adj.get(currNode)) {
                if(!vis[node]) {
                    q.add(node);
                    vis[node] = true;
                }
            }
        }
        return bfs;
    }

    public void dfsRecursive(int curr, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> dfs) {
        vis[curr] = true;
        dfs.add(curr);
        for(int node : adj.get(curr)) {
            if(!vis[node])
                dfsRecursive(node, adj, vis,dfs);
        }
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Arrays.fill(vis, false);

        ArrayList<Integer> dfs = new ArrayList<>();
        for(int i=0;i<V;i++) {
            if(!vis[i]) {
                dfsRecursive(i, adj, vis, dfs);
            }
        }
        return dfs;
    }
}
