package Graph.ShortestPath;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class DirectedGraph {

    static class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    public static ArrayList<ArrayList<UndirectedGraph.Pair>> convertEdgesToAdjWithEdges(int V, int[][] edges, boolean unDirected) {
        ArrayList<ArrayList<UndirectedGraph.Pair>> adj = new ArrayList<>();

        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new UndirectedGraph.Pair(v,w));

            if(unDirected)
                adj.get(v).add(new UndirectedGraph.Pair(u,w));
        }
        return adj;
    }

    public static int[] shortestPathWeighted(int n, int [][]edges, int src) {
        ArrayList<ArrayList<UndirectedGraph.Pair>> adj = convertEdgesToAdjWithEdges(n, edges, false);

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        Queue<Integer> q = new ArrayDeque<>();
        q.add(src);
        distance[src] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            for(UndirectedGraph.Pair neighbour : adj.get(node)) {
                if(distance[node] + neighbour.dist  < distance[neighbour.node]) {
                    distance[neighbour.node] = distance[node] + neighbour.dist;
                    q.add(neighbour.node);
                }
            }
        }

        for(int i=0;i<n;i++) {
            if(distance[i]==Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }

        return distance;
    }
}
