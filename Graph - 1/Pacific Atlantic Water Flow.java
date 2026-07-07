class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] height) {
        int rows = height.length;
        int cols = height[0].length;

        List<List<Integer>> res = new ArrayList<>();
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for(int i = 0; i < rows; i++){
            dfs(height, pacific, rows, cols, i, 0, height[i][0]);
            dfs(height, atlantic, rows, cols, i, cols-1, height[i][cols-1]);
        }

        for(int j = 0; j < cols; j++){
            dfs(height, pacific, rows, cols, 0, j, height[0][j]);
            dfs(height, atlantic, rows, cols, rows-1, j, height[rows-1][j]);
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(List.of(i,j));
                }
            }
        } 
        return res;     
    }
    private void dfs(int[][] height, boolean[][] visited, int rows, int cols, int r, int c, int prevHeight){
        if(r < 0 || r >= rows || c < 0 || c >= cols || visited[r][c] || height[r][c] < prevHeight){
            return;
        }
        visited[r][c] = true;
        
        int[][] diff = {{0,1},{1,0},{-1,0},{0,-1}};

        for(int[] d : diff){
            int nr = r + d[0];
            int nc = c + d[1];

            dfs(height, visited, rows, cols, nr, nc, height[r][c]);
        }
    }
}
