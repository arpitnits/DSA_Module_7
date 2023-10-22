package Graph.ShortestPath.Problems;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class WaysToReach {

    long mod = 1000000007;
    static class Pair {
        int node;
        long weight;

        Pair(int node, long weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    public int countPaths(int n, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());


        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Pair(edge[1], (long)edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0], (long)edge[2]));
        }


        long[] distance = new long[n];
        long[] ways = new long[n];
        for(int i=0;i<n;i++) {
            distance[i] = Long.MAX_VALUE;
            ways[i] = 0;
        }


        int src =0;
        PriorityQueue<Pair> q = new PriorityQueue<>((a1, b1) -> {
            if(a1.weight >= b1.weight) return 1;
            return -1;
        });
        q.add(new Pair(src, 0));
        distance[src] = 0;
        ways[src] = 1;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            for(Pair neighbour : adj.get(curr.node)) {
                if(curr.weight + neighbour.weight < distance[neighbour.node]) {
                    distance[neighbour.node] = curr.weight + neighbour.weight;
                    q.add(new Pair(neighbour.node, distance[neighbour.node]));
                    ways[neighbour.node] = ways[curr.node];
                } else if(curr.weight + neighbour.weight == distance[neighbour.node]) {
                    ways[neighbour.node] = (ways[neighbour.node] + ways[curr.node]+mod)%mod;
                }
            }
        }

        return (int)((ways[n-1] + mod)%mod);
    }
}
