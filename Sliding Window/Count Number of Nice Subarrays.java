class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return count(nums,k)-count(nums,k-1);
    }
    public int count(int[] nums,int k){
        int right=0,left=0,sum=0,count=0;
        while(right<nums.length){
            sum=sum+nums[right]%2;
            while(sum>k){
                sum-=nums[left]%2;
                left++;
            }
            count=count+(right-left)+1;
            right++;
        }
        return count;

    }
}
