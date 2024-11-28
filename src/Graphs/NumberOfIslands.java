package Graphs;

//Number of Islands
//Given a 2D grid grid where '1' represents land and '0' represents water, count and return the number of islands.
//
//An island is formed by connecting adjacent lands horizontally or vertically and is surrounded by water.
//You may assume water is surrounding the grid (i.e., all the edges are water).

//Input: grid = [
//        ["0","1","1","1","0"],
//        ["0","1","0","1","0"],
//        ["1","1","0","0","0"],
//        ["0","0","0","0","0"]
//        ]
//Output: 1

//Input: grid = [
//        ["1","1","0","0","1"],
//        ["1","1","0","0","1"],
//        ["0","0","1","0","0"],
//        ["0","0","0","1","1"]
//        ]
//Output: 4


// Use dfs (recursive)
// WHen you meet 1 call dfs on that element;
// Inside the dfs set the value in the table on '0', thats how we know that the node is already visited

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for(int i=0;i< grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    dfsRecursion(i,j,grid);
                    islands++;
                }
            }
        }
        return islands;
    }
    public void dfsRecursion(int row, int col, char[][] grid)
    {
        if(row<0 || col<0 || row> grid.length-1 || col>grid[0].length-1 || grid[row][col]=='0')return;
        grid[row][col] = '0';
        dfsRecursion(row-1, col, grid);
        dfsRecursion(row+1, col, grid);
        dfsRecursion(row, col-1, grid);
        dfsRecursion(row, col+1, grid);
    }
    public void dfsIterative(int row, int col, char[][] grid)
    {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{row,col});
        while(!stack.empty())
        {
            int[] coord = stack.pop();
            int r = coord[0];
            int c = coord[1];

            // Mark as visited
            if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') continue;

            grid[r][c] = '0';

            // Here could be add check, so that we dont put in the stack if the new coord is acutally out of the scope
            stack.push(new int[]{r+1, c});
            stack.push(new int[]{r-1, c});
            stack.push(new int[]{r, c+1});
            stack.push(new int[]{r, c-1});

        }
    }

    int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    public void bfs(int row, int col, char[][] grid)
    {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row,col});
        while(!queue.isEmpty())
        {
            var coord = queue.poll();
            int r = coord[0];
            int c = coord[1];
            for (int[] direction : directions) {
                int newRow = r + direction[0];
                int newCol = c + direction[1];
                // WE first check if the ndoe should be put in the queue and then put it
                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == '1') {
                    queue.add(new int[]{newRow, newCol});
                    grid[newRow][newCol] = '0'; // Mark as visited
                }
            }
            // first pick upp all of the directions

        }
    }
}

//Graph:
//        1 -> [2, 3], 1 is adj to 2 and 3
//        2 -> [4]
//        3 -> []
//        4 -> [5]
//        5 -> []

//DFS :
//DFS(1, visited):
//Visit 1
//Visit 2
//Visit 4
//Visit 5
//Backtrack to 2
//Backtrack to 1
//Visit 3


