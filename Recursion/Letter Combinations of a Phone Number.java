class Solution {
    public List<String> letterCombinations(String digits) {
        String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        ArrayList<String> result = new ArrayList<>();
        generate(digits,"",result,map);
        return result;
    }
    public void generate(String digits,String current,ArrayList<String> result,String[] map){
        if(current.length()==digits.length()){
            result.add(current);
            return;
        }
        int num = digits.charAt(current.length())-'0';
        String letters = map[num];
        for(char ch : letters.toCharArray()){
            generate(digits,current+ch,result,map);
        }
    }
}
