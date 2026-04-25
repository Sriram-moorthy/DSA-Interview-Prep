class Solution {
    public int[][] updateMatrix(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] ans = new int[row][col];

        for(int[] rows : ans){
            Arrays.fill(rows,-1);
        }

        Queue<int[]> q = new LinkedList<>();
        int dist = 0;
        for(int i = 0; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(grid[i][j] == 0){
                    ans[i][j] = 0;
                    q.add(new int[]{i,j});
                }
            }
        }
        int[][] diff = {{0,1},{0,-1},{-1,0},{1,0}};
        while(!q.isEmpty()){
            int[] arr = q.poll();
            int r = arr[0];
            int c = arr[1];

            for(int[] d : diff){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr >=0 && nr < row && nc >= 0 && nc < col && ans[nr][nc] == -1){
                    ans[nr][nc] = ans[r][c] +1;
                    q.add(new int[]{nr,nc});
                }
            }

        } 
        return ans;
    }
}
