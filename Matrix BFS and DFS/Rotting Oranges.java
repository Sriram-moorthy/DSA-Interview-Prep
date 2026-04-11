class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        int min=0;
        int fresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new int[] {i,j,0});
                }
                if(grid[i][j]==1){
                    fresh+=1;
                }
            }
        }
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            min=curr[2];

            for(int[] d:dirs){
                int nr=r+d[0];
                int nc=c+d[1];

                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1){
                    grid[nr][nc]=2;
                    fresh--;
                    q.offer(new int[]{nr,nc,min+1});
                }
            }
        }
        if(fresh!=0) return -1;
        return min;
    }
}
