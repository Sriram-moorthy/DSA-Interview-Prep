class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        int n = asteroids.length;
        
        for(int i=0;i<asteroids.length;i++){
            boolean destroyed = false;
            while(!stack.isEmpty() && stack.peek()>0 && asteroids[i]<0){
                if(Math.abs(asteroids[i]) > Math.abs(stack.peek())){
                    stack.pop();
                    continue;
                }
                else if(Math.abs(asteroids[i] ) == Math.abs(stack.peek())){
                    stack.pop();
                }
                destroyed = true;
                break;
            }
            if(!destroyed){
                stack.push(asteroids[i]);
            }

        }
        int[] ans = new int[stack.size()];
        int k=0;
        for(int num : stack){
            ans[k]=num;
            k++;
        }
        return ans;
    }
}
