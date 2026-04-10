class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length;
        int maxArea = 0;
        for(int row = 0 ; row < rowSize ; row++){
            for(int col = 0 ; col < colSize ; col++){
                if(grid[row][col] == 1){
                    maxArea = Math.max(maxArea,dfs(grid, row, col));
                }
            }
        }
        return maxArea;
    }
    public int dfs(int[][] grid, int row , int col){
        
        grid[row][col] = 2;
        int[][] diff = {{0,1},{0,-1},{1,0},{-1,0}};
        int currentArea = 1;
        for(int[] d: diff){
            int nr = row + d[0];
            int nc = col + d[1];

            if(nr >=0 && nr < grid.length && nc >=0 && nc < grid[0].length && grid[nr][nc] == 1){
                currentArea += dfs(grid,nr,nc);
            }
        }
        return currentArea;
    }
}
