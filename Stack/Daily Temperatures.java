class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        if(n==1) return new int[] {0};
        Stack<Integer> stack = new Stack<Integer>();
        int arr[] = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && temperatures[i]>=temperatures[stack.peek()]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                arr[i]=stack.peek()-i;
            }
            stack.push(i);
        }

        return arr;
    }
}
