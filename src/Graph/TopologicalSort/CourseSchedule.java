package Graph.TopologicalSort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class CourseSchedule {

    private ArrayList<ArrayList<Integer>> convertEdgesToAdj(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj  = new ArrayList<>();
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++) {
            int u = edges[i][1];
            int v = edges[i][0];

            adj.get(u).add(v);
        }
        return adj;
    }
    public boolean canFinish(int V, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = convertEdgesToAdj(V, prerequisites);

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

        int totalNode =0;

        while(!q.isEmpty()) {
            int node = q.remove();
            totalNode++;
            for(int neighbour : adj.get(node)) {
                inDegree[neighbour]--;
                if(inDegree[neighbour]==0)
                    q.add(neighbour);
            }
        }
        return totalNode==V;
    }
}
