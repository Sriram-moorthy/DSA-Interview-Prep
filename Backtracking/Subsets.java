class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res,nums,0,new ArrayList<>());
        return res;
        
    }
    public void backtrack(List<List<Integer>> res, int[] nums, int pos,ArrayList<Integer> temp){
        res.add(new ArrayList(temp));
        for(int i = pos;i < nums.length; i++){
            temp.add(nums[i]);
            backtrack(res,nums,i+1,temp);
            temp.remove(temp.size()-1);
        }
    }
}
