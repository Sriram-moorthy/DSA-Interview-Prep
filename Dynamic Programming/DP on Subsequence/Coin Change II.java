class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i = 0 ; i <= amount ; i++){
            if(i % coins[0] == 0){
                dp[0][i] = 1;
            }
        }
        for(int i = 1; i < n ; i++){
            for(int j = 0 ; j <= amount ; j++){
                int notPick = dp[i-1][j];
                int pick = 0;
                if(coins[i] <= j){
                    pick = dp[i][j - coins[i]];
                }
                dp[i][j] = pick + notPick;
            }
        }
        return dp[n-1][amount];
    }
    // private int solve(int i, int[] coins, int target, int[][] dp){
    //     if(target == 0) return 1;
    //     if(target < 0) return 0;
    //     if(i == 0){
    //         if(target % coins[0] == 0){
    //             return 1;
    //         }else{
    //             return 0;
    //         }
    //     }
    //     if(dp[i][target] != -1) return dp[i][target];
    //     int notPick = solve(i-1, coins, target, dp);
    //     int pick = 0;
    //     if(coins[i] <= target){
    //         pick = solve(i, coins, target - coins[i], dp);
    //     }
    //     return dp[i][target] = pick + notPick;
    // }
}
