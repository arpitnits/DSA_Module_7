package Graph.ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {


    public static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int s) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[s] = 0;


        //Relax edges For (N-1)
        for(int i=0;i<V-1;i++) {
            for (ArrayList<Integer> edge : edges) {
                int u = edge.get(0);
                int v = edge.get(1);
                int w = edge.get(2);
                if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                    distance[v] = distance[u] + w;
                }
            }
        }

        //Check for N-th Relaxation
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                int[] ans = new int[1];
                ans[0] = -1;
                return ans;
            }
        }

        return distance;
    }
}
