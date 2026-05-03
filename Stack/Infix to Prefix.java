import java.util.Stack;

class Solution {
    public String infixToPrefix(String s) {
        StringBuilder sb = new StringBuilder();
        
        // Step 1: Reverse the string and swap parentheses
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') {
                sb.append('(');
            } else if (c == '(') {
                sb.append(')');
            } else {
                sb.append(c);
            }
        }
        String str = sb.toString();
        
        StringBuilder result = new StringBuilder();
        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            } else if (ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    result.append(st.peek());
                    st.pop();
                }
                if (!st.isEmpty()) {
                    st.pop(); // Remove '('
                }
            } else {
                while (!st.isEmpty() && st.peek() != '(' && 
                       (priority(st.peek()) > priority(ch) || 
                       (priority(st.peek()) == priority(ch) && ch == '^'))) {
                    result.append(st.peek());
                    st.pop();
                }
                st.push(ch);
            }
        }
        
        while (!st.isEmpty()) {
            result.append(st.peek());
            st.pop();
        }
        
        // Reverse the result to get the correct prefix expression
        return result.reverse().toString();
    }
    
    public static int priority(char ch) {
        if (ch == '^') {
            return 3;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else if (ch == '+' || ch == '-') {
            return 1;
        }
        return -1;
    }
}
