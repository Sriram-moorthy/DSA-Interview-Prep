class Solution {
    public long subArrayRanges(int[] nums) {
        return subarraySumsMax(nums) - subarraySumsMin(nums);
    }
    public long subarraySumsMax(int[] nums){
        int[] nge = findNGE(nums);
        int[] pgee = findPGEE(nums);

        long sum = 0;
        
        for(int i = 0 ;i < nums.length ;i++){
            int left = i - pgee[i];
            int right = nge[i] - i;

            long freq = ((long)right * (long)left);
            sum += (nums[i] * freq);
        }
        return sum;
    }
    public long subarraySumsMin(int[] nums){
        int[] nse = findNSE(nums);
        int[] psee = findPSEE(nums);

        long sum = 0;
        
        for(int i = 0 ;i < nums.length ;i++){
            int left = i - psee[i];
            int right = nse[i] - i;

            long freq = ((long)right * (long)left);
            sum += (nums[i] * freq);
        }
        return sum;
    }

    public int[] findNSE(int[] nums){
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];

        for(int i=n-1 ; i>=0 ;i--){
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]){
                stack.pop();
            }
            ans[i] = !stack.isEmpty() ? stack.peek() : n;
            stack.push(i);
        }
        return ans;
    }
    public int[] findNGE(int[] nums){
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];

        for(int i=n-1 ; i>=0 ;i--){
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]){
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
    public int[] findPGEE(int[] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();

        int[] ans = new int[n];

        for(int i = 0 ; i < n ; i++){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                stack.pop();
            }
            ans[i] = !stack.isEmpty() ? stack.peek() : -1;
            stack.push(i);
        }
        return ans;
    }
}
