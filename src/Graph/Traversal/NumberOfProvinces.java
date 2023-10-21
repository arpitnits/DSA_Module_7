package Graph.Traversal;
import java.util.Arrays;

public class NumberOfProvinces {

    public void dfsRecursive(int curr, int[][] graph, boolean[] vis, int V) {
        vis[curr] = true;
        for(int node=0;node<V;node++) {
            if(graph[curr][node] == 1 && !vis[node]) {
                dfsRecursive(node, graph, vis, V);
            }
        }
    }

    public int findCircleNum(int[][] graph) {
        int V = graph.length;
        boolean[] vis = new boolean[V];
        Arrays.fill(vis, false);
        int component = 0;
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfsRecursive(i, graph, vis, V);
                component++;
            }
        }
        return component;
    }
}
