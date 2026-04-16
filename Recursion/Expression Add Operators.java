class Solution {
    public List<String> addOperators(String num, int target) {
         List<String> res = new ArrayList<>();
         dfs(num, target, 0, 0, 0, "", res);
         return res;
    }
    private void dfs(String num, int target, int start, long currValue, long lastOperand, String exp, List<String> res){
        if(start == num.length()){
            if(currValue == target){
                res.add(exp);
            }
            return;
        }
        for(int i = start ; i < num.length() ;i++){
            if(i > start && num.charAt(start) == '0') return;

            String currNum = num.substring(start,i+1);
            long currNumVal = Long.parseLong(currNum);

            if(start == 0){
                dfs(num, target, i+1, currNumVal, currNumVal, exp + currNum, res);
            }else{
                dfs(num, target, i+1, currValue + currNumVal, currNumVal,exp + "+" + currNum,res);
                dfs(num, target, i+1, currValue - currNumVal, -currNumVal,exp + "-" + currNum,res);
                dfs(num, target, i+1, currValue - lastOperand + lastOperand * currNumVal,lastOperand * currNumVal,exp + "*" + currNum,res);
            }
        }
    }
}
