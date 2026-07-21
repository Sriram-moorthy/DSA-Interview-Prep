class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int cols = triangle.get(triangle.size()-1).size();
        int[][] dp = new int[rows][cols];
        
        for(int i = 0 ; i < cols ; i++){
            dp[rows-1][i] = triangle.get(rows-1).get(i);
        }

        for(int i = rows-2; i>=0 ;i--){
            for(int j = i ; j >=0 ; j--){
                int down = triangle.get(i).get(j) + dp[i+1][j];
                int downRight = triangle.get(i).get(j) + dp[i+1][j+1];

                dp[i][j] = Math.min(down, downRight);
            }
        }
        return dp[0][0];
    } 
    
}
