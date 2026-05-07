class Solution {
    public String removeKdigits(String num, int k) {
        if(k > num.length()) return "";
        if(k == num.length()) return "0";
        Stack<Character> stack = new Stack<>();

        for(char ch : num.toCharArray()){
            while(!stack.isEmpty() && k > 0 && stack.peek() > ch){
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        while(!stack.isEmpty() && k > 0){
            stack.pop();
            k--;
        }
        if(stack.isEmpty()) return "0";


        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        while(sb.length() > 0 && sb.charAt(sb.length()-1) == '0'){
            sb.deleteCharAt(sb.length()-1);
        }
        sb.reverse();
        if(sb.length() == 0) return "0";
        return sb.toString();

    }
}
