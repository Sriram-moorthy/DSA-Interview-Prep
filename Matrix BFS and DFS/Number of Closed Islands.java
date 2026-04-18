class Solution {
    public int closedIsland(int[][] grid) {
        int count = 0;
        for(int row = 0 ; row < grid.length ; row++){
            for(int col = 0 ; col < grid[0].length ; col++){
                if(grid[row][col] == 0){
                    if(row == 0 || row == grid.length-1 || col == 0 || col==grid[0].length-1){
                        dfs(grid, row, col);
                    }
                }
                
            }
        }
        for(int row = 0 ; row < grid.length ; row++){
            for(int col = 0 ; col < grid[0].length ; col++){
                if(grid[row][col] == 0){
                    count++;
                    dfs(grid,row, col);
                }
            }
        }
        return count;
    }
    private void dfs(int[][] grid, int row , int col){
        int[][] diff = {{0,1},{1,0},{-1,0},{0,-1}};
        if(row  < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 1){
            return;
        }
        grid[row][col] = 1;
        for(int[] d: diff){
            int nr = row + d[0];
            int nc = col + d[1];

            dfs(grid, nr, nc);
        }
    }
}
