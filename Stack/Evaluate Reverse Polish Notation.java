class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        int a,b;
        for(String i : tokens){
            switch(i){
                case "+" -> stack.push(stack.pop()+stack.pop());
                case "-" -> {
                    b=stack.pop();
                    a=stack.pop();
                    stack.push(a-b);
                }
                case "*" -> stack.push(stack.pop()*stack.pop());
                case "/" -> {
                    b=stack.pop();
                    a=stack.pop();
                    stack.push(a/b);
                }
                default -> stack.push(Integer.parseInt(i));
            }
        }
        return stack.pop();
    }
    
}
