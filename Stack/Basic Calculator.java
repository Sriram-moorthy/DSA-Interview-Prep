class Solution {
    public int calculate(String s) {

        Stack<Integer> stack = new Stack<Integer>();
        int num = 0, sign = 1, result = 0;

        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }
            else if(ch == '+' || ch == '-'){
                result += (num*sign);
                num = 0;
                sign = (ch == '+') ? 1 : -1;
            }
            else if(ch == '('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }
            else if(ch == ')'){
                result += (sign * num);
                num = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        result += sign * num;
        return result;
    }
}
