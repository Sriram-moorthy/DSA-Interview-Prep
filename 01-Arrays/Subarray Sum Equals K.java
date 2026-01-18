class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count=0,prefixSum=0;
        for(int i=0;i<nums.length;i++){
            prefixSum+=nums[i];
            int diff=prefixSum-k;
            if(map.containsKey(diff)){
                count+=map.get(diff);
            }
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}
