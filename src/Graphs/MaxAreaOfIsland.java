package Graphs;

//Max Area of Island
//You are given a matrix grid where grid[i] is either a 0 (representing water) or 1 (representing land).
//
//An island is defined as a group of 1's connected horizontally or vertically. You may assume all four edges of the grid are surrounded by water.
//
//The area of an island is defined as the number of cells within the island.
//
//Return the maximum area of an island in grid. If no island exists, return 0.

//nput: grid = [
//        [0,1,1,0,1],
//        [1,0,1,0,1],
//        [0,1,1,0,1],
//        [0,1,0,0,1]
//        ]
//
//Output: 6

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland {
    int max = 0;
    int [][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        for(int i = 0; i<grid.length; i++)
        {
            for(int j=0; j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    max = Math.max(max, bfs(i,j,grid));
                }
            }
        }
        return max;
    }
    public int bfs(int row, int col, int[][] grid)
    {
        Queue<int[]> queue = new LinkedList<>();
        grid[row][col] = 0;
        int surface = 1;
        queue.add(new int[]{row, col});
        while(!queue.isEmpty())
        {
            int[] coord = queue.poll();
            int r = coord[0];
            int c = coord[1];
            for(int[] direction:directions)
            {
                int nRow = r+direction[0];
                int nCol = c+direction[1];
                if(nRow>=0  && nRow<grid.length && nCol>=0 && nCol<grid[0].length && grid[nRow][nCol]==1)
                {
                    surface++;
                    grid[nRow][nCol] = 0;
                    queue.add(new int[]{nRow, nCol});
                }
            }
        }
        return surface;
    }

}
