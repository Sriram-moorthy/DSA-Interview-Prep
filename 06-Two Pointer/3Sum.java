class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i==0 || (i>0 && nums[i]!=nums[i-1])){
                int low=i+1,high=n-1,target=-nums[i];
                while(low<high){
                    int currentValue=nums[low]+nums[high];
                    if(currentValue==target){
                        list.add(Arrays.asList(nums[low],nums[high],nums[i]));
                        while(low<high && (nums[low]==nums[low+1])) low++;
                        while(low<high && (nums[high]==nums[high-1]))high--;
                        low++;
                        high--;
                    }
                    else if(currentValue>target){
                        high--;
                    }
                    else{
                        low++;
                    }
                }
            }
        }
        return list;
    }
}
