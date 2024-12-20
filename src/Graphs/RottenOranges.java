package Graphs;
//You are given a 2-D matrix grid. Each cell can have one of three possible values:
//
//        0 representing an empty cell
//1 representing a fresh fruit
//2 representing a rotten fruit
//Every minute, if a fresh fruit is horizontally or vertically adjacent to a rotten fruit, then the fresh fruit also becomes rotten.
//
//Return the minimum number of minutes that must elapse until there are zero fresh fruits remaining.
// If this state is impossible within the grid, return -1.

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    Queue<int[]> queue =  new LinkedList<>();
    public int orangesRotting(int[][] grid) {
        for(int i=0; i<grid.length;i++)
        {
            for(int j=0; j<grid[0].length;j++)
            {
                // Find rotten, insert them into the queue
               if(grid[i][j]==2)
               {
                   queue.add(new int[]{i, j});
               }
            }
        }
        int mintues = 0;
        // There can be a case, in the last step
        // that we did not rotten any orange
        // in that case we dont increment minutes
        boolean changesMade = false;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            // Rem
            changesMade = false;
            while(size>0) {
                int[] coord = queue.poll();
                size--;
                if(updateRotting(coord, grid,queue))
                {
                    changesMade = true;
                }
            }
            if(changesMade)mintues++;
        }
        // If there are still fresh oranges
        // there is no solution
        if(freshExists(grid))return -1;
        return mintues;
    }
    public boolean freshExists(int[][] grid)
    {
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean updateRotting(int[] coord, int[][] grid, Queue<int[]> queue)
    {
        int[][] dimensions = {{1,0}, {-1,0}, {0,-1}, {0,1}};
        boolean res = false;
        for(int i=0; i<4;i++)
        {
            int r = coord[0]+dimensions[i][0];
            int c = coord[1]+dimensions[i][1];
            if(r>=0 && r<grid.length && c>=0 && c<grid[0].length)
            {
                if(grid[r][c]==1){
                    queue.add(new int[]{r, c});
                    res = true;
                    grid[r][c] = 2;
                }
            }
        }
        return res;
    }
}
