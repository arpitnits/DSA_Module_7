package Graph.MST;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgo {

    static class Pair {
        int weight;
        int node;

        Pair(int node, int w) {
            this.node = node;
            this.weight = w;
        }
    }
    public static List<List<Pair>> convertEdgesToAdj(int V, int[][] edges, boolean unDirected) {
        List<List<Pair>> adj = new ArrayList<>();

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


    public static int spanningTree(int V, int E, int[][] edges){
        List<List<Pair>> adj = convertEdgesToAdj(V, edges, true);
        boolean[] vis = new boolean[V];

        //Min Heap on basis of weight
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(obj -> obj.weight));
        pq.add(new Pair(0, 0));

        int counter = -1, cost=0;

        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int currNode = curr.node;

            if(!vis[currNode]) {
                counter++;
                cost+= curr.weight;
                vis[currNode] = true;

                //vis all adjacent neighbours
                for(Pair neighbour : adj.get(currNode)) {
                    if(!vis[neighbour.node]) {
                        pq.add(new Pair(neighbour.node, neighbour.weight));
                    }
                }
            }
            if(counter==V-1)
                break;

        }
        return cost;
    }
}
