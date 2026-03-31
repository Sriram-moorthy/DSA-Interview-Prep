class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), 0, nums);
        return res;

    }
    public void backtrack(List<List<Integer>> res, ArrayList<Integer> temp, int index, int[] nums){
        
        if(temp.size() >= 2){
            res.add(new ArrayList<>(temp));
        }

        HashSet<Integer> used = new HashSet<>();
        for(int i=index ; i < nums.length ;i++){
            if(used.contains(nums[i])) continue;
            if(temp.isEmpty() || temp.get(temp.size()-1) <= nums[i]){
                used.add(nums[i]);
                temp.add(nums[i]);
                backtrack(res,temp,i+1,nums);
                temp.remove(temp.size()-1);
            }
        }
    }
}
