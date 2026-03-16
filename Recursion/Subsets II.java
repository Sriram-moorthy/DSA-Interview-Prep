class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = generate(nums);
        return list;
    }
    public List<List<Integer>> generate(int[] nums){
        Arrays.sort(nums);
        int start = 0;
        int end = 0;
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int i=0 ;i<nums.length ;i++){
            start = 0;
            int n = outer.size();
            if(i > 0 && nums[i]==nums[i-1]){
                start = end+1;
            }
            end = outer.size()-1;
            for(int j=start ; j<n ; j++){
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(nums[i]);
                outer.add(internal);
            }
        }
        return outer;
    }
}
