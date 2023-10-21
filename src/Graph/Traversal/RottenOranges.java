package Graph.Traversal;

import java.util.*;

public class RottenOranges {

    int[] x = {0, 0, -1, 1};
    int[] y = {-1, 1, 0, 0};
    class Pair {
        int row;
        int col;
        Pair(int r, int c) {
            this.row = r;
            this.col = c;

        }
    }

    private boolean isSafe(int i, int j, int m, int n, int[][] grid, boolean[][] vis) {
        if(i>=0 && i<m && j>=0 && j<n && grid[i][j]!=0 && !vis[i][j])
            return true;
        return false;
    }
    public int orangesRotting(int[][] grid) {

        Queue<Pair> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];

        for(boolean[] rows: vis)
            Arrays.fill(rows, false);

        //push all the rotten oranges to the Queue
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 2) {
                    q.add(new Pair(i,j));
                    vis[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()) {
            Pair curr = q.remove();
            for(int k=0;k<4;k++) {
                int tempX = curr.row + x[k];
                int tempY = curr.col + y[k];
                if(isSafe(tempX, tempY, m, n, grid, vis)) {
                    q.add(new Pair(tempX, tempY));
                    grid[tempX][tempY] = grid[curr.row][curr.col] + 1;
                }
            }
        }

        int ans =0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1)
                    return -1;
                ans = Math.max(ans, grid[i][j]);
            }
        }
        return ans > 0 ? ans-2 : 0;
    }
}
