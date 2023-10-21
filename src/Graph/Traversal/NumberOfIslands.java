package Graph.Traversal;

import java.util.Arrays;

public class NumberOfIslands {

    int[] x = {0, 0, -1, 1};
    int[] y = {-1, 1, 0, 0};

    private boolean isSafe(int i, int j, int m, int n, char[][] grid, boolean[][] vis) {
        if(i>=0 && i<m && j>=0 && j<n && grid[i][j]=='1' && !vis[i][j])
            return true;
        return false;
    }

    public void dfsRecursive(int i, int j, int m, int n, char[][] grid, boolean[][] vis) {
        vis[i][j] = true;

        //visit all 4 possible directions
        for(int k=0;k<4;k++) {
            int tempRow = i + x[k];
            int tempCol = j + y[k];
            if(isSafe(tempRow, tempCol, m, n, grid, vis)) {
                dfsRecursive(tempRow, tempCol, m, n, grid, vis);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];

        for(boolean[] rows: vis)
            Arrays.fill(rows, false);

        int component = 0;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]=='1' && !vis[i][j]) {
                    dfsRecursive(i, j, m, n, grid, vis);
                    component++;
                }
            }
        }

        return component;
    }
}
