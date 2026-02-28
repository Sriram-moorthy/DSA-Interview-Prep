class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(list, 0, 0, "", n);
        return list;
    }
    private void generate(List<String> list, int open, int close, String pair, int max){
        if(pair.length() == max*2){
            list.add(pair);
            return;
        }
        if(open < max){
            generate(list, open + 1, close, pair+"(", max);
        }
        if(open > close){
            generate(list, open, close + 1, pair+")",max);
        }
    }
}
