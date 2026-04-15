class Solution {
    public ArrayList<String> ratInMaze(int[][] grid) {
        ArrayList<String> res = new ArrayList<>();
        int n = grid.length;
        int[][] vis = new int[n][n];

        // Edge case: If start or end is blocked
        if (grid[0][0] == 0 || grid[n - 1][n - 1] == 0) {
            return res;
        }

        find(grid, 0, 0, res, "", vis);
        return res;
    }

    public void find(int[][] grid, int row, int col, ArrayList<String> res, String p, int[][] vis) {
        // Base Case: Reached destination
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            res.add(p);
            return;
        }

        // 1. Mark current cell as visited
        vis[row][col] = 1;

        // 2. Try all 4 directions (Lexicographical order: D, L, R, U)
        
        // DOWN: Check if row+1 is valid, not visited, and is a path (1)
        if (row + 1 < grid.length && vis[row + 1][col] == 0 && grid[row + 1][col] == 1) {
            find(grid, row + 1, col, res, p + "D", vis);
        }

        // LEFT: Check if col-1 is valid, not visited, and is a path (1)
        if (col - 1 >= 0 && vis[row][col - 1] == 0 && grid[row][col - 1] == 1) {
            find(grid, row, col - 1, res, p + "L", vis);
        }

        // RIGHT: Check if col+1 is valid, not visited, and is a path (1)
        if (col + 1 < grid[0].length && vis[row][col + 1] == 0 && grid[row][col + 1] == 1) {
            find(grid, row, col + 1, res, p + "R", vis);
        }

        // UP: Check if row-1 is valid, not visited, and is a path (1)
        if (row - 1 >= 0 && vis[row - 1][col] == 0 && grid[row - 1][col] == 1) {
            find(grid, row - 1, col, res, p + "U", vis);
        }

        // 3. BACKTRACK: Unmark this cell so other paths can use it
        vis[row][col] = 0;
    }
}
