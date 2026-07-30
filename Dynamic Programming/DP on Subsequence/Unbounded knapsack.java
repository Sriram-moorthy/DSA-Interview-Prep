class Solution {
    public int knapSack(int val[], int wt[], int W) {
        int n = val.length;
        int[][] dp = new int[n][W+1];
        
        for(int i = 0 ; i < n ; i++){
            dp[i][0] = 0;
        }
        for(int w = 0 ; w <= W ; w++){
            dp[0][w] = (w/ wt[0]) * val[0];
        }
        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j <= W ; j++){
                int notPick = dp[i-1][j];
                int pick = 0;
                if(wt[i] <= j){
                    pick = val[i] + dp[i][j - wt[i]];
                }
                dp[i][j] = Math.max(notPick, pick);
            }
            
        }
        return dp[n-1][W];
    }
    // private int solve(int i, int[] wt, int[] val, int w, int[][] dp){
    //     if(w == 0){
    //         return 0;
    //     }
    //     if(i<0){
    //         return (int)-1e9;
    //     }
    //     if(dp[i][w] != -1) return dp[i][w];
    //     int notPick = solve(i-1, wt, val, w, dp);
    //     int pick = 0;
    //     if(wt[i] <= w){
    //         pick = val[i] + solve(i, wt, val, w-wt[i], dp);
    //     }
    //     return dp[i][w] = Math.max(pick, notPick);
    // }
}
