class Solution {
    public int countPartitions(int[] arr, int diff) {
        int total = 0;
        for(int num : arr){
            total += num;
        }
        if(total - diff < 0) return 0;
        if((total - diff) % 2 != 0) return 0;
        int target = (total - diff)/2;
        int[][] dp = new int[arr.length][target+1];
        
        if(arr[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;
        
        if(arr[0] != 0 && arr[0] <= target){
            dp[0][arr[0]] = 1;
        }
        
        for(int i =1 ; i < arr.length ; i++){
            for(int j = 0 ; j <= target ; j++){
                int notPick = dp[i-1][j];
                int pick = 0;
                if(arr[i] <= j){
                    pick = dp[i-1][j - arr[i]];
                }
                dp[i][j] = pick + notPick;
            }
        }
        return dp[arr.length-1][target];
        
    }
    // private int solve(int[] arr, int target, int i, int[][] dp){
    //     if(i == 0){
    //         if(arr[0] == 0 && target == 0){
    //             return 2;
    //         }
    //         if(target == 0 || target == arr[0]){
    //             return 1;
    //         }
    //         return 0;
    //     }
    //     if(dp[i][target] != -1) return dp[i][target];
    //     int notPick = solve(arr, target, i-1, dp);
    //     int pick = 0;
    //     if(arr[i] <= target){
    //         pick = solve(arr, target - arr[i], i-1, dp);
    //     }
    //     return dp[i][target] = pick + notPick;
    // }
}
