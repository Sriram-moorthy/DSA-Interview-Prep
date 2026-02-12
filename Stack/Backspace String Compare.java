class Solution {
    public boolean backspaceCompare(String s, String t) {
        return finalString(s).equals(finalString(t));
    }
    public String finalString(String s){
        Stack<Character> stack = new Stack<Character>();
        int n1=s.length();
        int i=0;
        while(i<n1){
            if(s.charAt(i)!='#') stack.push(s.charAt(i));
            else{
                if(!stack.isEmpty()) stack.pop();
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : stack) sb.append(ch);
        return sb.toString();
    }
}
