class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] preSum = new int[row][col];

        for(int j = 0 ; j < col ; j++){
            int sum = 0;
            for(int i = 0 ; i < row ; i++){
                if(matrix[i][j] == '1'){
                    sum += 1;
                }
                else{
                    sum = 0;
                }
                preSum[i][j] = sum;
            }
        }
        int maxArea = 0;
        for(int i = 0 ; i < row ;i++){
            maxArea = Math.max(maxArea, largestRectangle(preSum[i]));
        }
        return maxArea;
    }
    public int largestRectangle(int[] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;
        for(int i = 0 ; i < n ; i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                int element = stack.pop();
                int nse = i;
                int pse = stack.isEmpty() ? -1 : stack.peek();

                maxArea = Math.max(maxArea , (arr[element] * (nse - pse -1)));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int element = stack.pop();
            int nse = n;
            int pse = stack.isEmpty() ? -1 : stack.peek();

            maxArea = Math.max(maxArea, (arr[element] * (nse - pse -1)));
        }
        return maxArea;
    }
}
