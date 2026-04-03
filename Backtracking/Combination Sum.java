class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;

    }
    public void backtrack(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int index, int sum){
        if(sum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        if(sum > target){
            return;
        }
        if(index >= candidates.length) return;
        list.add(candidates[index]);
        backtrack(res, list, candidates, target, index, sum+candidates[index]);
        list.remove(list.size()-1);
        backtrack(res, list, candidates, target, index+1, sum);

    }
}
