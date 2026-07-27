class Solution {
    public int minDifference(int nums[]) {
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }
        boolean[][] dp = solve(nums, totalSum);
        int min = (int) 1e9;
        for(int i = 0 ; i <= totalSum ;i++){
            if(dp[nums.length-1][i] == true){
                int s1 = i;
                int s2 = totalSum - s1;
                min = Math.min(min, Math.abs(s1-s2));
            }
        }
        return min;
        
    }
    private boolean[][] solve(int[] nums, int target){
        boolean[][] dp = new boolean[nums.length][target+1];
        for(int i = 0 ; i < nums.length ;i++){
            dp[i][0] = true;
        }
        if(nums[0] <= target){
            dp[0][nums[0]] = true;
        }
        for(int i = 1 ; i < nums.length ;i++){
            for(int j = 1 ; j <= target; j++){
                boolean notTake = dp[i-1][j];
                boolean take = false;
                if(nums[i] <= j){
                    take = dp[i-1][j - nums[i]];
                }

                dp[i][j] = take || notTake;
            }
        }
        return dp;
    }
}
