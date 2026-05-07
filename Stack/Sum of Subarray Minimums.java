class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] nse = findNSE(arr);
        int[] psee = findPSEE(arr);
        int mod = (int)1e9 + 7;
        int sum = 0;

        for(int i = 0 ; i < arr.length ; i++){
            int left = i - psee[i];
            int right = nse[i] - i;

            long freq = (left * right) % mod;

            int val = (int)((arr[i] * freq) % mod);

            sum = (sum + val) % mod;
        }
        return sum;
    }
    public int[] findNSE(int[] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        for(int i = n-1 ;i >= 0 ;i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }

            ans[i] = !stack.isEmpty() ? stack.peek() : n;
            stack.push(i);
        }
        return ans;
    }

    public int[] findPSEE(int[] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();

        int[] ans = new int[n];

        for(int i = 0 ; i < n ; i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }
            ans[i] = !stack.isEmpty() ? stack.peek() : -1;
            stack.push(i);
        }
        return ans;
    }
}
