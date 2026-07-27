class Solution {
    static boolean isSubsetSum(int arr[], int sum) {
        boolean[][] dp = new boolean[arr.length][sum+1];
        for(int i = 0 ; i < arr.length; i++){
            dp[i][0] = true;
        }
        if(arr[0] <= sum)
        dp[0][arr[0]] = true;
        for(int i = 1; i < arr.length ; i++){
            for(int target = 1 ; target <= sum ; target++){
                boolean notTake = dp[i-1][target];
                boolean take = false;
                if(target >= arr[i]){
                    take = dp[i-1][target - arr[i]];
                }
                dp[i][target] = take || notTake;
            }
            
        }
        return dp[arr.length-1][sum];
    }
    // private static boolean solve(int ind, int[] arr, int target, Boolean[][] dp){
    //     if(target == 0){
    //         return true;
    //     }
    //     if(ind == 0){
    //         return arr[0] == target;
    //     }
    //     if(dp[ind][target] != null) return dp[ind][target];
    //     boolean notTake = solve(ind-1, arr, target, dp);
    //     boolean take = false;
    //     if(target >= arr[ind]){
    //         take = solve(ind-1, arr, target - arr[ind], dp);
    //     }
    //     return dp[ind][target] = take || notTake;
    // }
}
