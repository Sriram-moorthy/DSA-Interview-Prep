class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), n, k, 1);
        return res;
    }
    public void backtrack(List<List<Integer>> res, List<Integer> list, int n, int k, int num){
        if(list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        if(num > n){
            return;
        }
        list.add(num);
        backtrack(res, list, n, k, num+1);
        list.remove(list.size()-1);
        backtrack(res, list, n, k, num+1);
        
    }
}
