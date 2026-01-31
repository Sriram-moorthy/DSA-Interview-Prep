// Use hashmap if they are asking the index value to return

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int currentValue=target-nums[i];
            if(map.containsKey(currentValue)){
                return new int[]{map.get(currentValue),i};
            }else{
                map.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }
}

// Use Two pointer if they are asking the values
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);  
        int low=0,high=nums.length-1,sum=0;
        while(low<=high){
            sum=(arr[low]+arr[high]);
            if(sum == target) return new int[]{nums[low],nums[high]};
            else if(sum>target) high--;
            else low++;
        }
        return new int[]{-1,-1};
    }
}
