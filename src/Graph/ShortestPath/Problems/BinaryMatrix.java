package Graph.ShortestPath.Problems;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryMatrix {

    int[] x = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] y = {-1, 0, 1, -1, 1, -1, 0, 1};
    static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private boolean isSafe(int row, int col, int n, int[][] grid) {
        if(row>=0 && row<n && col>=0 && col<n && grid[row][col]==0)
            return true;

        return false;
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int[][] dis = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                dis[i][j] = Integer.MAX_VALUE;



        Queue<Pair> q = new ArrayDeque<>();
        if(isSafe(0,0, n, grid)) {
            q.add(new Pair(0, 0));
            dis[0][0] = 1;
        }

        while(!q.isEmpty()) {
            Pair curr = q.poll();

            for(int k=0;k<8;k++) {
                int tempRow = curr.row + x[k];
                int tempCol = curr.col + y[k];

                if(isSafe(tempRow, tempCol, n, grid) &&
                        dis[curr.row][curr.col] + 1 < dis[tempRow][tempCol]) {
                    dis[tempRow][tempCol] = dis[curr.row][curr.col] + 1;
                    q.add(new Pair(tempRow, tempCol));
                }
            }
        }

        return dis[n-1][n-1]!=Integer.MAX_VALUE ? dis[n-1][n-1] : -1;
    }
}
