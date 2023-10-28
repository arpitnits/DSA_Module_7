package Graph.MST;

public class RankApproach {



    static class node {
        int parent;
        int rank;
    }

    private node[] nodes;
    RankApproach(int N) {
        this.nodes = new node[N];
        for(int i=0;i<N;i++) {
            nodes[i].parent = -1;
            nodes[i].rank = 0;
        }
    }

    public int find(int node) {
        if(nodes[node].parent== -1)
            return node;
        return nodes[node].parent = find(nodes[node].parent);
    }

    public void union(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);

        if(p1!=p2) {
            if(nodes[p1].rank > nodes[p2].rank) {
                nodes[p2].parent = p1;
            } if(nodes[p1].rank < nodes[p2].rank) {
                nodes[p1].parent = p2;
            } else {
                nodes[p1].parent = p2;
                nodes[p2].rank++;
            }
        }
    }
}
