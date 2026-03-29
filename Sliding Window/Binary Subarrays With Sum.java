class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return cnt(nums,goal) - cnt(nums, goal-1);
        
    }
    public int cnt(int[] nums, int goal){ 
        if(goal < 0) return 0;
        int count = 0, sum = 0;
        int left = 0, right = 0;
        while(right < nums.length){
            sum += nums[right];
            while(sum > goal){
                sum -= nums[left];
                left++;
            }
            count += (right - left)+1;
            right++;

        }
        return count;
    }
}
