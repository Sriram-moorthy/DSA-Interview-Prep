class Solution {
    public int islandPerimeter(int[][] grid) {
        int peri = 0;
        int[][] diff = {{0,1},{1,0},{-1,0},{0,-1}};
        for(int i = 0 ; i< grid.length; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1){
                    peri += 4;
                    for(int[] d: diff){
                        int nr = i + d[0];
                        int nc = j + d[1];
                        if(nr >=0 && nr < grid.length && nc >=0 && nc < grid[0].length){
                            if(grid[nr][nc] == 1){
                                peri -= 1;
                            }
                        }
                    }
                }
            }
        }
        return peri;
    }
}
