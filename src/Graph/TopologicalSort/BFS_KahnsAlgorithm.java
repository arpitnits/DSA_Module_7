package Graph.TopologicalSort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BFS_KahnsAlgorithm {

    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new ArrayDeque<>();

        int[] inDegree = new int[V];

        //Calculate inDegree
        for(int i=0;i<V;i++) {
            for(int neighbour : adj.get(i)) {
                inDegree[neighbour]++;
            }
        }

        //push inDegree =0 in queue
        for(int i=0;i<V;i++) {
            if(inDegree[i]==0)
                q.add(i);
        }

        int[] sorted = new int[V];
        int i=0;

        while(!q.isEmpty()) {
            int node = q.remove();
            sorted[i++] = node;

            for(int neighbour : adj.get(node)) {
                inDegree[neighbour]--;
                if(inDegree[neighbour]==0)
                    q.add(neighbour);
            }
        }

        return sorted;
    }
}
