package Graph.MST;

public class DisjointSet {

    private int[] parent;

    DisjointSet(int N) {
        parent = new int[N];
        for(int i=0;i<N;i++) {
            parent[i] = -1;
        }
    }

    public int find(int node) {
        if(parent[node]== -1)
            return node;
        return find(parent[node]);
    }

    public void union(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);

        if(p1!=p2)
            parent[p1] = p2;
    }
}
