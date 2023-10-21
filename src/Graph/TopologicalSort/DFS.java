package Graph.TopologicalSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class DFS {

    private void dfsRecursive(int curr, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> stack) {
        vis[curr] = true;
        for(int node : adj.get(curr)) {
            if(!vis[node])
                dfsRecursive(node, adj, vis,stack);
        }
        stack.add(curr);
    }
    public int[] dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Arrays.fill(vis, false);

        Stack<Integer> s = new Stack<>();

        for(int i=0;i<V;i++) {
            if(!vis[i]) {
                dfsRecursive(i, adj, vis, s);
            }
        }

        int[] sorted = new int[V];
        int  i=0;
        while(!s.empty() && i<V) {
            sorted[i++] = s.pop();
        }

        return sorted;
    }
}
