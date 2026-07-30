class Solution {
    public int cutRod(int[] price) {
        int n = price.length;
        int[][] dp = new int[n][n+1];
        for(int i = 0 ; i <= n ;i++){
            dp[0][i] = (i* price[0]);
        }
        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j <= n ;j++){
                int notPick = dp[i-1][j];
                int pick = Integer.MIN_VALUE;
                int rodLength = i+1;
                if(j >= rodLength){
                    pick = price[i] + dp[i][j - rodLength];
                }
                dp[i][j] = Math.max(notPick, pick);
            }
        }
        return dp[n-1][n];
        
    }
    // private int solve(int i, int[] price, int n, int[][] dp){
    //     if(i == 0){
    //         return (n * price[0]);
    //     }
    //     if(dp[i][n] != -1) return dp[i][n];
    //     int notPick = solve(i-1, price, n, dp);
    //     int pick = Integer.MIN_VALUE;
    //     int rodLength = i+1;
    //     if(rodLength <= n){
    //         pick = price[i] + solve(i, price, n-rodLength, dp);
    //     }
    //     return dp[i][n] = Math.max(pick, notPick);
    // }
}
