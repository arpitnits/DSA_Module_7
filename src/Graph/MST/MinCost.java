package Graph.MST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinCost {

    static class node {
        int parent;
        int rank;
    }

    private static node[] nodes;
    private static void intialize(int N) {
        nodes = new node[N];
        for(int i=0;i<N;i++) {
            nodes[i] = new node();
            nodes[i].parent = -1;
            nodes[i].rank = 0;
        }
    }

    public static int find(int node) {
        if(nodes[node].parent == -1)
            return node;
        else {
            nodes[node].parent = find(nodes[node].parent);
            return nodes[node].parent;
        }

    }

    public static void union(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);

        if(p1!=p2) {
            if(nodes[p1].rank > nodes[p2].rank) {
                nodes[p2].parent = p1;
            }  else if(nodes[p1].rank < nodes[p2].rank) {
                nodes[p1].parent = p2;
            } else {
                nodes[p1].parent = p2;
                nodes[p2].rank++;
            }
        }
    }
    public static List<List<Integer>> createEdges(int V, int[][] points) {
        List<List<Integer>> adj = new ArrayList<>();


        for(int i=0;i<V;i++) {
            for(int j=i+1; j<V;j++) {
                int xDiff = Math.abs(points[i][0] - points[j][0]);
                int yDiff = Math.abs(points[i][1] - points[j][1]);
                int w = xDiff + yDiff; //manhattan Distance
                List<Integer> temp = new ArrayList<>();
                temp.add(w); // edgeWeight
                temp.add(i); // adding src
                temp.add(j); // adding dst
                adj.add(temp); //adding each edge
            }
        }
        return adj;
    }
    public static int minCostConnectPoints(int[][] points) {
        int V = points.length;
        List<List<Integer>> graph = createEdges(V, points);

        //sort all according to edgesWeight
        graph.sort(Comparator.comparingInt(obj -> obj.get(0)));
        int counter = 0, cost = 0;

        intialize(V);

        for(List<Integer> edges : graph) {
            int w = edges.get(0);
            int u = edges.get(1);
            int v = edges.get(2);


            int leader1 = find(u);
            int leader2 = find(v);

            if(leader1!=leader2) {
                union(leader1, leader2);
                cost+= w;
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println(minCostConnectPoints(points));
    }
}
