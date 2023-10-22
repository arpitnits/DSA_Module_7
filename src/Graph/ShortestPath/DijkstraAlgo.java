package Graph.ShortestPath;

import java.util.*;

public class DijkstraAlgo {

    static class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    public static ArrayList<ArrayList<Pair>> convertEdgesToAdjWithEdges(int V, int[][] edges, boolean unDirected) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new Pair(v,w));

            if(unDirected)
                adj.get(v).add(new Pair(u,w));
        }
        return adj;
    }

    public static List<Integer> dijkstra(int[][] edges, int n, int m, int src){
        ArrayList<ArrayList<Pair>> adj = convertEdgesToAdjWithEdges(n, edges, true);

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Pair> q = new PriorityQueue<>(Comparator.comparingInt(o1 -> o1.dist));
        q.add(new Pair(src, 0));
        distance[src] = 0;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int node = curr.node;
            int dist = curr.dist;
            for(Pair neighbour : adj.get(node)) {
                if(dist + neighbour.dist  < distance[neighbour.node]) {
                    distance[neighbour.node] = dist + neighbour.dist;
                    q.add(new Pair(neighbour.node, distance[neighbour.node]));
                }
            }
        }

        for(int i=0;i<n;i++) {
            if(distance[i]==Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }

        List<Integer> dis = new ArrayList<>();
        for(int i=0;i<n;i++)
            dis.add(distance[i]);

        return dis;
    }

}
