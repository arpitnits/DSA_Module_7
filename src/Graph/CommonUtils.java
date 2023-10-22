package Graph;

import java.util.ArrayList;

public class CommonUtils {

    public static ArrayList<ArrayList<Integer>> convertEdgesToAdj(int V, int[][] edges, boolean unDirected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<V;i++)
            adj = new ArrayList<>();

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);

            if(unDirected)
                adj.get(v).add(u);
        }
        return adj;
    }

}
