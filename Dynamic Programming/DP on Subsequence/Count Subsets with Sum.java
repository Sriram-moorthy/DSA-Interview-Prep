class Solution {
    static int perfectSum(int[] arr, int target) {
        int n = arr.length;
        int MOD = 1000000007;
        int[][] dp = new int[n][target + 1];

if(arr[0] == 0)
    dp[0][0] = 2;
else
    dp[0][0] = 1;

if(arr[0] != 0 && arr[0] <= target)
    dp[0][arr[0]] = 1;
        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j <= target ; j++){
                int notPick = dp[i-1][j];
                int pick = 0;
                if(arr[i] <= j){
                    pick = dp[i-1][j- arr[i]];
                }
                dp[i][j] = (pick + notPick) % MOD;
            }
        }
        return dp[n-1][target];
    }
    // private static int solve(int[] arr, int target, int ind, int[][] dp){
    //     if (ind == 0) {
    //         if (target == 0 && arr[0] == 0)
    //             return 2;

    //         if (target == 0 || arr[0] == target)
    //             return 1;

    //         return 0;
    //     }
    //     if(dp[ind][target] != -1) return dp[ind][target];
    //     int notPick = solve(arr, target, ind-1, dp);
    //     int pick = 0;
    //     if(arr[ind] <= target){
    //         pick = solve(arr, target - arr[ind], ind-1, dp);
    //     }
    //     return dp[ind][target] = pick + notPick;
    // }
}
